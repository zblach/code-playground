import java.util.Set;

public class Gearbox implements Transition {

    private State gearbox = State.PARK;

    @Override public Gearbox moveTo(State s) {
        gearbox = gearbox.moveTo(s);
        return this;
    }

    @Override public Set<State> nextStates() {
        return gearbox.nextStates();
    }

    @Override public Set<State> prevStates() {
        return gearbox.prevStates();
    }

    @Override public State getState() {
        return gearbox;
    }

    public void setState(State s) {
        System.err.printf("Manually overriding state. %s -> %s\n", gearbox, s);
        gearbox = s;
    }
}
