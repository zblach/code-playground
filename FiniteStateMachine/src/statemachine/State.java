package statemachine;

import org.jetbrains.annotations.NotNull;

import java.util.EnumSet;


public interface State<E extends Enum<E> & State<E>> {
    @NotNull EnumSet<E> nextStates();
    @NotNull E getState();
}

