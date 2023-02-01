package FlowControl;

import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner command = new Scanner(System.in);

        System.out.print("Please enter a command: ");
        String userInput = command.nextLine();

        switch(userInput) {
            case "start":
                System.out.println("Machine started!");
                break;

            case "stop":
                System.out.println("Machine stopped!");
                break;

            default:
                System.out.println("Command not recognized.");
        }

    }
}
