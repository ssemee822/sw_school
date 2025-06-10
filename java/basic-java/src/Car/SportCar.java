package Car;

public class SportCar extends Car implements Audio, AutoDrive {
    private boolean isOption;
    public SportCar(String name) {
        setKmperliter(8);
        setSpeed(250);
        setOiltanksize(30);
        setSeat(2);
        setName(name);
    }

    @Override
    void setMode(boolean isOn) {
        if (isOn) {
            super.setSpeed(250*1.2);
        }
    }

    @Override
    public void printAudio() {
        System.out.println(this.name + " : 오디오 ON" );
    }

    @Override
    public void printAutoDrive() {
        System.out.println(this.name + " : 자율주행 ON" );
    }
}
