import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double grade; 

    //constructor 
    Student (String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public void updateGrade(double newGrade) {
        this.grade = newGrade;
    }
}

public class StudGradeManagement {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        
        // do-while loop for handling usr input
        do {
            displayMenu();
            choice = Integer.parseInt(scanner.nextLine());

            switch(choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    updateGrade();
                    break;
                case 4: 
                    removeStudent();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                System.out.println("Invalid choice. Try again");
            }
            System.out.println();//space
        } while (choice != 5);
    }

    //method to display menu
    public static void displayMenu(){
        System.out.println("1. Add Student");
        System.out.println("2. Display Students");
        System.out.println("3. Update Grade");
        System.out.println("4. Remove Student");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    //method to add student
    public static void addStudent() {
        //prompt for student name
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        //prompt for student grade
        System.out.print("Enter grade: ");
        double grade = Double.parseDouble(scanner.nextLine());

        Student student = new Student(name, grade);
        students.add(student);
        System.out.println("Student added!");
    }

    //method to display students
    public static void displayAllStudents() {
        if (students.isEmpty()){
            System.out.println("No students available");
        } else {
            System.out.println("Students List: ");
            for (Student student: students) {
                System.out.println(student.name + " - " + student.grade);
            }
        }
    }
    //method to update grade
    public static void updateGrade() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        boolean found = false;

        //for each loop 
        for (Student student : students) {
            if (student.name.equalsIgnoreCase(name)) {
                System.out.print("Enter new grade: ");
                double newGrade = Double.parseDouble(scanner.nextLine());
                
                student.updateGrade(newGrade);
                System.out.println("Grade updated!");
                found = true;
                break;
            }
        }
        //if student name is not found or not inside the list
        if (!found) {
            System.out.println("Student not found");
        }
    }

    //method to remove student
    public static void removeStudent() {
        System.out.print("Enter student name to remove: ");
        String name = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).name.equalsIgnoreCase(name)) {
                students.remove(i);
                System.out.println("Student removed!");
                found = true;
                break;
            }
        }
        //if student name is not found or not inside the list
        if (!found) {
            System.out.println("Student not found.");
        }
    }
}