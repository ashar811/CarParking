import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class CarParkingOperations {

    public  List<Car> enterParking(List<Car> parkedCars, String reg) {

            if (parkedCars.stream().anyMatch(p -> p.getRegNo().equalsIgnoreCase(reg)))  {
                System.out.println("This car is already parked");
            }   else {
                parkedCars.add(new Car(reg, LocalDateTime.now()));
                System.out.println("You can park the car");
            }


        return parkedCars;
    }

    public Long exitParking(List<Car> parkedCars, String reg) {
        Long hours = null;
            Car removedCar = parkedCars.stream().filter(p-> p.getRegNo().equalsIgnoreCase(reg)).findFirst().orElse(null);
            if (removedCar != null) {
                parkedCars.remove(removedCar);
                hours = Duration.between(removedCar.getDateTimeCarEntered(),LocalDateTime.now()).toHours();
            }   else {
                System.out.println("This car is not parked in this parking");
            }
        return hours;
        }
}
