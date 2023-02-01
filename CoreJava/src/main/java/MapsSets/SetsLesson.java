package MapsSets;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetsLesson {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<String>(); // HashSet arranges the items in no particular order; randomly
//        Set<String> set1 = new LinkedHashSet<String>(); // LinkedHashSet remembers the order of the items
//        Set<String> set1 = new TreeSet<String>(); // TreeSet arranges the items alphabetically

        set1. add("dog");
        set1. add("cat");
        set1. add("mouse");
        set1. add("snake");
        set1. add("bear");

        set1.add("dog"); // set ignores duplicates

        System.out.println(set1);

        // Iterate through the set
        for(String element: set1) {
            System.out.println(element);
        }

        // "contains" checks if set contains a specific item
        if (set1.contains("cat")) {
            System.out.println("Yes, set contains cat");
        }

        if (set1.contains("elephant")){
            System.out.println("This will not show.");
        }

        Set<String> set2 = new TreeSet<String>();

        set2.add("dog");
        set2.add("cat");
        set2.add("giraffe");
        set2.add("monkey");
        set2.add("ant");
        System.out.println(set2);
        System.out.println(set1);

        // retainAll gets the common items between two sets
        Set<String> intersection = new HashSet<String>(set1); // creates a copy of set1 to not affect set1
//        set1.retainAll(set2);
        System.out.println(set1);

        // removeAll gets the difference between two sets
        set1.removeAll(set2);
        System.out.println(set1);
    }
}
