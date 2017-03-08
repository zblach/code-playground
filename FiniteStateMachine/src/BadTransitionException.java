public class BadTransitionException extends IllegalArgumentException {
    public BadTransitionException(State s1, State s2) {
        super(String.format("Bad Transition %s -> %s", s1, s2));
    }
}
