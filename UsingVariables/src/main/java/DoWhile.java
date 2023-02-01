import java.util.Scanner;

public class DoWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 5;
        do{
            System.out.print("Enter a number: ");
            number = scanner.nextInt();
        } while(number!=5);
        System.out.println("Got 5!");
    }

















}
