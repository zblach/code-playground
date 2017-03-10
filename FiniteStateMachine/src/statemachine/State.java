package statemachine;

import org.jetbrains.annotations.NotNull;

import java.util.Set;


public interface State<E extends State<E>> {
    @NotNull Set<E> nextStates();
}

