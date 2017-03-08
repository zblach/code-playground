public class Car extends Gearbox {
    private int speed = 0;
    boolean on = false;

    public void drive(int speed) {
        // may not be safe.
        if (!on)
            return;

        moveTo(State.NEUTRAL).moveTo(State.DRIVE);
        this.speed = speed;
    }
    public void park() {
        if (!on)
            return;

        // may not be safe.
        moveTo(State.PARK);
        speed = 0;
    }
    public void idle() {
        if (!on)
            return;

        moveTo(State.NEUTRAL);
    }
    public void reverse() {
        if (!on)
            return;

        if (getState() == State.REVERSE) {
            return;
        }
        if (nextStates().contains(State.REVERSE)) {
            moveTo(State.REVERSE);
            this.speed = -5;
        } else {
            throw new RuntimeException(String.format("Cannot reverse from here. State: %s", getState()));
        }
    }

    private void forcePark() {
        if (getState() == State.PARK)
            return;

        speed = 0;
        if (nextStates().contains(State.PARK)) {
            moveTo(State.PARK);
        } else {
            setState(State.PARK);
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

    public int getSpeed() {
        return speed;
    }
}
