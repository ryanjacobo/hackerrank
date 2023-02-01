package NonPrimitives;

import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {

        // Create Scanner object with name "input"
        Scanner input = new Scanner(System.in);

        // Output the prompt
//        System.out.println("Enter a line of text: ");
        System.out.print("Enter a line of text: "); // input types on the same line

        // Wait for the user to enter a line of text
//        String text = input.nextLine();
//        int value = input.nextInt(); // for integers
        double value = input.nextDouble(); // for integers

        // Print the input
//        System.out.println("You entered: " + text);
        System.out.println("You entered: " + value);
    }
}
