package statemachine.exceptions;

import org.jetbrains.annotations.NotNull;
import statemachine.State;

public class BadTransitionException extends IllegalArgumentException {
  /** Java doesn't allow generic subclasses of {@link Throwable}. */
    public <T extends State<T>> BadTransitionException(@NotNull T s1, @NotNull T s2) {
        super(String.format("Bad State Machine Transitions (%s -> %s)", s1, s2));
    }
}
