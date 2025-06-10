package coffee;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuMain {
    static Map<String, MenuInfo> map = new HashMap<>();
    public static void main(String[] args) {
        makeMenu();
        selectMenu();
    }
    static void makeMenu() {
        map.put("Americano", new MenuInfo("Americano", 2000, "Coffe", "basic coffee"));
        map.put("Espresso", new MenuInfo("Espresso", 2000, "Coffe", "basic"));
        map.put("Latte", new MenuInfo("Latte", 3000, "Coffe", "Milk basic"));
    }
    static void selectMenu() {
        Scanner scanner = new Scanner(System.in);
        String key;
        while (true) {
            System.out.println("Please select an option");
            System.out.println("[1]menu list [2]find menu [3]add menu [4]remove menu [5]edit menu [6]exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("=".repeat(10) + "menu list" + "=".repeat(10));
                    for (String e : map.keySet()) {
                        System.out.println("menu: " + map.get(e).getName());
                        System.out.println("price: " + map.get(e).getPrice());
                        System.out.println("category: " + map.get(e).getCategory());
                        System.out.println("description: " + map.get(e).getDescription());
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("=".repeat(10) + "find menu" + "=".repeat(10));
                    System.out.print("input menu name:");
                    scanner.nextLine();
                    key = scanner.nextLine();
                    if (map.containsKey(key)) {
                        System.out.println("menu: " + map.get(key).getName());
                        System.out.println("price: " + map.get(key).getPrice());
                        System.out.println("category: " + map.get(key).getCategory());
                        System.out.println("description: " + map.get(key).getDescription());
                    } else{
                        System.out.println("menu not found");
                    }
                    break;
                case 3:
                    System.out.println("=".repeat(10) + "add menu" + "=".repeat(10));
                    System.out.print("enter menu name: ");
                    scanner.nextLine();
                    key = scanner.nextLine();
                    if (!map.containsKey(key)) {
                        System.out.print("input price: ");
                        int price = scanner.nextInt();
                        System.out.print("input category: ");
                        scanner.nextLine();
                        String category = scanner.nextLine();
                        System.out.print("input description: ");
                        String description = scanner.nextLine();
                        map.put(key, new MenuInfo(key, price, category, description));
                    } else {
                        System.out.println("menu is already exists");
                    }
                    break;
                case 4:
                    System.out.println("=".repeat(10) + "remove menu" + "=".repeat(10));
                    System.out.print("enter menu name: ");
                    scanner.nextLine();
                    key = scanner.nextLine();
                    if (map.containsKey(key)) {
                        map.remove(key);
                        System.out.println("menu removed");
                    } else {
                        System.out.println("menu not found");
                    }
                    break;
                case 5:
                    System.out.println("=".repeat(10) + "edit menu" + "=".repeat(10));
                    System.out.print("enter menu name: ");
                    scanner.nextLine();
                    key = scanner.nextLine();
                    if (map.containsKey(key)) {
                        System.out.print("enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.print("enter new price: ");
                        int newPrice = scanner.nextInt();
                        System.out.print("enter new category: ");
                        scanner.nextLine();
                        String newCategory = scanner.nextLine();
                        System.out.print("enter new description: ");
                        String newDescription = scanner.nextLine();
                        map.replace(key, new MenuInfo(newName, newPrice, newCategory, newDescription));
                    } else {
                        System.out.println("menu not found");
                    }
                    break;
                case 6:
                    System.out.println("=".repeat(10) + "exit"+ "=".repeat(10));
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}
