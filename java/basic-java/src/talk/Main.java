package talk;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NetworkAdapter adapter;
        System.out.println("Choose Network [1]WIFI [2]5G");
        int choice = sc.nextInt();
        adapter = choice == 1 ? new Wifi() : new FiveG();

        Talk talk = new Talk("test" , adapter);
        talk.writeMsg("Hello World");
        talk.sendMsg();
    }
}
