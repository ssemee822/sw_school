package Car;

public class Bus extends Car implements Aircon, AutoDrive{
    Bus(String name){
        super.setKmperliter(5);
        super.setSpeed(150);
        super.setOiltanksize(100);
        super.setSeat(20);
        super.setName(name);
    }

    @Override
    void setMode(boolean isOn) {
        if(isOn){
            this.oiltanksize = this.oiltanksize + 30;
        }
    }

    @Override
    public void printAircon() {
        System.out.println(this.name +": 에어컨 ON" );
    }

    @Override
    public void printAutoDrive() {
        System.out.println(this.name +": 자율주행 ON" );
    }
}
