package MapsSets;

import java.util.*;

class Person {
    private static int count = 1;
    private int id = count;

    private String name;

//    public Person(String personName) {
    public Person(int personId, String personName) {
        this.id = personId;
        this.name = personName;
//        count++;
    }
    public String toString() {
        return id + ": " + name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


}
public class CustomMethods {

    public static void main(String[] args) {
        Map<Integer, String> numbers = new TreeMap<Integer, String>();
        numbers.put(4, "four");
        numbers.put(1, "one");
        numbers.put(3, "three");
        numbers.put(2, "two");
        numbers.put(2, "two");
        numbers.put(4, "four");

        for(Integer key: numbers.keySet()) {
            System.out.println(key + ": " + numbers.get(key));
        }

//        Person p1 = new Person("Bob");
//        Person p2 = new Person("Sue");
//        Person p3 = new Person("Mike");
//        Person p4 = new Person("Sue");

        Person p1 = new Person(1,"Bob");
        Person p2 = new Person(2,"Sue");
        Person p3 = new Person(3,"Mike");
        Person p4 = new Person(2,"Sue");

        Set<Person> set = new LinkedHashSet<>();
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);

        System.out.println(set);
    }

}
