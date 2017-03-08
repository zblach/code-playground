# What it is
A bit of fun with a finite state machine.

## Transition.java
This is an interface that defines how objects interact with state transition.

## State.java
An enumeration of available states, and the legal paths of translation from one to the other.

## Gearbox.java
A class that maintains state. Instantiable.

## Car.java
A device with a Gearbox in it. Defines operations to perform on the gearbox to put the car in a specific state.

## BadTransitionException
The exception thrown when attempting to move between nonadjacent states.

## DrivingDemoUnitTest
Some example calls to Car methods.


All copyrights reserved. Zak Blacher March 7, 2017
