package Lists;

import java.util.*;

class Person2 implements Comparable<Person2>{
    private String name;

    public Person2(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Person2 person) {
        int len1 = name.length();
        int len2 = person.name.length();

        if(len1 > len2){
            return 1;
        }
        else if(len2 > len1) {
            return -1;
        } else {
            return name.compareTo(person.name);
        }
    }
}
public class NaturalOrder {
    public static void main(String[] args) {
        List<Person2> list = new ArrayList<>();
        Set<Person2> set = new TreeSet<>();

        addElements(list);
        System.out.println("***LIST***");
        Collections.sort(list); // Must add "implements Comparable to Person class" after replacing String to Person
        showElements(list);

        addElements(set);
        System.out.println("***SET***");
        showElements(set);
    }

    private static void addElements(Collection<Person2> col){
        col.add(new Person2("Joe"));
        col.add(new Person2("Sue"));
        col.add(new Person2("Juliet"));
        col.add(new Person2("Clare"));
        col.add(new Person2("Mike"));
    }

    private static void showElements(Collection<Person2> col) {
//        String param = col;
//        header(param);
        for(Person2 element: col){
            System.out.println(element);
        }
    }

    static void header(String param){
        if(param == "list"){
            System.out.println("***LIST***");
        } else if (param == "set"){
            System.out.println("***SET***");
        }
    }

}
