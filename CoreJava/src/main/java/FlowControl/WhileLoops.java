package FlowControl;

public class WhileLoops {
    public static void main(String[] args) {
        boolean compare = 6 < 1;

        System.out.println(compare);

        int value = 0;
        while(value < 10) {
            value += 1;
            System.out.println("Value: " + value);
        }
    }
}
