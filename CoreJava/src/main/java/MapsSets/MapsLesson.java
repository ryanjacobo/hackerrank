package MapsSets;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapsLesson {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        hashMap.put(5, "Five");
        hashMap.put(6, "Six");
        hashMap.put(4, "Four");
        hashMap.put(3, "Three");
        hashMap.put(3, "Three");

//        map.put(5, "Lima"); // replaces initial map

        String text = hashMap.get(5); // Maps out the Integer parameter
        System.out.println(text);

        // HashMap arranges the key:value by key number (most of the time)
        System.out.println("###HashMap###");
//        for(Map.Entry<Integer, String> entry: map.entrySet()){
//          int key = entry.getKey();
//          String value = entry.getValue();
        // Shortcut
        for(Integer key: hashMap.keySet()){
            String value = hashMap.get(key);

            System.out.println(key + ": " + value);
        }

        // Also works by just using "Map" in the variable declaration
        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<Integer, String>(); // LinkedHashMap follows the order that it was added in the list
        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>(); // TreeMap arranges the values in numerical key order

        System.out.println("###HashMap###");
        testMap(hashMap);

        System.out.println("###LinkedHashMap###");
        testMap(linkedMap);

        System.out.println("###TreeMap###");
        testMap(treeMap);
    }

    public static void testMap (Map<Integer, String> map) {
        map.put(9, "fox");
        map.put(4, "cat");
        map.put(8, "dog");
        map.put(1, "giraffe");
        map.put(0, "swan");
        map.put(15, "bear");
        map.put(6, "snake");

        for(Integer key: map.keySet()){
            String value = map.get(key);

            System.out.println(key + ": " + value);
        }
    }
}
