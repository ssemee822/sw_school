package polymorphism;

import java.util.Scanner;

public class DriveMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Driver driver1 = new Driver("ksm");
        Vehicle vehicle1 = new Vehicle();
        SportCar sportCar1 = new SportCar();
        Sedan sedan1 = new Sedan();
        SUV suv1 = new SUV();

        System.out.println("Choose your car type [1]sport car [2]sedan [3] suv ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                driver1.drive(sportCar1);
                break;
            case 2:
                driver1.drive(sedan1);
                break;
            case 3:
                driver1.drive(suv1);
                break;
            default:
                driver1.drive(vehicle1);
                break;
        }

    }
}
