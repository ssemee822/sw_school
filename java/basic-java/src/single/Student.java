package single;

public class Student {
    Singleton singleton = Singleton.getSingleton();

    void setInfo(String name, int id) {
        singleton.name = name;
        singleton.id = id;
    }

    void showInfo() {
        System.out.println("name = " + singleton.name);
        System.out.println("id = " + singleton.id);
    }
}
