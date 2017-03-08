import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        car.drive(50);
    }

    @Test(expectedExceptions = BadTransitionException.class)
    public void testPark() {
        car.park();
    }

    @Test(expectedExceptions = BadTransitionException.class)
    public void testBadTransition() {
        car.drive(50);
        car.park();
    }

    @Test
    public void testDoubleDrive() {
        car.drive(50);
        car.drive(50);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testDriveToReverse() {
        car.drive(50);
        car.reverse();
    }
}
