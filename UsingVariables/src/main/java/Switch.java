import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a command: ");
        String text = input.nextLine();
        switch (text) {
            case "start":
                System.out.println("Machine starting...");
                break;
            case "stop":
                System.out.println("Machine stopping...");
                break;

            default:
                System.out.println("Command not recognized.");
        }
    }
}
