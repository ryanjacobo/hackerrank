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
        // key = element, value = element frequency
        Map<Integer, Integer> numFreq = new HashMap<>();

        for(int num : nums){
            numFreq.put(num, numFreq.getOrDefault(num, 0) + 1);
        }

        // define min heap with size k
        Queue<Integer> minHeap = new PriorityQueue<>((a,b) -> numFreq.get(a) - numFreq.get(b));

        // top k frequent element
        for(int num: numFreq.keySet()){
            minHeap.add(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        int[] res = new int[minHeap.size()];
        int index = 0;
        while(minHeap.isEmpty() == false){
            res[index++] = minHeap.poll();
        }
        return res;
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
        int[] numsY = {1,1,1,2,2,3};
        int k = 2;
        System.out.println("Top " + k + " frequent numbers: " + Arrays.toString(topKFrequent(numsY, k)));

    }
}
