package statemachine;

import org.jetbrains.annotations.NotNull;
import statemachine.exceptions.BadTransitionException;

import java.util.EnumSet;


public class StateContainer<T extends Enum<T> & State<T>> implements State<T> {
    private T state;

    @Override
    @NotNull
    public final EnumSet<T> nextStates() {
        return state.nextStates();
    }

    @Override
    @NotNull
    public final T getState() {
        return state;
    }

    protected final void setState(@NotNull T t) {
        System.err.printf("Manually overriding state. %s -> %s\n", state, t);
        state = t;
    }

    protected void moveTo(T t) throws BadTransitionException { // it would be cool if we could stack these...
        if (!state.nextStates().contains(t))
            throw new BadTransitionException(state, t);

        this.state = t;
    }

    protected StateContainer(T t) {
        state = t;
    }
}
