package iterators;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> animals = new LinkedList<String>();

        animals.add("fox");
        animals.add("cat");
        animals.add("dog");
        animals.add("rabbit");

        for(String animal: animals) {
            System.out.println(animal);
        }

        System.out.println("--------Iterator---------");
        Iterator<String> it = animals.iterator();

        while(it.hasNext()){
            String value = it.next();
            System.out.println(value);

            // remove an element
            if(value.equals("cat")){
                it.remove();
            }

        }
        // add an element
        animals.add("sheep");
        System.out.println(animals);
    }
}
