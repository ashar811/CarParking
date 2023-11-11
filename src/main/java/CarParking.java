import java.util.*;

public class CarParking {



    public static void main(String a[]) {
        Scanner sc = new Scanner(System.in);
        List<Car> parkedCars = Collections.synchronizedList(new LinkedList<>());
        int option = 0;
        CarParkingOperations operations = new CarParkingOperations();
            while (true)    {
                System.out.println("Choose one of the below:");
                System.out.println("1. Enter parking\n2. Exit parking \n3. Exit");
                try {
                    option = sc.nextInt();
                } catch(InputMismatchException | NumberFormatException ex )   {
                    System.out.println("You have entered wrong character.");
                    sc.next();
                }

                switch(option)  {
                    case 1:
                        if (parkedCars.size() < CarParkingUtils.PARKING_CAPACITY) {
                            System.out.println("Enter the registration number");
                            String reg = sc.next();
                            operations.enterParking(parkedCars,reg);
                        }   else {
                            System.out.println("Car park is full.");
                        }

                        break;
                    case 2:
                        if (parkedCars.size() == 0) {
                            System.out.println("There are no cars in the parking.");
                        }   else {
                            System.out.println("Enter the registration number of car to be removed");
                            String reg = sc.next();
                            Long hours = operations.exitParking(parkedCars,reg);
                            if (hours != null)  {
                                System.out.println("Please pay " + hours * CarParkingUtils.PARKING_CHARGE_PER_HOUR);
                                System.out.println("You can remove the car - " + reg);
                            }
                        }
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        //System.out.println("Invalid option selected.");

                }
            }
        }

    }
