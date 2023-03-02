import java.util.*;

public class MustDoLeetcodes {

    public static boolean containsDuplicate(int[] nums){

        // Using Set
        Set<Integer> uniques = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            // always check the Set first before adding the first element
            if (uniques.contains(nums[i])) {
                return true;
            }
            uniques.add(nums[i]);
        }
        return false;
    }

    public static boolean isAnagram(String s, String t) {

        char[] sCharArr = s.toCharArray();
        char[] tCharArr = t.toCharArray();

        Arrays.sort(sCharArr);
        Arrays.sort(tCharArr);

        System.out.println(Arrays.toString(sCharArr) + " " + Arrays.toString(tCharArr));

        return Arrays.equals(sCharArr, tCharArr) ? true : false;
    }

    // takes the first two pair that sums up the target
    public static int[] twoSum(int[] nums, int target){
        System.out.println(Arrays.toString(nums));
        System.out.println("Target: " + target);
       Map<Integer, Integer> compliments = new HashMap<>(); // store all key-value of nums

        for(int i = 0; i < nums.length; i++){
            compliments.put(nums[i], i);
        }

       for(int i = 0; i < nums.length; i++){
           int difference = target - nums[i]; // gets both key-values that would sum the target

           // check the index of first and second value and make sure one value doesn't add itself to get the target
           if(compliments.containsKey(difference) && compliments.get(difference) != i){
               return new int[]{i, compliments.get(difference)}; // return indices of complementary values
           }
       }
       return nums; // no match found
    }

    public static int[] twoSum2(int[] nums, int target){
        System.out.println(Arrays.toString(nums));
        Map<Integer, Integer> num_map = new HashMap<>(); // store all key-value of nums

        for(int i = 0; i < nums.length; i++){
            int compliment = target - nums[i];

            // Just do return when 2nd compliment value has been found
            if(num_map.containsKey(compliment)){
                System.out.println("Index: " + num_map.get(compliment));
                System.out.println("Value: " + compliment);
//                return new int[]{i, num_map.get(compliment)};
                return new int[]{num_map.get(compliment), i};
            }
            num_map.put(nums[i], i);
        }
        return nums;
//        throw new IllegalArgumentException("no match found!");
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        System.out.println(Arrays.toString(strs));

        Map<String, List<String>> groupedAnagrams = new HashMap<>();

        /*
        1. Convert String element to a char[].
        2. Sort the char[].
        3. Store the sorted char[] to a String variable.
        4. Put the String (in the variable) in the map if String is not already in the map.
        5. Determine whether or not str is already in the key of map
        6. Return the values of the groupedAnagrams.
         */

        for(String str: strs){
            char[] charArr = str.toCharArray(); // convert the String element to a char[] i.e. str[0] = [e,a,t]
            System.out.println("charArr: " + Arrays.toString(charArr));
            Arrays.sort(charArr); // sort the letters of charArr
            String sortedStr = String.valueOf(charArr);  // charArr sorted
            System.out.println("sortedStr: " + sortedStr);
            if(!groupedAnagrams.containsKey(sortedStr)){
                groupedAnagrams.put(sortedStr, new ArrayList<>());
            }
            System.out.println("add(str): " + groupedAnagrams.get(sortedStr).add(str));
            System.out.println("get(sortedStr): " + groupedAnagrams.get(sortedStr));
        }
        return new ArrayList<>(groupedAnagrams.values());
    }

    public static int[] topKFrequent(int[] nums, int k){
        System.out.println("nums: " + Arrays.toString(nums));
        // key = element, value = element frequency
        Map<Integer, Integer> numFreq = new HashMap<>();
        // priority queue to sort the values according to max value (occurences)
        Queue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(numFreq.get(a), numFreq.get(b)));

        // put all elements in the Map with their corresponding value(count)
        for(int num : nums){
            System.out.println("num: " + num);
            numFreq.put(num, numFreq.getOrDefault(num, 0) + 1); // getOrDefault gets the value of the key (if not already in the map) and adds 1 to the value at every reoccurance.
        }
        System.out.println("numFreq sorted by num: " + numFreq); // show key=value of each num

        // add all numFreq keys to pq
        for(int num: numFreq.keySet()){
            pq.add(num);

            // top k frequent element
            if(pq.size() > k){
                System.out.println("pq: " + pq);
                System.out.println("pq.size(): " + pq.size());
                System.out.println("remove element: " + pq.poll());
            }
        }
        System.out.println("pq: " + pq); // answer obtained in Queue<Integer> type

        // convert Queue<Integer> to int[]
        int[] res = pq.stream().mapToInt(Integer::intValue).toArray();
        return res;

