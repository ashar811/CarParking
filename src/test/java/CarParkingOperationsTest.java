import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class CarParkingOperationsTest {

    private CarParkingOperations operations = new CarParkingOperations();

    @Test
    public void testEnterParking() throws Exception {
        Car car = new Car("AB122", LocalDateTime.now());
        List<Car> parkedCars = new ArrayList<>();
        parkedCars.add(car);
        operations.enterParking(parkedCars, "AB123");
        Assert.assertEquals(parkedCars.size(),2);
    }
    @Test
    public void testEnterParkingForAlreadyParkedCar() throws Exception {
        Car car = new Car("AB122", LocalDateTime.now());
        List<Car> parkedCars = new ArrayList<>();
        parkedCars.add(car);
        operations.enterParking(parkedCars, "AB122");
        Assert.assertEquals(parkedCars.size(),1);
    }

    @Test
    public void testExitParking() throws Exception {
        Car car = new Car("AB123", LocalDateTime.now().minusHours(2));
        Long hours = null;
        List<Car> parkedCars = new ArrayList<>();
        parkedCars.add(car);
        hours = operations.exitParking(parkedCars,"AB123");
        Assert.assertEquals(hours*CarParkingUtils.PARKING_CHARGE_PER_HOUR,4);
        Assert.assertEquals(parkedCars.size(),0);
    }

    @Test
    public void testExitParkingIfCarNotParked() throws Exception {
        Car car = new Car("AB123", LocalDateTime.now().minusHours(2));
        Long hours = null;
        List<Car> parkedCars = new ArrayList<>();
        parkedCars.add(car);
        hours = operations.exitParking(parkedCars,"AB122");
        Assert.assertEquals(parkedCars.size(),1);
    }

}