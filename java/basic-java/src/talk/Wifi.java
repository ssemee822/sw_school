package talk;

public class Wifi implements NetworkAdapter{
    @Override
    public void connect() {
        System.out.println("Connected to wifi");
    }

    @Override
    public void send(String message) {
        System.out.println("WIFI >> " + message);
    }
}

class FiveG implements NetworkAdapter{
    @Override
    public void connect() {
        System.out.println("Connected to 5G");
    }

    @Override
    public void send(String message) {
        System.out.println("5G >> " + message);
    }
}