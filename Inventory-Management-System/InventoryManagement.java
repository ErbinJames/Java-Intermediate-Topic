import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryManagement {
    static HashMap<Integer, String> inventory = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;

        do {
            displayMenu();
            //try-catch block for user input
            try {
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    System.out.println("Please enter a valid choice (1-6)");
                    continue;
                }
                choice = Integer.parseInt(input);

                //switch case to handle user input
                switch (choice) {
                    case 1:
                        addProduct();
                        break;
                    case 2:
                        updateProduct();
                        break;
                    case 3:
                        findProduct();
                        break;
                    case 4:
                        removeProduct();
                        break;
                    case 5:
                        displayInventory();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
                System.out.println(); //space
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number (1-6).");
                choice = 0;
                System.out.println();
            }
        } while (choice != 6);
    }

    //method for display menu
    public static void displayMenu() {
        System.out.println("1. Add Product");
        System.out.println("2. Update Product Name");
        System.out.println("3. Find Product by ID");
        System.out.println("4. Remove Product");
        System.out.println("5. Display Inventory");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    //method for adding product
    public static void addProduct() {
        try {
            System.out.println();//new line
            System.out.print("Enter Product ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Product Name: ");
            String name = scanner.nextLine();

            inventory.put(id, name);
            System.out.println("Product added!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format. Please enter a number.");
        }
    }

    //method for updating the product
    public static void updateProduct() {
        try {
            System.out.println();//new line
            System.out.print("Enter Product ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            if (inventory.containsKey(id)) {
                System.out.print("Enter new Product Name: ");
                String name = scanner.nextLine();

                inventory.put(id, name);
                System.out.println("Product updated!");
            } else {
                System.out.println("Product not found!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format. Please enter a number.");
        }
    }

    // method for finding a product by its ID
    public static void findProduct() {
        try {
            System.out.println();//new line
            System.out.print("Enter Product ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            if (inventory.containsKey(id)) {
                String productName = inventory.get(id);
                System.out.println("Product Found: " + productName);
            } else {
                System.out.println("Product not found!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format. Please enter a number.");
        }
    }

    //method for removing product
    public static void removeProduct() {
        try {
            System.out.println();//new line
            System.out.print("Enter Product ID to remove: ");
            int id = Integer.parseInt(scanner.nextLine());

            if (inventory.containsKey(id)) {
                inventory.remove(id);
                System.out.println("Product removed!");
            } else {
                System.out.println("Product not found!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format. Please enter a number.");
        }
    }

    //method for displaying the inventory
    public static void displayInventory() {
        System.out.println();//new line
        if (inventory.isEmpty()) {
            System.out.println("No products available!");
        } else {
            System.out.println("Current Inventory:");
            
            for (Map.Entry<Integer, String> entry : inventory.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
    }
}