package demo.car;

import statemachine.StateMachine;

final class Gearbox extends StateMachine<Gear> {
    private int timesShifted = 0;
    Gearbox() {
        super(Gear.INITIAL_STATE);
    }

    public Gearbox shift(Gear next) {
        timesShifted++;
        this.moveTo(next);
        return this;
    }

    public void forceGear(Gear state) {
        this.setState(state);
    }

    public int getShifts() {
        return timesShifted;
    }
}
