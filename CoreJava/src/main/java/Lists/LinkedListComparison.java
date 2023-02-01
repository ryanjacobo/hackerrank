package Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListComparison {

    // "List<>" is an interface whereas ArrayList, LinkedList, etc. are classes. List<> recognizes all types of List i.e. ArrayList, LinkedList, etc.
    private static void doTimings(String type, List<Integer> list) {
        for(int i = 0; i<1e5; i++) {
            list.add(i); // adding to the end
//            System.out.println(i);
        }

        long start = System.currentTimeMillis();

        for(int i = 0; i<1e5; i++) {
//            list.add(i);
//            list.add(0, i); // adding to the beginning of the list
//            list.add(list.size(), i); // adding to the beginning of the list
            list.add(list.size() - 100, i); // adding close to the end
//            list.add(0 + 100, i); // adding close to the beginning
//            System.out.println(i);

        }

        long end = System.currentTimeMillis();

        System.out.println(type + " time taken: " + (end - start) + " ms");
    }

    public static void main(String[] args) {
        // ArrayList and LinkedList can also be declared as List<> since they implement List<>. This is called abstraction.
        ArrayList<Integer> arrayList = new ArrayList<Integer>(); // ArrayList works better for adding/removing items at the end or close to the end of the list. ArrayList have to count backwards to find where the element should be added.
        LinkedList<Integer> linkedList = new LinkedList<Integer>(); // LinkedList works for adding/removing items anywhere else in the list (close to the beginning, middle). LinkedList elements has a reference of both the previous and next elements from them.

        doTimings("ArrayList", arrayList);
        doTimings("LinkedList", linkedList);
    }
}
