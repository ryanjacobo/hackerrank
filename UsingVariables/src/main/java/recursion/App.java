package recursion;

import org.w3c.dom.ls.LSOutput;

public class App {
    public static void main(String[] args) {
        System.out.println(calculate(5));
        System.out.println(calculate(1));
        System.out.println(calculate(2)); // calculate(1)*2

    }


    private static int calculate(int value) {
//        System.out.println(value);
        if(value == 1){
            return 1;
        }

        // using recursive for calculating factorial of a value
        return calculate(value - 1) * value;

    }
}
