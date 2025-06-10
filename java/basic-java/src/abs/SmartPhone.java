package abs;

public class SmartPhone extends Phone {
    public SmartPhone(String name) {
        super(name);
    }

    @Override
    void call() {
        System.out.println("Calling SmartPhone");
    }

    public void internet() {
        System.out.println("Internet");
    }
}
