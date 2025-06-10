package tv;

public class protoType {
    boolean isPower;
    int channel;
    int volume;

//    public protoType() {}

    public protoType(boolean isPower, int channel, int volume) {
        this.isPower = isPower;
        this.channel = channel;
        this.volume = volume;
    }

    public void setChannel(int channel) {
        if (channel > 0 && channel < 1000){
            this.channel = channel;
        }
        else {
            System.out.println("channel out of range");
        }
    }

    public void setPower(boolean power) {
        isPower = power;
    }
}
