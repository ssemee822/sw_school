package polymorphism;

public class Driver {
    String name;

    public Driver(String name) {
        this.name = name;
    }

    void drive(Vehicle vehicle) {
        System.out.print(name + "'s ");
        vehicle.run();
    }
}
