package Car;

public class Sedan extends Car implements Aircon,Audio {

    public Sedan(String name){
        super.setKmperliter(12);
        super.setSpeed(200);
        super.setOiltanksize(45);
        super.setSeat(4);
        super.setName(name);
    }

    @Override
    public void printAircon(){
        System.out.println(this.name + " : 오디오 ON" );
    }

    @Override
    public void printAudio(){
        System.out.println(this.name + " : 자율주행 ON" );
    }

    @Override
    public void setMode(boolean isOn){
        if(isOn)
            super.setSeat(5);
    }
}
