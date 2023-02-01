package Lists;

import java.util.ArrayList;

public class ArrayListLesson {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>(); // "Integer" must be capitalized (non-primitive). "()" holds the size of the ArrayList. 10 is the default(blank).
        numbers.add(12);
        numbers.add(22);
        numbers.add(16);
        System.out.println(numbers);
        System.out.println(numbers.get(0));

        // looping through an ArrayList
        for(int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        // removing items from an ArrayList
        System.out.println("removing ArrayList items");
        numbers.remove(numbers.size() - 2); // the number represents 22

        // removing items slow method
//        numbers.remove(0);

        // shortcut
        System.out.println("For-loop shortcut");
        for(Integer num: numbers) {
            System.out.println(num);
        }
    }
}
