import org.jetbrains.annotations.NotNull;

public class BadTransitionException extends IllegalStateException {
    public BadTransitionException(@NotNull State s1, @NotNull State s2) {
        super(String.format("Bad Transition %s -> %s", s1, s2));
    }
}
