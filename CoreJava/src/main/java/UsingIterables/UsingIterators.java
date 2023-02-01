package UsingIterables;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class UsingIterators {
    public static void main(String[] args) {
        List<String> animals = new LinkedList<>();
        animals.add("fox");
        animals.add("cat");
        animals.add("dog");
        animals.add("rabbit");
        System.out.println(animals.get(1));

        // Java 5 and below iteration method
        System.out.println("****Old Iteration Method****");
        Iterator<String> it = animals.iterator();
//        String value = it.next();
//        System.out.println("next() value: " + value);

//        System.out.println(animals.get(0));

        while(it.hasNext()){
            String value2 = it.next();
            System.out.println(value2);

            if(value2.equals("cat")) {
                it.remove();
            }
        }

        // Modern iteration
        System.out.println("****Modern Iteration****");
        for(String animal: animals) {
            System.out.println(animal);
        }


    }
}
