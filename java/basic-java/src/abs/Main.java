package abs;

public class Main {
    public static void main(String[] args) {
        SmartPhone phone1 = new SmartPhone("phone1");

        phone1.setIsPower(true);
        phone1.call();
        phone1.internet();
    }
}
