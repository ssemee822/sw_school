package Car;

abstract public class Car {
    double speed;
    double consume;
    double time;
    int kmperliter;
    int oiltanksize;
    int movecount;
    int distance;
    int oilcount;
    int price;
    int seat;
    String name;

    public void setConsume() {
        this.consume = this.distance/this.kmperliter;
    }

    public void setMovecount(int passenger) {
        this.movecount = (int) Math.ceil((double) passenger /this.seat);
    }

    public void setDistance(int num) {
        int arr[] = {400,150,200,300};
        this.distance = arr[num-1]*this.movecount;
    }

    public void setOilcount() {
        this.oilcount = (int) Math.ceil(this.consume/oiltanksize);
    }

    public void setPrice() {
        this.price = (int)this.consume*2000;
    }

    public void setTime(int weather) {
        double num[] = {0, 1.0, 1.2, 1.4};
        this.time = this.distance/this.speed*num[weather];
    }

    public void setKmperliter(int kmperliter) {
        this.kmperliter = kmperliter;
    }

    public void setOiltanksize(int oiltanksize) {
        this.oiltanksize = oiltanksize;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getOilcount() {
        return oilcount;
    }

    public int getPrice() {
        return price;
    }

    public double getTime() {
        return time;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract void setMode(boolean isOn);
}
