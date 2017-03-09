package demo;

import statemachine.StateContainer;

public class Gearbox extends StateContainer<Gear> {
    protected Gearbox() {
        super(Gear.INITIAL_STATE);
    }
}
