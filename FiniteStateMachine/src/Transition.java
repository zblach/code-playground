import java.util.Set;

public interface Transition {
    Transition moveTo(State s);
    Set<State> nextStates();
    Set<State> prevStates();
}
