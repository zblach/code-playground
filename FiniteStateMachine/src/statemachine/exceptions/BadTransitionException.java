package statemachine.exceptions;

import org.jetbrains.annotations.NotNull;
import statemachine.State;

public class BadTransitionException extends IllegalArgumentException {
    /** Returns an exception for when {@code s1} cannot transition to {@code s2}. */
    public static <T extends State<T>>
    BadTransitionException badTransitionException(@NotNull T s1, @NotNull T s2) {
        return new BadTransitionException(s1, s2);
    }

  /**
   * Private so that all clients must use the type-safe static method above.
   * Java doesn't allow generic subclasses of {@link Throwable}.
   */
    private BadTransitionException(@NotNull State<?> s1, @NotNull State<?> s2) {
        super(String.format("Bad State Machine Transitions (%s -> %s)", s1, s2));
    }
}
