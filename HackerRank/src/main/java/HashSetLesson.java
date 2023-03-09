import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetLesson {
    public static void main(String[] args) {
        Set<String> names = new HashSet<>();

        names.add("Walter");
        names.add("Jess");
        names.add("Skyler");
        names.add("Mike");
        names.add("Saul");

        System.out.println(names);

//        names.clear();
//        System.out.println(names);

        for(String name:names){
            System.out.println(name);
        }

        // shortcut for "for statement"
        names.forEach(System.out::println);

        Iterator<String> namesIterator = names.iterator();
        while(namesIterator.hasNext()){
            System.out.println(namesIterator.next());
        }
    }
}
