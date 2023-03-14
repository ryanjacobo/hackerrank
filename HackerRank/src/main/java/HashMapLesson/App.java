package HashMapLesson;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Map<Employee, Integer> testMap = new HashMap<>();
        Employee java = new Employee("Java", 1, 10000.00);
        Employee techies = new Employee("Techies", 2, 20000.00);
        Employee angular = new Employee("Angular", 3, 15000.00);
        Employee html = new Employee("HTML", 4, 12000.00);
        testMap.put(java, 1); // put takes 2 parameters - key and value
        testMap.put(techies, 2);
        testMap.put(techies, 3);
//        testMap.put(techies, 4); // replaces previous techies values
//        testMap.put(techies, null);


        testMap.put(null, 5); // null key is accepted
        testMap.put(null, 6);
        testMap.putIfAbsent(angular, 6); // putIfAbsent means put specified value if key is not yet in the map
        testMap.remove(null);
        testMap.put(html, null);

        // getOrDefault - get value if already in the Map, otherwise, assign the value to the key.
        Employee react = new Employee("React", 5, 10000);
        String result = String.valueOf(testMap.getOrDefault(react, 1));
        testMap.put(react, 2);
        System.out.println(result);

        Employee tmKey = techies;
        int tmValue = 4;
        System.out.println("testMap contains key " + tmKey.name + ": " + testMap.containsKey(tmKey)); // checks for the specified key
        System.out.println("testMap contains value " + tmValue + ": " + testMap.containsValue(tmValue)); // checks for the specified value

        testMap.compute(techies, (k, v) -> {
            if (v != null) {
                return v.intValue() + 5;
//                return v.intValue();
            } else
                return 1;

        });

        for (Map.Entry entry : testMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
    }
}
