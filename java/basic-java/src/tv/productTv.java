package tv;

public class productTv extends protoType {
    String name;
    boolean isInternet;

    public productTv(boolean isPower, int channel, int volume, boolean isInternet) {
        super(isPower, channel, volume);
        this.isInternet = isInternet;
        this.name = "TV";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.volume = volume;
            System.out.println("Volume set to " + volume);
        }
        else {
            System.out.println("Volume out of range");
        }
    }

    @Override
    public void setChannel(int channel) {
        if (channel > 0 && channel < 2000){
            this.channel = channel;
            System.out.println("Channel set to " + channel);
        }
        else {
            System.out.println("channel out of range");
        }
    }

    public void setChannel(int channel, boolean isInternet) {
        if (isInternet) {
            System.out.println("Internet mode");
            this.isInternet = true;
        }
        else {
            this.isInternet = false;
            if (channel > 0 && channel < 2000){
                this.channel = channel;
                System.out.println("Channel set to " + channel);
            }
            else {
                System.out.println("channel out of range");
            }
        }
    }

    void viewTV() {
        System.out.println("name: " + name);
        System.out.println("power: " + isPower);
        System.out.println("channel: " + channel);
        System.out.println("volume: " + volume);
        System.out.println("internet mode: " + isInternet);
    }
}
