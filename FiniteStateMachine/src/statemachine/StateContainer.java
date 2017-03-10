package statemachine;

import org.jetbrains.annotations.NotNull;
import statemachine.exceptions.BadTransitionException;

import java.util.EnumSet;


public class StateContainer<E extends Enum<E> & State<E>> implements State<E> {
    private E state;

    @Override
    public final @NotNull EnumSet<E> nextStates() {
        return state.nextStates();
    }

    @Override
    @NotNull
    public final E getState() {
        return state;
    }

    /**
     * Manually set the internal state, bypassing state control flow.
     *
     * This is a mechanism meant to be used in the event of error recovery or abnormal state flow.
     * It logs to stderr when called.
     *
     * @param state: The state to be set.
     */
    public final void setState(@NotNull E state) {
        System.err.printf("Manually overriding state. %s -> %s\n", this.state, state);
        this.state = state;
    }

    /**
     * Move the internal state to the next one.
     *
     * @param nextState The next state.
     * @return this object itself. This supports the chaining of move states.
     * @throws BadTransitionException if we attempt to move to a state that isn't nextable from here.
     */
    public final StateContainer<E> moveTo(@NotNull E nextState) throws BadTransitionException {
        if (!state.nextStates().contains(nextState))
            throw new BadTransitionException(state, nextState);

        state = nextState;
        return this;
    }

    public StateContainer(@NotNull E initialState) {
        state = initialState;
    }
}
