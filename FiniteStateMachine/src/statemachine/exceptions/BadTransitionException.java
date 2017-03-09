package statemachine.exceptions;

import org.jetbrains.annotations.NotNull;
import statemachine.State;

public class BadTransitionException extends IllegalStateException {
    public BadTransitionException(@NotNull State s1, @NotNull State s2) {
        super(String.format("Bad State Machine Transitions (%s -> %s)", s1, s2));
    }
}
