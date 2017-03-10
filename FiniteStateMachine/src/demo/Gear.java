package demo;

import org.jetbrains.annotations.NotNull;
import statemachine.State;

import java.util.EnumSet;

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
}
