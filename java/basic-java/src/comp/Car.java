package comp;

public class Car implements Comparable<Car>{
    String name;
    int year;
    String color;

    public Car(String name, int year, String color) {
        this.name = name;
        this.year = year;
        this.color = color;
    }

    @Override
    public int compareTo(Car o) {
        if (this.year == o.year) {
            return this.name.compareTo(o.name);
        } else if (this.year < o.year) {
            return -1;
        } else {
            return 1;
        }
    }
}
