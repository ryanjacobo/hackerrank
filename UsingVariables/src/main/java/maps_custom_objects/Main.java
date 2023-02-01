package maps_custom_objects;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Map is for <String, Integer> parameters
        Map<String, Integer> map = new HashMap<String, Integer>();

        map.put("one", 1);
        map.put("two", 2);
        map.put("three",3);
        map.put("four", 4);

        System.out.println(map.keySet()); // keySet() is the key list

        for(String key: map.keySet()){
            System.out.println(key + ": " + map.get(key));
        }

        // Set is for <String>
        Set<String> set = new LinkedHashSet<String>();

        set.add("dog");
        set.add("cat");
        set.add("mouse");
        set.add("cat");

        System.out.println(set);

        Person p1 = new Person(1, "Bob");
        Person p2 = new Person(2, "Sue");
        Person p3 = new Person(3, "Mike");
        Person p4 = new Person(2, "Sue");

        Map<Person, Integer> map2 = new LinkedHashMap<Person, Integer>();

        map2.put(p1, 1);
        map2.put(p2, 2);
        map2.put(p3, 3);
        map2.put(p4, 1);

        System.out.println(map2);

        for(Person key: map2.keySet()){
            System.out.println(key + ": " + map2.get(key));
        }

        Set<Person> set2 = new LinkedHashSet<Person>();

        set2.add(p1);
        set2.add(p2);
        set2.add(p3);
        set2.add(p4);

        System.out.println(set2);
    }

}
class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Removes duplicates (equals and hashcode)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

