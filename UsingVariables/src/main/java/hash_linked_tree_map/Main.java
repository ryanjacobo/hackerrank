package hash_linked_tree_map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        // Key-Value Pair
        HashMap<Integer, String> keyValue = new HashMap<Integer, String>();

        keyValue.put(5, "five");
        keyValue.put(6, "six");
        keyValue.put(7, "seven");
        keyValue.put(8, "eight");
        keyValue.put(9, "nine");

        String text = keyValue.get(6);

        System.out.println(text);

        // Iterating through a HashMap
        for(Map.Entry<Integer, String> entry: keyValue.entrySet()){
            int key = entry.getKey();
            String value = entry.getValue();

            System.out.println(key + ": " + value);
        }

        System.out.println("--------------HashMap-----------------"); // No guarantee of numerical order
        Map<Integer, String> hashMap = new HashMap<Integer, String>();
        testMap(hashMap);

        System.out.println("--------------LinkedHashMap-----------------"); // follows the order of when the element was added
        Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();
        testMap(linkedHashMap);

        System.out.println("--------------TreeMap-----------------"); // will always arrange the elements by numerical order of the keys
        Map<Integer, String> treeMap = new TreeMap<Integer, String>();
        testMap(treeMap);

    }

    public static void testMap (Map<Integer, String> map){
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
