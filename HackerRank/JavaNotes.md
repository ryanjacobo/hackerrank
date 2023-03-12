## Primitives - immutable
### int
```java 
Math.floor(<doubleName>); // to round double values to lowest int
``` 

```java
Math.sqrt(<doubleName>); // to get squareroot of an int
```
### Array
```java
arrayName.length(<value>); // to assign the length to an array
```
```java
array.add(x); // to add an int to an array
```
```java
array.addAll(Arrays.asList(<elements>)); // to add elements to an array
```
```java
int[] arrayName = new int[<array length>]; // declare a new arrayName
```
```java
arrayName[index] = array[index]; // to add an element to an array
```
```java
<listName>.stream().mapToInt(Integer::intValue).toArray(); // to convert a List to an Array
```
```java
String[] strArr = {<elements>}; // to initialize a String array
```
```java
int[] intArray = {<elements>}; // to initialize a int array
```
```java
Arrays.toString(<arrName>); // to print an array to console
```
```java
Arrays.sort(); // to sort an int[]
```
```java
Collections.reverse(Arrays.asList(<arrayName>)); // only works with Integer[] type variable
```
```java
Integer[] IntName = Arrays.stream(intName).boxed().toArray(Integer[]::new); // convert an int[] to an Integer[];
```
```java
String.valueOf(<intArrayName>).toCharArray(); // to break up an int to a char[];
```
```java
String.valueOf(<intArrayName>).split(""); // to break up an int to a String[];
```
```java
Math.min(int x, int y, ...); // to return the min of specified integers; return the smaller (first element) of the arguments
```
```java
Set<Integer> <var name> =  Arrays.stream(<int[] name>).boxed().collect(Collectors.toSet()); // to convert an int[] to a HashSet, ideal for removing duplicate elements
```
```java
(int)Integer.toString(<intName>).chars().map(Character::getNumericValue).filter(w -> w > 0 %% n % w == 0).count(); // to convert an int to an int[] and check if each digit is a divisor of the original int

```
```java
var2 = Math.max(var1, var2); // value in var1 gets assigned to var2
```
## Non-primitives - mutable
### String
```java
<strName>.length; // get the length of a string
```
```java
<strName>.charAt(index); // retrieve specified character from a string
```
```java
<strName>.toCharArray(); // convert String to a char[];
```
```java
<strName>.substring(start index, end index); // retrieve substring of a string, end index is index of last char of substring + 1
```
### List
```java
listName.size(<value>); // to get the size of a List
```
```java
listName.get(<index>); // get the element with specified index on the list
```
```java
List<String> listName = Arrays.asList(<String>, <String>, ...); // declare and initialize a String List
```
```java
listName.addAll(Arrays.asList(<items>)); // add items in the list
```
```java
List<List<Integers>> nestedList = List.of(
        List.of(),
        List.of()
); // Add a nested list inside a list, list created will be unmodifiable
```
```java
Collections.reverse(<listName>); - reverse a list
```
```java
Collections.rotate(<listName>, k); - Shift elements of a list by k indices
```
```java
Collections.max(<listName>); - get the max value in the list
```
```java
Collections.min(<listName>); - get the min value in the list
```
```java
Collections.sort(<listName>); - sort the list in ascending order
```
```java
Collections.singleton(<element(s)>); - picks common specified elements from the list (usage example is removing common elements from a list)
```
```java
list.indexOf(<elementName>); - get the corresponding index of a given element
```
```java
list.indexOf(<element>);
```
```java
list.remove(<index>); - remove element from the list
```
```java
list.removeAll(<Collections>); - removes elements specified in the Collections
```

### Maps - HashMap, LinkedMap, TreeMap
```java
Map<dataType, dataType> <varName> = new HashMap<>(); - create a HashMap;
```
```java
`<varName>.put(key, value); - add a key-value pair to the map;
```
```java
<varName.get(key); - retrieve value of specified string;
```
```java
<mapName>.containsKey(
```

### Set - HashSet
```java
<setName>.contains(<element>); - to check if set contains the element specified, returns a boolean
```
```java
<setName>.contains(<setName>[index]); - to check if set has element being compared from another set, returns a boolean
```
```java
<setName>.clear(); - to clear the set
```
```java
<setName>.addAll(<listName>); - to add all elements in a list to a set
```
```java
Set<type> setName = new HashSet<>(<listName>); declaring and initializing a HashSet
```

### PriorityQueue
```java
Queue<> qName = new PriorityQueue<>();
```
```java
Parent value should always be less than the child value.
```
```java
parent = Arr[(i-1)/2]
```
```java
left = Arr[(2+i)+1]
```
```java
right = Arr[(2+i)+1]
```
```java
<pqName>.stream().mapToInt(Integer::intValue).toArray(); // convert PriorityQueue to int[]
```
### Iterator - iterates through a queue
```java
// to initialize an Iterator object
Iterator<Type> iterator = qName.iterator(); 
        while(iterator.hasNext()){
        System.out.println(pq.poll());
}
```
### MUST REMEMBER!!!
* Index starts at 0 while length/size starts at one. Therefore, using "<= array size/length" on a loop would result to an out of bounds error.
* **".equals()"** vs **"=="** 
  * ".equals()" compares the content in the memory while "==" compares the address (which would always be the same).
      * Example:
      ```java
        String s1 = "HELLO"; 
        String s2 = "HELLO";
        String s3 =  new String("HELLO");
        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
        System.out.println(s1.equals(s2)); // true
      ```