import java.util.Scanner;

class AgeRestrictionException extends Exception {
    public AgeRestrictionException(String message) {
        super(message);
    }
}

public class AgeVerification {
    //method to check the age
   static void checkAge(int age) throws AgeRestrictionException {
    if(age < 18) {
        throw new AgeRestrictionException("You must be at least 18 to register.");
    }
   }

   public static void main (String[] args) {
    Scanner scanner = new Scanner(System.in);

    //implements try-catch block
    try {
        //prompt the user for the age
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        // check age using method
        checkAge(age);
        
        // if no exception thrown
        System.out.println("Registration successful!");
    } catch (AgeRestrictionException e) {
        //catch custom exception
        System.out.println("Error: " + e.getMessage());
    } catch (Exception e) {
        // catch othr unexpected exceptions
        System.out.println("An unexpected error occured");
    } finally {
        //close the scanner
        scanner.close();
    }
   }
}
