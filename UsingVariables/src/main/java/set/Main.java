package set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        //Sets don't add items that are duplicate of any items that are already in the list
//        Set<String> set1 = new HashSet<String>(); //Does not retain order
//        Set<String> set1 = new LinkedHashSet<String>(); //Remembers the order you added items in
        Set<String> set1 = new TreeSet<String>(); // sorts the list (alphabetically)

        set1.add("dog");
        set1.add("cat");
        set1.add("mouse");
        set1.add("snake");
        set1.add("bear");

        System.out.println("set1: " + set1);

        set1.add("cat");
        set1.add("dog");
        set1.add("fox");
        set1.add("bear");
        System.out.println("set1 + fox: "+ set1);

//        for(String element: set1){
//            System.out.println(element);
//        }

        if(set1.contains("lion")){
            System.out.println("Contains lion");
        } else {
            System.out.println("No lion.");
        }

        if(set1.contains("fox")){
            System.out.println("Contains fox");
        }

        System.out.println("----------set2----------");
        Set<String> set2 = new TreeSet<String>();

        set2.add("dog");
        set2.add("cat");
        set2.add("giraffe");
        set2.add("monkey");
        set2.add("ant");

        System.out.println("set2: " + set2);
        System.out.println("--------intersection(set1)-----------");
        Set<String> intersection = new HashSet<String>(set1);
        System.out.println("Just a rename of set1: " + intersection);

        System.out.println("----------retainAll-----------");
        intersection.retainAll(set2);
        System.out.println(intersection); // retains only the elements common to set2 and intersection

        System.out.println("-----------difference----------");
        Set<String> difference = new HashSet<String>(set1);

        difference.removeAll(set2); // set1 - set2
        System.out.println(difference);

    }


}
