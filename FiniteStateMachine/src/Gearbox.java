import java.util.Set;

public class Gearbox implements Transition {

    private State internalState = State.PARK;

    @Override public Gearbox moveTo(State s) {
        internalState = internalState.moveTo(s);
        return this;
    }

    @Override public Set<State> nextStates() {
        return internalState.nextStates();
    }

    @Override public Set<State> prevStates() {
        return internalState.prevStates();
    }

    public State getState() {
        return internalState;
    }

    public void setState(State s) {
        System.err.printf("Manually overriding state. %s -> %s\n", internalState, s);
        internalState = s;
    }
}
