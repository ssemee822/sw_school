package tv;

public class tvMain {
    public static void main(String[] args) {
        productTv TV1 = new productTv(false, 11, 20, false);
        TV1.setName("TV1");
        TV1.setVolume(30);
        TV1.setChannel(20, true);
        TV1.viewTV();
    }
}
