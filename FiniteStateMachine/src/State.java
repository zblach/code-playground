import org.jetbrains.annotations.NotNull;

import java.util.Collections;
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


    @NotNull private final Set<State> nextStates = new HashSet<>();
    @NotNull private final Set<State> prevStates = new HashSet<>();

    @NotNull @Override public State moveTo(@NotNull State s) throws BadTransitionException {
        if (!this.nextStates.contains(s))
            throw new BadTransitionException(this, s);

        return s;
    }

    @NotNull @Override public Set<State> nextStates() {
        return Collections.unmodifiableSet(nextStates);
    }

    @NotNull @Override public Set<State> prevStates() {
        return Collections.unmodifiableSet(prevStates);
    }

    @NotNull @Override public State getState() {
        return this;
    }

    private void setNextStates(State ...states) {
        for (State state: states) {
            this.nextStates.add(state);
            state.prevStates.add(this);
        }
    }
}
