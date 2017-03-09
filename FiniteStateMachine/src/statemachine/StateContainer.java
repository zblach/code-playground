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

    public final void setState(@NotNull E state) {
        System.err.printf("Manually overriding state. %s -> %s\n", this.state, state);
        this.state = state;
    }

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
