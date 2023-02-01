package Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class StringLengthComparator implements Comparator<String> {
    // Added method from Comparator<>
    @Override
    public int compare(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if(len1 > len2){
            return 1;
        }
        else if(len2 > len1) {
            return -1;
        }
        return 0;
    }
}

class ReverseAlphabeticalComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return -o1.compareTo(o2); // "-" reverses alphabetical arrangement
    }
}

class Person implements Comparable<Person>{
    private int id;
    public String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", " + "name: " + name;
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }
}

public class SortLists {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();

        animals.add("cat");
        animals.add("elephant");
        animals.add("tiger");
        animals.add("lion");
        animals.add("mongoose");

        // sorts list alphabetically
        Collections.sort(animals);
        Collections.sort(animals, new ReverseAlphabeticalComparator());

        for(String animal: animals){
            System.out.println(animal);
        }

        System.out.println("***Using Custom Class***");
        // sort by length of String using anonymous class
        Collections.sort(animals, new StringLengthComparator());
        for(String animal: animals){
            System.out.println(animal);
        }

        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(3);
        numbers.add(36);
        numbers.add(73);
        numbers.add(40);
        numbers.add(1);


        // Sort integer list
        System.out.println("***Sort Integers***");
//        Collections.sort(numbers);
        // Reverse numerical order
        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });
        System.out.println(numbers);
        for(Integer number: numbers) {
            System.out.println(number);
        }

        // Sort Arbitrary classes
        List<Person> people = new ArrayList<>();

        people.add(new Person(4, "Joe"));
        people.add(new Person(1, "Sue"));
        people.add(new Person(2, "Bob"));
        people.add(new Person(3, "Claire"));

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                // Sort by ID
//                if(o1.getId()>o2.getId()){
//                    return 1;
//                }
//                else if(o2.getId()>o1.getId()){
//                    return -1;
//                }
//                return 0;

                // Sort by name
                return o1.getName().compareTo(o2.getName());
            }
        });

        for(Person person: people){
            System.out.println(person);
        }
    }
}
