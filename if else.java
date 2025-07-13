package oop work;

public class Choices {
    public static void main(String[] args) {

        java.util.Scanner scanner = new java.util.Scanner(System.in); // Create a Scanner object to read input

        System.out.print("Enter the student's grade: "); // Prompt the user for input
        
        int studentGrade = scanner.nextInt(); // Read the student's grade from input

        if (studentGrade >= 90) {
            System.out.println("You have an A. Excellent work!");
        } else if (studentGrade >= 80) {
            System.out.println("You have a B. Good job!");
        } else if (studentGrade >= 70) {
            System.out.println("You have a C. Keep improving!");
        } else if (studentGrade >= 35) {
            System.out.println("You have a D. You need to work harder.");
        } else {
            System.out.println("You have an F. Please see your instructor for help.");
        }
    }
}