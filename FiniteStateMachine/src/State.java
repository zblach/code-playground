import java.util.HashSet;
import java.util.Set;

public enum State implements Transition {
    PARK,
    NEUTRAL,
    REVERSE,
    DRIVE;

    static {
        PARK.setNextStates(
                NEUTRAL, REVERSE
        );
        NEUTRAL.setNextStates(
                PARK, REVERSE, DRIVE
        );
        REVERSE.setNextStates(
                NEUTRAL, PARK
        );
        DRIVE.setNextStates(
                NEUTRAL
        );
    }


    private final Set<State> nextStates = new HashSet<>();
    private final Set<State> prevStates = new HashSet<>();

    @Override public State moveTo(State s) throws BadTransitionException {
        if (!this.nextStates.contains(s))
            throw new BadTransitionException(this, s);

        return s;
    }

    @Override public Set<State> nextStates() {
        return nextStates;
    }

    @Override public Set<State> prevStates() {
        return prevStates;
    }

    private void setNextStates(State ...states) {
        for (State state: states) {
            this.nextStates.add(state);
            state.prevStates.add(this);
        }
    }
}
