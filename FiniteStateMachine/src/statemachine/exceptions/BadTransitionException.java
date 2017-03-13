package statemachine.exceptions;

import org.jetbrains.annotations.NotNull;
import statemachine.State;

public class BadTransitionException extends IllegalStateException {
    public <T extends Enum<T> & State<T>, U extends Enum<U> & State<U>> BadTransitionException(@NotNull T s1, @NotNull U s2) {
        super(String.format("Bad State Machine Transition (%s -> %s)", s1, s2));
    }
}
