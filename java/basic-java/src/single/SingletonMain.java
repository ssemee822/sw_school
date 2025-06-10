package single;

public class SingletonMain {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();

        student1.setInfo("student1", 1);
        student2.showInfo();
    }
}
