package generics;
import java.util.ArrayList;
import java.util.HashMap;

public class ArrList {
    public static void main(String[] args) {
        // ArrayList is generic class
        ArrayList<String> fruits = new ArrayList<String>(); // ArrayList doesn't have any specified length
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("orange");

        String fruit = fruits.get(1);
        System.out.println(fruit);

        fruit = fruits.get(0);
        System.out.println(fruit);

        //
        HashMap<Integer, String> map = new HashMap<Integer, String>();
    }
}
