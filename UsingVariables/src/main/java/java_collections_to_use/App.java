package java_collections_to_use;

import java.util.*;

public class App {

    //////////// LISTS /////////////////////
    // Store lists of objects
    // Objects remain in order
    // Duplicates are allowed

    // ArrayList - ideal for just adding or removing items at end of list
    List<String> list1 = new ArrayList<String>();

    /////////// SETS /////////////
    // Stores only unique values
    // Not indexed, unlike lists
    // Fast in checking if a particular object exists

    // HashSet is not ordered
    Set<String> set1 = new HashSet<String>();

    // Sorted in natural order
    Set<String> set2 = new TreeSet<String>();

    // Elements remain in order they were added
    Set<String> set3 = new LinkedHashSet<String>();

    /////////// MAPS ////////////
    // Key value pairs
    // Retrieving a value by key is fast

    // Keys not in any particular order, order changes
    Map<String, String> map1 = new HashMap<String, String>();

    // Keys sorted in natural order
    Map<String, String> map2 = new TreeMap<String, String>();

    // Keys remain in order added
    Map<String, String> map3 = new LinkedHashMap<String, String>();
}
