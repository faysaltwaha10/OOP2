//Challenge number: 4
package CodingChallenges;

import java.util.Scanner;


class InputExample {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object to read input AND CONNNECT TO THE CONSOLE

        System.out.print("Enter your name: "); // Prompt the user for their name
        String name = scanner.nextLine(); 

        System.out.print("Enter your age: "); // Prompt the user for their age
        int age = scanner.nextInt(); 

        System.out.print("Enter your height in meters: "); 
        double height = scanner.nextDouble(); 

        System.out.println("Hello, " + name + "! You are " + age + " years old and " + height + " meters tall."); // Print the collected information

        scanner.close(); // Close the scanner
    }
}