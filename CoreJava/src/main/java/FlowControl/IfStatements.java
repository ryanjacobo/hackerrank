package FlowControl;

public class IfStatements {
    public static void main(String[] args) {
        int guessNum = 5;
        int baseNum = 4;

        if(guessNum == baseNum ){
            System.out.println("They're equal!");
        } else if (guessNum < baseNum ){
            System.out.println("Go higher!");
        } else {
            System.out.println("Go Lower!");
        }
    }
}
