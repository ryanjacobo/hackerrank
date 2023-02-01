package natural_ordering_bylength;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<Person>();
        SortedSet<Person> set = new TreeSet<Person>();

        addElements(list);
        showElements(list); // Not sorted - appears how it's ordered in the method

        System.out.println();
        addElements(set);
        showElements(set); //SortedSet already sorts the List

        System.out.println();
        Collections.sort(list);
        showElements(list);
    }

    private static void addElements(Collection<Person> col){
        col.add(new Person ("Joe"));
        col.add(new Person ("Sue"));
        col.add(new Person( "Juliet"));
        col.add(new Person ("Clare"));
        col.add(new Person ("Mike"));
    }

    private static void showElements(Collection<Person> col){
        for(Person element: col){
            System.out.println(element);
        }
    }
}

// implements Comparable<Person> is Natural ordering (sort by length)
class Person implements Comparable<Person>{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        if(name.length()>o.name.length()){
            return 1;
        }
        else if(name.length()<o.name.length()){
            return -1;
        }
        else {
//            return 0;
            return name.compareTo(o.name);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
