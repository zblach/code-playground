package statemachine;

import org.jetbrains.annotations.NotNull;
import statemachine.exceptions.BadTransitionException;

import java.util.Set;


/**
 * A machine that has states of type {@code E} and knows its current state.
 * It can transition between states, and will throw a {@link BadTransitionException}
 * if an invalid transition is attempted.
 */
public class StateMachine<E extends State<E>> {
    private E state;

    public StateMachine(@NotNull E initialState) {
        state = initialState;
    }

    /** Convenience method for calling {@link #getState()}.{@link State#nextStates() nextStates()} */
    public final @NotNull Set<E> nextStates() {
        return state.nextStates();
    }

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
    public final StateMachine<E> moveTo(@NotNull E nextState) throws BadTransitionException {
        if (!state.nextStates().contains(nextState)) {
            throw new BadTransitionException(state, nextState);
        }

        state = nextState;
        return this;
    }
}
