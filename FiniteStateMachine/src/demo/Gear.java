package demo;

import org.jetbrains.annotations.NotNull;
import statemachine.State;

import java.util.*;
/*
public enum Gear implements State<Gear> {
    PARK {
        @Override
        public @NotNull EnumSet<Gear> nextStates() {
            return EnumSet.of(NEUTRAL, REVERSE);
        }
    },
    NEUTRAL {
        @Override
        public @NotNull EnumSet<Gear> nextStates() {
            return EnumSet.of(PARK, REVERSE, DRIVE);
        }
    },
    REVERSE {
        @Override
        public @NotNull EnumSet<Gear> nextStates() {
            return EnumSet.of(NEUTRAL, PARK);
        }
    },
    DRIVE {
        @Override
        public @NotNull EnumSet<Gear> nextStates() {
            return EnumSet.of(NEUTRAL);
        }
    };

    public static final Gear INITIAL_STATE = Gear.PARK;
}*/

public class Gear implements State<Gear> {
    private final Set<Gear> nextStates;
    public Gear() {
        nextStates = new HashSet<>();
    }

    public static final Gear PARK = new Gear(), NEUTRAL = new Gear(), REVERSE = new Gear(), DRIVE = new Gear();
    static {
        PARK.nextStates.addAll(Arrays.asList(NEUTRAL, REVERSE));
        NEUTRAL.nextStates.addAll(Arrays.asList(PARK, REVERSE, DRIVE));
        REVERSE.nextStates.addAll(Arrays.asList(NEUTRAL, PARK));
        DRIVE.nextStates.add(NEUTRAL);
    }

    public static final Gear INITIAL_STATE = PARK;

    @NotNull
    @Override
    public Set<Gear> nextStates() {
        return this.nextStates;
    }
}
