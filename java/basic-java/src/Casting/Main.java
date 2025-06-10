package Casting;

import java.util.ArrayList;

public class Main {
    ArrayList<Animal> animals = new ArrayList<Animal>();
    public static void main(String[] args) {
        Main downCasting = new Main();
        downCasting.addAnimal();
    }
    public void addAnimal() {
        animals.add(new Animal());
        animals.add(new Human());
        animals.add(new Tiger());
        animals.add(new Eagle());

        for (Animal animal : animals) {
            animal.move();
        }
    }
    public void testCasting() {
        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            if (animal instanceof Human) {
                Human human = (Human) animal;
                human.readBook();
            } else if (animal instanceof Tiger) {
                Tiger tiger = (Tiger) animal;
                tiger.move();
            } else if (animal instanceof Eagle) {
                Eagle eagle = (Eagle) animal;
                eagle.flying();
            } else {
                System.out.println("Unknown animal type");
            }
        }
    }
}
