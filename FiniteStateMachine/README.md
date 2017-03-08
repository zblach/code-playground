# What it is
A bit of fun with a finite gear machine.

## statemachine/Transition
This is an interface that defines how objects interact with gear transition.

## statemachine/State
The interface that defines a state.

## statemachine/StateContainer
A class that maintains a state. Instantiable & changes.

## statemachine/exceptions/BadTransitionException
The exception thrown when attempting to move between nonadjacent gears.

## demo/Gear
An enumeration of available gears, and the legal paths of translation from one to the other.

## demo/Gearbox
An example of the StateContainer holding a gear.

## demo/Car
A device with a gearbox in it. Defines operations to perform on the gearbox to put the car in a specific gear.

## test/DrivingDemoUnitTest
Some example calls to Car.


All copyrights reserved. Zak Blacher March 7, 2017
