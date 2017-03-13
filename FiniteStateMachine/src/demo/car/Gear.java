package demo.car;

import org.jetbrains.annotations.NotNull;
import statemachine.State;

import java.util.EnumSet;
import java.util.Set;

public enum Gear implements State<Gear> {
    PARK {
        @Override
        public @NotNull Set<Gear> nextStates() {
            return EnumSet.of(NEUTRAL, REVERSE);
        }
    },
    NEUTRAL {
        @Override
        public @NotNull Set<Gear> nextStates() {
            return EnumSet.of(PARK, REVERSE, DRIVE);
        }
    },
    REVERSE {
        @Override
        public @NotNull Set<Gear> nextStates() {
            return EnumSet.of(NEUTRAL, PARK);
        }
    },
    DRIVE {
        @Override
        public @NotNull Set<Gear> nextStates() {
            return EnumSet.of(NEUTRAL);
        }
    };

    public static final Gear INITIAL_STATE = Gear.PARK;
}
