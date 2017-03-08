package statemachine;

public interface State<T extends Enum<T> & State<T>> extends Transition<T>{
}

