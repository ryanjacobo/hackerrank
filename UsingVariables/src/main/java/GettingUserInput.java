import java.util.Scanner;

public class GettingUserInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a line of text: ");
        String stringInput = input.nextLine();
        System.out.println("You entered: " + stringInput);

        System.out.print("Enter an integer: ");
        int intInput = input.nextInt();
        System.out.println("You entered: "+intInput);

        System.out.print("Enter a floatvalue: ");
        double doubleInput = input.nextDouble();
        System.out.println("You entered: "+ doubleInput);
    }
}
