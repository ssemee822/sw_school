package Car;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("이동 지역 선택 [1]부산 [2]대전 [3]강릉 [4]광주 : ");
        int region = Integer.parseInt(scanner.nextLine());

        System.out.println("이동할 승객 수 입력 : ");
        int passenger = Integer.parseInt(scanner.nextLine());

        System.out.println("이동할 차량 선택 [1]스포츠카 [2]승용차 [3]버스 : ");
        int type = Integer.parseInt(scanner.nextLine());
        Car car;
        switch (type) {
            case 1:
                car = new SportCar("포르쉐 911");
                break;
            case 2:
                car = new Sedan("그랜저");
                break;
            case 3:
                car = new Bus("시외버스");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        };

        System.out.println("부가 기능 [1]ON [2]OFF : ");
        boolean option = Integer.parseInt(scanner.nextLine()) == 1;

        System.out.println("날씨 [1]맑음 [2]비 [3]눈 : ");
        int weather = Integer.parseInt(scanner.nextLine());

        car.setMode(option);
        car.setMovecount(passenger);
        car.setDistance(region);
        car.setConsume();
        car.setOilcount();
        car.setPrice();
        car.setTime(weather);

        double time = car.getTime();
        int hour = (int) time;
        int minute = (int) ((time - hour) * 60);
        int price = car.getPrice();
        String formatted = String.format("%,d", price);


        System.out.println(" ");
        switch (type) {
            case 1:
                ((SportCar) car).printAudio();
                ((SportCar) car).printAutoDrive();
                break;
            case 2:
                ((Sedan) car).printAudio();
                ((Sedan) car).printAircon();
                break;
            case 3:
                ((Bus) car).printAircon();
                ((Bus) car).printAutoDrive();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        };
        System.out.println("======="+car.getName()+"=======");
        System.out.println("총 비용 : " + formatted + "원");
        System.out.println("총 주유 횟수 : " + car.getOilcount() + "회");
        System.out.println("총 이동 시간 : " + hour + "시간 " + minute + "분");

    }
}
