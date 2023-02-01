import java.util.LinkedList;
import java.util.List;

public class Quiz {
    int x = 1;

    public int generateNumber() {
        return 3;
    }
    public void Quiz() {
        int y = generateNumber();
        this.x = y;
    }

    public int getNumber() {
        int x= 2;
        x++;
        return x * 10;
    }

    public static String transform(String s) {
        String newStr = s.replace("e","a");
        return newStr;
    }

    public static double doStuff() {
        return 10.3;
    }

    private static void doSomething(int i){
        if(0>i){
            throw new IllegalArgumentException();

        } else {
            // do something else
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3,9,5,9,1,2};
        System.out.println(arr[2]);

        List<String> myCollection = new LinkedList<>();

        Quiz e = new Quiz();
        int y = e.getNumber();
        System.out.println(y);

        String[] words = {"hello", "goodbye", "aloha", "qwerty"};
        for (String w : words) {
            System.out.println(transform(w));
        }

        boolean flag = true;
        int x = 0;
        while(flag) {
            x++;
            if (x == 10) {
                x++;
                break;
            }
        }
        System.out.println(x);

        long l1 = 5;
        int i1 = 3;
        double d1 = doStuff();
        System.out.println(i1 + d1 + l1);

        boolean b1 = true;
        boolean b2 = false;
        if (b1 || b2) {
            System.out.println("foo");
        }
        if (b1 && b2) {
            System.out.println("bar");
        }
        if (!b1) {
            System.out.println("baz");
        } else if (!b2) {
            System.out.println("bat");
        } else {
            System.out.println("zab");
        }

        doSomething(-1);

        String a = "Hello";
        String b = "World";
        a = a + b;
//        a = new String("Hello");
        String c = "World";
    }
}
