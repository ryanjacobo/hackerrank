package sorting_lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();

        animals.add("tiger");
        animals.add("lion");
        animals.add("cat");
        animals.add("snake");
        animals.add("mongoose");
        animals.add("elephant");

        Collections.sort(animals, new StringLengthComparator());

        System.out.println(animals);

        Collections.sort(animals, new AlphabeticalComparator());
        System.out.println(animals);

        Collections.sort(animals, new ReverseAlphabeticalComparator());
        System.out.println(animals);

        for(String animal: animals){
            System.out.println(animal);
        }

        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(3);
        numbers.add(1);
        numbers.add(34);
        numbers.add(73);
        numbers.add(40);

        Collections.sort(numbers);

        System.out.println(numbers);

        Collections.sort(numbers, new Comparator<Integer>(){
            public int compare(Integer num1, Integer num2){
                return -num1.compareTo(num2);
            }
        });
        System.out.println(numbers);

        Collections.reverse(numbers);
        System.out.println(numbers);

        List<Person> people = new ArrayList<Person>();

        people.add(new Person(1, "Joe"));
        people.add(new Person(3, "Bob"));
        people.add(new Person(4, "Claire"));
        people.add(new Person(2, "Sue"));

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getId() > o2.getId()) {
                   return 1;
                }
                if (o1.getId() < o2.getId()){
                    return -1;
                }
                return 0;
                //compareTo doesn't work
//            return o1.getId().compareTo(o2.getId());
            }
        });

        for(Person person: people){
            System.out.println(person);
        }

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        System.out.println(people);
    }
}

// Sort by length of String
class StringLengthComparator implements Comparator<String>{
    public int compare(String s1, String s2){
        if(s1.length() > s2.length()){
            return 1;
        }
        if(s1.length()<s2.length()){
            return -1;
        }
        return 0;
    }
}

class AlphabeticalComparator implements Comparator<String>{
    public int compare(String s1, String s2){
        return s1.compareTo(s2);
    }
}

class ReverseAlphabeticalComparator implements Comparator<String>{
    public int compare(String s1, String s2){
        return -s1.compareTo(s2);
    }
}

class Person{
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}