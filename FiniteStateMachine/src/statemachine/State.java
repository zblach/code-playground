package statemachine;

public interface State<T extends Enum & State<T>> extends Transition<T>{
}
