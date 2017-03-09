package demo;

public class Car extends Gearbox{

    private int speed = 0;
    private boolean on = false;

    public void drive(int speed) {
        // may not be safe.
        if (!on)
            return;

        moveTo(Gear.NEUTRAL);
        moveTo(Gear.DRIVE);
        this.speed = speed;
    }
    public void park() {
        if (!on)
            return;

        // may not be safe.
        moveTo(Gear.PARK);
        speed = 0;
    }
    public void idle() {
        if (!on)
            return;

        moveTo(Gear.NEUTRAL);
    }
    public void reverse() {
        if (!on)
            return;

        if (getState() == Gear.REVERSE) {
            return;
        }
        if (nextStates().contains(Gear.REVERSE)) {
            moveTo(Gear.REVERSE);
            this.speed = -5;
        } else {
            throw new RuntimeException(String.format("Cannot reverse from here. demo.Gear: %s", getState()));
        }
    }

    private void forcePark() {
        if (getState() == Gear.PARK)
            return;

        speed = 0;
        if (nextStates().contains(Gear.PARK)) {
            moveTo(Gear.PARK);
        } else {
            setState(Gear.PARK);
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
