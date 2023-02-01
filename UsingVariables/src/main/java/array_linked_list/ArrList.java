package array_linked_list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrList {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        numbers.add(10);
        numbers.add(100);
        numbers.add(40);

        System.out.println(numbers.get(0));

        for(int i = 0; i<numbers.size(); i++){
            System.out.println(i + ": " + numbers.get(i));
        }

        // shortcut
        int i = 0;
        for(Integer number: numbers){
            System.out.println(i + ": " + number);
            i++;
        }

        numbers.remove(0);
        i=0;
        for(Integer number: numbers){
            System.out.println(i + ": " + number);
            i++;
        }

        // LinkedList (Link Interface)
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        doTimings("ArrayList", arrayList);
        doTimings("LinkedList", linkedList);
    }

    public static void doTimings(String type, List<Integer>list){
        for(int i=0; i<1E5; i++){
            list.add(i);
        }

        long start = System.currentTimeMillis();

        // Add items at end of list -- ArrayList is faster
//        for(int i=0; i<1E5; i++){
//            list.add(i);
//        }

        // add items elsewhere in the list
        for(int i=0; i<1E5; i++){
//            list.add(0, i); // add at the start of the list -- LinkedList is faster because LinkedList elements has a reference of the previous and next element
//            list.add(list.size() - 1, i); // add at the end of the list -- Arraylist is faster
            list.add(list.size() - 100, i); // add in the middle of the list -- Arraylist is faster
        }

        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + " ms for " + type);
    }
}
