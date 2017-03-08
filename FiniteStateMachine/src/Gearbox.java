import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class Gearbox implements Transition {

    @NotNull private State gearbox = State.PARK;

    @NotNull @Override public final Gearbox moveTo(@NotNull State s) throws BadTransitionException {
        gearbox = gearbox.moveTo(s);
        return this;
    }

    @NotNull @Override public final Set<State> nextStates() {
        return gearbox.nextStates();
    }

    @NotNull @Override public final Set<State> prevStates() {
        return gearbox.prevStates();
    }

    @NotNull @Override public final State getState() {
        return gearbox;
    }

    protected final void setState(@NotNull State s) {
        System.err.printf("Manually overriding state. %s -> %s\n", gearbox, s);
        gearbox = s;
    }
}
