package statemachine;

import org.jetbrains.annotations.NotNull;

import java.util.Set;

public interface State<T extends State<T>> {
    @NotNull Set<T> nextStates();
}
