import java.util.Set;

public interface Transition {
    Transition moveTo(State s) throws BadTransitionException;
    Set<State> nextStates();
    Set<State> prevStates();
    State getState();
}
