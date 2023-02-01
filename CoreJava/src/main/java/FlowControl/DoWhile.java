package FlowControl;

import java.util.Scanner;

public class DoWhile {
    public static void main(String[] args) {
        Scanner number = new Scanner(System.in);

        // While Loop
//        System.out.print("Enter an integer: ");
//        int input = number.nextInt();
//
//        while(input != 5) {
//            System.out.print("Enter an integer: ");
//            input = number.nextInt();
//        }

        // Do-While Loop
        int input = 0;
        do {
            System.out.print("Enter an integer: ");
            input = number.nextInt();
        }
        while(input != 5);

        System.out.println("Thank You!");
    }
}
