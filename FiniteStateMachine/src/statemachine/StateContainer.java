package statemachine;

import org.jetbrains.annotations.NotNull;

import java.util.Set;

public abstract class StateContainer<T extends Enum<T> & State<T>> implements Transition<T> {
    private T state;

    @Override
    @NotNull
    @SuppressWarnings("unchecked")
    public final Set<T> nextStates() {
        return state.nextStates();
    }

    @Override
    @NotNull
    @SuppressWarnings("unchecked")
    public final Set<T> prevStates() {
        return state.prevStates();
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

    @SuppressWarnings("unchecked")
    public <U extends Transition<T>> U moveTo(T t) {
        this.state = state.moveTo(t);
        return (U) this;
    }

    protected StateContainer(T t) {
        state = t;
    }
}
