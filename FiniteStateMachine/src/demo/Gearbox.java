package demo;

import statemachine.StateContainer;

public class Gearbox extends StateContainer<Gear> {
    public Gearbox() {
        super(Gear.INITIAL_STATE);
    }
}
