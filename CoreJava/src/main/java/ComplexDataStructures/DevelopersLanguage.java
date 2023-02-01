package ComplexDataStructures;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class DevelopersLanguage {
        // static means the variable is gonna be used in the class only
        public static String[] languages = {"java", "angular", "devops"};
        public static String[][] developers = {
                {"Martin", "John", "Lewis"},
                {"Ray", "David", "Steve"},
                {"Gary", "Steve", "Francis", "Gina"}
        };

    public static void main(String[] args) {
        Map<String, Set<String>> mappedDevs = new HashMap<>();

        for(int i = 0; i < languages.length; i++) {
            String language = languages[i];
            String[] devs = developers[i];
            Set<String> devSet = new LinkedHashSet<>();

            for(String dev: devs) {
                devSet.add(dev);
            }
            mappedDevs.put(language, devSet);
        }
        System.out.println(mappedDevs);


    }
}