//        int[] res = new int[pq.size()];
//        int index = 0;
//        while(pq.isEmpty() == false){
//            res[index++] = pq.poll();
//        }
//        return res;
    }

    public static int[] productExceptSelf(int[] nums){
        // return an int[] that gets the product of all the other elements except the element in the current index
        System.out.println("nums: "+ Arrays.toString(nums));
      int arrLength = nums.length;
      int[] leftProducts = new int[arrLength];
      int[] rightProducts = new int[arrLength];
      int[] outputArr = new int[arrLength];

      leftProducts[0] = 1; // initialize index 0 with 1
      rightProducts[arrLength-1] = 1; // initialize last index with 1

      // leftProducts
      for(int i=1; i<arrLength; i++){
          leftProducts[i] = nums[i-1] * leftProducts[i-1];
      }
      System.out.println("leftProducts: " + Arrays.toString(leftProducts));

      // rightProducts
      for(int i=arrLength-2; i>=0; i--){
          rightProducts[i] = nums[i+1] * rightProducts[i+1];
      }
      System.out.println("rightProducts: "+ Arrays.toString(rightProducts));

      for(int i = 0; i<arrLength;i++){
          outputArr[i]=leftProducts[i]*rightProducts[i];
          System.out.println("outputArr" + Arrays.toString(outputArr));
      }

      return outputArr;
    }

    final static char DELIMETER = '#';

    public static String encode(List<String> strs){
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            // build the string
            sb.append(str.length());
            sb.append(DELIMETER);
            sb.append(str);
        }
        return sb.toString();
    }

    public static List<String> decode(String s){
        List<String> splitS = new LinkedList<>();
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            StringBuilder sb = new StringBuilder();
            while(arr[i] != DELIMETER){
                sb.append(arr[i++]);
            }
            i++;
            int numOfChars = Integer.valueOf(sb.toString());
            int end = i + numOfChars;
            sb = new StringBuilder();
            while(i < end){
                sb.append(arr[i++]);
            }
            i--;
            splitS.add(sb.toString());
        }
        return splitS;

    }
    public static void main(String[] args) {
        System.out.println("-----Contains Duplicate-----");
        int[] nums = {1,2,3,1};
        System.out.println(Arrays.toString(nums));
        System.out.println("Is there a duplicate element: " + containsDuplicate(nums));

        System.out.println("-----Is Anagram-----");
        String s = "anagram";
        String t = "nagaram";
        System.out.println("Is anagram: " + isAnagram(s, t));

        System.out.println("-----Two Sum-----");
//        int[] numsx = {-6,15,3,6};
//        int[] numsx = {11,15,5,4};
        int[] numsx = {2,2,4};
        int target = 6;
        System.out.println("Two sums: " + Arrays.toString(twoSum(numsx, target)));
        System.out.println("Two sums 2: " + Arrays.toString(twoSum2(numsx, target)));

        System.out.println("-----Group Anagrams-----");
        String[] strs = {"eat","tea","tan","ate","nat","bat", "eta"};
        System.out.println("Anagrams: " + groupAnagrams(strs));

        System.out.println("-----Top K Frequent Elements-----");
//        int[] numsY = {1,1,1,2,2,3};
        int[] numsY = {5,1,1,7,1,3,3,5};
        int k = 2;
        System.out.println("Top " + k + " frequent numbers: " + Arrays.toString(topKFrequent(numsY, k)));

        System.out.println("------Product Except Self------");
//        int[] numsX = {1,2,3,4};
//        int[] numsX = {-1,1,0,-3,3};
//        int[] numsX = {1};
        int[] numsX = {1,2};
        System.out.println("Products except self: " + Arrays.toString(productExceptSelf(numsX)));

        System.out.println("------Encode and Decode Strings-------");
        List<String> strsX = Arrays.asList("Hello", "World");
        String encoded = encode(strsX);
        System.out.println("Encode string: " + encoded);
        System.out.println("Decode string: " + decode(encoded));
    }
}
