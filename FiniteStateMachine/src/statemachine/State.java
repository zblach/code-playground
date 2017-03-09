package statemachine;

import org.jetbrains.annotations.NotNull;

import java.util.EnumSet;


public interface State<T extends Enum<T> & State<T>> {
    @NotNull EnumSet<T> nextStates();
    @NotNull T getState();
}

