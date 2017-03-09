package demo;

public class Car {
    private Gearbox gearbox = new Gearbox();

    private int speed = 0;
    private boolean on = false;

    public void drive(int speed) {
        // may not be safe.
        if (!on)
            return;

        gearbox.moveTo(Gear.NEUTRAL).moveTo(Gear.DRIVE);
        this.speed = speed;
    }
    public void park() {
        if (!on)
            return;

        // may not be safe.
        gearbox.moveTo(Gear.PARK);
        speed = 0;
    }
    public void idle() {
        if (!on)
            return;

        gearbox.moveTo(Gear.NEUTRAL);
    }
    public void reverse() {
        if (!on)
            return;

        if (gearbox.getState() == Gear.REVERSE) {
            return;
        }
        if (gearbox.nextStates().contains(Gear.REVERSE)) {
            gearbox.moveTo(Gear.REVERSE);
            this.speed = -5;
        } else {
            throw new RuntimeException(String.format("Cannot reverse from state: %s", gearbox.getState()));
        }
    }

    private void forcePark() {
        if (gearbox.getState() == Gear.PARK)
            return;

        speed = 0;
        if (gearbox.nextStates().contains(Gear.PARK)) {
            gearbox.moveTo(Gear.PARK);
        } else {
            gearbox.setState(Gear.PARK);
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
