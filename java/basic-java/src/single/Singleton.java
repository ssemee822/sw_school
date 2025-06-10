package single;

public class Singleton {
    String name;
    int id;

    private static Singleton singleton = new Singleton();
    private Singleton() {
        name = "default-name";
        id = 1;
    }

    static Singleton getSingleton() {
        return singleton;
    }
}
