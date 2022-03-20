import java.util.Scanner;

public class StoreMenu {

    public void start() {
        Scanner input = new Scanner(System.in);
        boolean isExit = false;
        int index = 0, choice;

        // Setting available brand list.
        String[] brands = {"Samsung", "Lenovo", "Apple", "Huawei", "Casper", "Asus", "HP", "Xiaomi", "Monster"};
        for (String brand : brands) {
            Brand.addBrand(brand, index++);
        }
        while (!isExit) {
            // Printing menu.
            System.out.println("\n# PatikaStore Product Management System #");
            System.out.println("(*) Options:");
            System.out.println("1 - Notebook ");
            System.out.println("2 - Mobile Phone");
            System.out.println("3 - List Brands");
            System.out.println("0 - Exit");
            System.out.print("Enter option: ");

            // Getting input.
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    Product.processMenu(1);
                    break;
                case 2:
                    Product.processMenu(2);
                    break;
                case 3:
                    Brand.printBrands();
                    break;
                case 0:
                    isExit = true;
                    break;
                default:
                    System.out.println("\nInvalid input option.");
                    System.out.print("Enter option again: ");
            }

            if (isExit) {
                System.out.println("System shutting down.");
                break;
            }
        }
    }
}

