package MapsSets;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapsLesson {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>(); // HashMap doesn't save the order of the key-value elements
        hashMap.put(5, "Five");
        hashMap.put(6, "Six");
        hashMap.put(4, "Four");
        hashMap.put(3, "Three");
        hashMap.put(3, "Three");

        hashMap.put(5, "Lima"); // replaces initial keySet() 5
        String newFive = hashMap.get(5); // Maps out the Integer parameter
        System.out.println(newFive);

        // HashMap arranges the key:value by key number (most of the time)
        System.out.println("###HashMap###");
//        for(Map.Entry<Integer, String> entry: newMap.entrySet()){
//          int key = entry.getKey();
//          String value = entry.getValue();

        // Shortcut
        // "key" = first parameter of the newMap
        // "value" = second parameter of the newMap
        for(Integer key: hashMap.keySet()){
            String value = hashMap.get(key);
            System.out.println(key + ": " + value);
        }

        // Also works by just using "Map" in the variable declaration
        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<Integer, String>(); // LinkedHashMap follows the order that it was added in the list
        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>(); // TreeMap arranges the values in numerical key order

        System.out.println("###HashMap###");
        createMap(hashMap);

        System.out.println("###LinkedHashMap###");
        createMap(linkedMap);

        System.out.println("###TreeMap###");
        createMap(treeMap);

        HashMap happy = new HashMap();
        happy.put("a", 10);
        happy.put("b", 3);
        happy.put("c", 88);

        System.out.println("HashMap: " + happy);
        System.out.println(happy.get("a"));
    }

    public static void createMap (Map<Integer, String> newMap) {
        newMap.put(9, "fox");
        newMap.put(4, "cat");
        newMap.put(8, "dog");
        newMap.put(1, "giraffe");
        newMap.put(0, "swan");
        newMap.put(15, "bear");
        newMap.put(6, "snake");

        for(Integer key: newMap.keySet()){
            String value = newMap.get(key);

            System.out.println(key + ": " + value);
        }
    }
}
