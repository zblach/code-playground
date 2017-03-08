package demo;

import org.jetbrains.annotations.NotNull;
import statemachine.State;
import statemachine.exceptions.BadTransitionException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public enum Gear implements State<Gear> {
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

    public static final Gear INITIAL_STATE = Gear.PARK;


    @NotNull private final Set<Gear> nextGears = new HashSet<>();
    @NotNull private final Set<Gear> prevGears = new HashSet<>();

    @NotNull @Override public Gear moveTo(@NotNull Gear s) throws BadTransitionException {
        if (!this.nextGears.contains(s))
            throw new BadTransitionException(this, s);

        return s;
    }

    @NotNull @Override public Set<Gear> nextStates() {
        return Collections.unmodifiableSet(nextGears);
    }

    @NotNull @Override public Set<Gear> prevStates() {
        return Collections.unmodifiableSet(prevGears);
    }

    @NotNull @Override public Gear getState() {
        return this;
    }

    private void setNextStates(Gear... gears) {
        for (Gear gear : gears) {
            this.nextGears.add(gear);
            gear.prevGears.add(this);
        }
    }
}
