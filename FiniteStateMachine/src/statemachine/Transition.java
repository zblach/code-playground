package statemachine;

import statemachine.exceptions.BadTransitionException;

import java.util.Set;

public interface Transition<T extends State> {
    <U extends Transition<T>> U moveTo(T s) throws BadTransitionException;
    Set<T> nextStates();
    Set<T> prevStates();
    T getState();
}
