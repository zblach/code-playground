package demo;

import statemachine.StateMachine;

final class Gearbox extends StateMachine<Gear> {
    Gearbox() {
        super(Gear.INITIAL_STATE);
    }
}
