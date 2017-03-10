package demo;

import statemachine.StateMachine;

final class Gearbox extends StateMachine<Gear> {
    private int shifts = 0;
    Gearbox() {
        super(Gear.INITIAL_STATE);
    }
    public Gearbox shift(Gear g) {
        shifts++;
        return (Gearbox) super.moveTo(g);
    }

    public int getShifts() {
        return shifts;
    }
}
