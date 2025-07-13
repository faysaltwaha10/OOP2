import java.util.Random;

public class EightSidedDice {

    public static void main(String[] args) {
        Random random = new Random();
        int roll = random.nextInt(8) + 1; // Generates a number between 1 and 8

        System.out.println("You rolled an 8-sided die: " + roll);

        // Add a simple check for even or odd
        if (roll % 2 == 0) {
            System.out.println("The roll is an even number.");
        } else {
            System.out.println("The roll is an odd number.");
        }

        // A different kind of bonus
        int bonus;
        if (roll > 5) {
            bonus = 2;
            System.out.println("Rolled higher than 5!  Bonus of 2.");
        }
        else {
            bonus = 0;
        }

        int finalResult = roll + bonus;
        System.out.println("Final result: " + finalResult);
    }
}