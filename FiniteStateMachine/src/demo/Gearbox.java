package demo;

import statemachine.StateContainer;

final class Gearbox extends StateContainer<Gear> {
    Gearbox() {
        super(Gear.INITIAL_STATE);
    }
}
