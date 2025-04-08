package Calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            //prompt for the user input
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();
            
            //computing result
            int result = num1 / num2;
            System.out.println("Result: " + result);
        } catch (InputMismatchException e) { 
            System.out.println("Error: Invalid input. Please enter numbers only");
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed");
        }
        //close the scanner
        scanner.close();
    }
    
}
