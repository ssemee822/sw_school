package polymorphism;

public class Vehicle {
    public void run() {
        System.out.println("Vehicle is running");
    }
}

class SportCar extends Vehicle {
    @Override
    public void run() {
        System.out.println("SportCar is running");
    }
}

class Sedan extends Vehicle {
    @Override
    public void run() {
        System.out.println("Sedan is running");
    }
}

class SUV extends Vehicle {
    @Override
    public void run() {
        System.out.println("SUV is running");
    }
}