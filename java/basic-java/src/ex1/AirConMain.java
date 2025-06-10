package ex1;

public class AirConMain {
    public static void main(String[] args) {
        AirCon airCon1 = new AirCon(true, 20, 2);
        SmartAirCon smartAirCon1 = new SmartAirCon();
        PortableAirCon portableAirCon1 = new PortableAirCon();

        airCon1.setPower(false);

        airCon1.getInfo();
        System.out.println(" ");
        smartAirCon1.getInfo();
        System.out.println(" ");
        portableAirCon1.getInfo();
    }
}
