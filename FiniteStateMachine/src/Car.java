public class Car {
    private Gearbox gearbox = new Gearbox();
    private int speed = 0;

    public void drive(int speed) {
        // may not be safe.
        gearbox.moveTo(State.NEUTRAL).moveTo(State.DRIVE);
        this.speed = speed;
    }
    public void park() {
        // may not be safe.
        gearbox.moveTo(State.PARK);
        this.speed = 0;
    }
    public void idle() {
        gearbox.moveTo(State.NEUTRAL);
    }
    public void reverse() {
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

    public State getState() {
        return gearbox.getState();
    }

    public int getSpeed() {
        return speed;
    }
}
