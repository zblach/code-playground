import java.util.Set;

public class Car {
    private Gearbox gearbox = new Gearbox();
    private int speed = 0;
    boolean on = false;

    public void drive(int speed) {
        // may not be safe.
        if (!on)
            return;

        gearbox.moveTo(State.NEUTRAL).moveTo(State.DRIVE);
        this.speed = speed;
    }
    public void park() {
        if (!on)
            return;

        // may not be safe.
        gearbox.moveTo(State.PARK);
        this.speed = 0;
    }
    public void idle() {
        if (!on)
            return;

        gearbox.moveTo(State.NEUTRAL);
    }
    public void reverse() {
        if (!on)
            return;

        if (gearbox.getState() == State.REVERSE) {
            return;
        }
        if (gearbox.nextStates().contains(State.REVERSE)) {
            gearbox.moveTo(State.REVERSE);
            this.speed = -5;
        } else {
            throw new RuntimeException(String.format("Cannot reverse from here. State: %s", gearbox.getState()));
        }
    }

    private void forcePark() {
        if (gearbox.getState() == State.PARK)
            return;

        if (nextStates().contains(State.PARK)) {
            gearbox.moveTo(State.PARK);
        } else {
            gearbox.setState(State.PARK);
        }
    }

    public void turnOn() {
        forcePark();
        on = true;
    }

    public void turnOff() {
        forcePark();
        on = false;
    }

    private Set<State> nextStates() {
        return gearbox.nextStates();
    }

    public State getState() {
        return gearbox.getState();
    }

    public int getSpeed() {
        return speed;
    }
}
