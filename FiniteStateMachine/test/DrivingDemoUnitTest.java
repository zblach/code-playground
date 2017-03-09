import demo.Car;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import statemachine.exceptions.BadTransitionException;

public class DrivingDemoUnitTest {

    private Car car;

    @BeforeMethod
    public void initCar() {
        car = new Car();
        car.turnOn();
    }

    @AfterMethod
    public void turnOffCar() {
        car.turnOff();
    }

    @Test
    public void testDrive() {
        car.drive(90);
    }

    @Test(expectedExceptions = BadTransitionException.class)
    public void testPark() {
        car.park();
    }

    @Test(expectedExceptions = BadTransitionException.class)
    public void testBadTransition() {
        car.drive(100);
        car.park();
    }

    @Test
    public void testDoubleDrive() {
        car.drive(50);
        car.drive(35);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testDriveToReverse() {
        car.drive(40);
        car.reverse();
    }
}
