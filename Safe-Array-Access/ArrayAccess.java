import java.util.Scanner;

public class ArrayAccess {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        //initialize the array
        int[] numbers = {10, 20, 30, 40, 50};

        //ask for user input
        System.out.print("Enter an index (0 to 4): ");
        int userInput = scanner.nextInt();

        //Try-catch block to handle exception
        try {
            System.out.println("Element at index " + userInput + " is: " + numbers[userInput]);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid index. Please enter a number between 0 and 4.");
        }

        //close the scanner
        scanner.close();
    }
}