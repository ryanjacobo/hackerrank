import java.util.*;
import java.util.stream.Collectors;

public class MustDoLeetcodes {

    public static boolean containsDuplicate(int[] nums) {

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
    public static int[] twoSum(int[] nums, int target) {
        System.out.println(Arrays.toString(nums));
        System.out.println("Target: " + target);
        Map<Integer, Integer> compliments = new HashMap<>(); // store all key-value of nums

        for (int i = 0; i < nums.length; i++) {
            compliments.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i]; // gets both key-values that would sum the target

            // check the index of first and second value and make sure one value doesn't add itself to get the target
            if (compliments.containsKey(difference) && compliments.get(difference) != i) {
                return new int[]{i, compliments.get(difference)}; // return indices of complementary values
            }
        }
        return nums; // no match found
    }

    public static int[] twoSum2(int[] nums, int target) {
        System.out.println(Arrays.toString(nums));
        Map<Integer, Integer> num_map = new HashMap<>(); // store all key-value of nums

        for (int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];

            // Just do return when 2nd compliment value has been found
            if (num_map.containsKey(compliment)) {
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

        for (String str : strs) {
            char[] charArr = str.toCharArray(); // convert the String element to a char[] i.e. str[0] = [e,a,t]
            System.out.println("charArr: " + Arrays.toString(charArr));
            Arrays.sort(charArr); // sort the letters of charArr
            String sortedStr = String.valueOf(charArr);  // charArr sorted
            System.out.println("sortedStr: " + sortedStr);
            if (!groupedAnagrams.containsKey(sortedStr)) {
                groupedAnagrams.put(sortedStr, new ArrayList<>());
            }
            System.out.println("add(str): " + groupedAnagrams.get(sortedStr).add(str));
            System.out.println("get(sortedStr): " + groupedAnagrams.get(sortedStr));
        }
        return new ArrayList<>(groupedAnagrams.values());
    }

    public static int[] topKFrequent(int[] nums, int k) {
        System.out.println("nums: " + Arrays.toString(nums));
        // key = element, value = element frequency
        Map<Integer, Integer> numFreq = new HashMap<>();
        // priority queue to sort the values according to max value (occurences)
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(numFreq.get(a), numFreq.get(b)));

        // put all elements in the Map with their corresponding value(count)
        for (int num : nums) {
            System.out.println("num: " + num);
            numFreq.put(num, numFreq.getOrDefault(num, 0) + 1); // getOrDefault gets the value of the key (if not already in the map) and adds 1 to the value at every reoccurance.
        }
        System.out.println("numFreq sorted by num: " + numFreq); // show key=value of each num

        // add all numFreq keys to pq
        for (int num : numFreq.keySet()) {
            pq.add(num);

            // top k frequent element
            if (pq.size() > k) {
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

    public static int[] productExceptSelf(int[] nums) {
        // return an int[] that gets the product of all the other elements except the element in the current index
        System.out.println("nums: " + Arrays.toString(nums));
        int arrLength = nums.length;
        int[] leftProducts = new int[arrLength];
        int[] rightProducts = new int[arrLength];
        int[] outputArr = new int[arrLength];

        leftProducts[0] = 1; // initialize index 0 with 1
        rightProducts[arrLength - 1] = 1; // initialize last index with 1

        // leftProducts
        for (int i = 1; i < arrLength; i++) {
            leftProducts[i] = nums[i - 1] * leftProducts[i - 1];
        }
        System.out.println("leftProducts: " + Arrays.toString(leftProducts));

        // rightProducts
        for (int i = arrLength - 2; i >= 0; i--) {
            rightProducts[i] = nums[i + 1] * rightProducts[i + 1];
        }
        System.out.println("rightProducts: " + Arrays.toString(rightProducts));

        for (int i = 0; i < arrLength; i++) {
            outputArr[i] = leftProducts[i] * rightProducts[i];
            System.out.println("outputArr" + Arrays.toString(outputArr));
        }

        return outputArr;
    }

    final static char DELIMETER = '#';

    // encode would require a delimeter and a character counter for decode to know where to separate the string and regroup the string
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        // append the strings in the list into 1 string with a character counter and delimiter
        for (String str : strs) {
            // build the string
//            sb.append(str.length()); // append the str.length to str[i]
//            sb.append(DELIMETER); // append the delimeter to know the separation of the strings
//            sb.append(str); // append the str

            sb.append(str.length()).append(DELIMETER).append(str);
        }
        return sb.toString();
    }

    public static List decode(String s) {
        List splitS = new LinkedList();
        int start = 0; // first character of the substring
        int end = 0; // last character of the substring
        System.out.println("s.length(): " + s.length());

//        while end is less than s.length()
        while (end < s.length()) {
            // if char is #
            if (s.charAt(end) == DELIMETER) {
                System.out.println("start: " + start + ", " + "end: " + end);
                int subStrLength = Integer.valueOf(s.substring(start, end)); // gets the value generated in the encode

//                System.out.println("s.charAt(end): " + s.charAt(end));
                System.out.println("substring length: " + subStrLength);

//                String subString = s.substring(end + 1, end + 1 + subStrLength); // start = #(index) + 1, end = #(index) + 1 + subStrLength

                int startSubString = end + 1, endSubString = startSubString + subStrLength;
                String subString = s.substring(startSubString, endSubString);
                splitS.add(subString);

                System.out.println("start: " + startSubString);
                System.out.println("end: " + endSubString);
                System.out.println("substring: " + subString);

                start = end + 1 + subStrLength;
                end = start;
            }
            System.out.println("end++: " + end);
            end++;
        }

        return splitS;
    }

    public static int longestConsecutive(int[] nums) {
        System.out.println("nums: " + Arrays.toString(nums));

        // Using HashSet to find the longest consecutive
//        Time complexity: O(n)
//        Space complexity: O(n)
//        if (nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>(); // use HashSet to remove duplicate elements
        int ans = 0; // will hold the length of the longest consecutive numbers

        for (int num : nums) set.add(num); // add each element to HashSet
        System.out.println("HashSet: " + set);

        for (int num : set) {
            // "if" statement is to satisfy O(n). Without the "if" statement, time complexity is O(nlogn).
            if (!set.contains(num - 1)) {
                int count = 0; // works with variable initiated with 1 too
                // while set has an element next to the num incremented by 1
                while (set.contains(num + count)) {
//                    num++;
                    count++;
                }
                ans = Math.max(count, ans); // assigns the maximum count to ans
            }
        }
        return ans;
    }

    public static boolean isPalindrome(String s) {
        boolean ans = true;
        String sReversed = "";

        // remove non-alphanumeric characters from s
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        System.out.println("s: " + s);

        // lowercase
        s = s.toLowerCase();
        System.out.println("s lowercased: " + s);

        // reverse s
        for (int i = s.length() - 1; i >= 0; i--) {
            sReversed += s.charAt(i);
        }
        System.out.println("sReversed: " + sReversed);

//        if(sReversed == s) {
        if (s.equals(sReversed)) {
            return ans;
        }
        ans = false;
        return ans;
    }

    // find all triplets in the array that sum up to 0
    public static List<List<Integer>> threeSum(int[] nums) {
        System.out.println("nums: " + Arrays.toString(nums));
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);

        // nums.length - 2 will check if third from the last and last 2-pair sums up to 0
        for (int i = 0; i < nums.length - 2; i++) {
            // handles the duplicate, if i == 0 or i > 0 and element is not equal to previous element, else proceed to next elemment
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
//                if(i >= 0 && nums[i] != nums[i-1]){
                int low = i + 1; // first of pair
                int high = nums.length - 1; // second of pair
                int sum = 0 - nums[i]; // value needed of 2-pair to sum up to 0

                while (low < high) {
                    // to find pair to sum 0
                    if (nums[low] + nums[high] == sum) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high])); // add the elements to result list
                        while (low < high && nums[low] == nums[low + 1]) low++; // to skip duplicate low elements
                        while (low < high && nums[high] == nums[high - 1]) high--;// to skip duplicate high elements
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] > sum) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        System.out.println("nums sorted: " + Arrays.toString(nums));
        return result;
    }

    public static int maxArea(int[] height) {
        System.out.println("height: " + Arrays.toString(height));
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        // loop through height array (0 to last index)
        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right])); // find the maxArea where width(right - left) * height.min(height[left], height[right])

            // to find tallest left and right heights
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static int maxProfit(int[] prices) {
        System.out.println("Prices: " + Arrays.toString(prices));
        int maxProfit = 0;
        int buy = 0;
        int sell = prices.length - 1;
        while (buy < sell) {
            System.out.println("buy: " + prices[buy] + ", sell: " + prices[sell]);
            maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);

            if (prices[buy] > prices[sell]) {
                buy++;
            } else {
                sell--;
            }
        }
        return maxProfit;
    }

    // Get the length of the longest substring without duplicate characters
    private static int lengthOfLongestSubstring(String s) {
        System.out.println(s);
        int maxLength = 0;
        // use sliding-window algorithm
        int left = 0;
        int right = 0;

        Set<Character> subStr = new HashSet<>(); // holds the substrings without duplicate characters

        // loop while right marker is less s.length
        while (right < s.length()) {
            // if subStr doesn't have charAt(right) then proceed to next charAt(right)
            if (!subStr.contains(s.charAt(right))) {
                subStr.add(s.charAt(right));
                right++;
                maxLength = Math.max(subStr.size(), maxLength);
            } else {
                // else remove the charAt(left) then proceed to next charAt(left)
                subStr.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }

    public static int characterReplacement(String s, int k) {
        System.out.println("s: " + s + ", " + "k: " + k);
        char[] sArr = s.toCharArray(); // convert String to char[]
        int left = 0, right = 0, n = sArr.length;

        Map<Character, Integer> charFreq = new HashMap<>();

        // maxLen is the required output (max length of substring after k has been used up), mostFreq is the char most frequent in the substring
        int maxLen = 0;
        int mostFreq = 0;

        //find maxLength of repeating characters after using give k
        while(right < n){
//            int mostFreq = 0; // gives wrong maxLength

            int count = charFreq.getOrDefault(sArr[right], 0) + 1; // getOrDefault adds the char to the map and counts the char occurance
            // expand the window
            charFreq.put(sArr[right], count);
            System.out.println("sArr[" + right + "]: " + sArr[right] + ", count: " + count);

            // track the char with max frequency (char, current char value)
            mostFreq = Math.max(mostFreq, charFreq.get(sArr[right]));
            System.out.println("mostFreq: " + mostFreq + ", " + charFreq.get(sArr[right]) + ": " + sArr[right]);

            // right - left + 1 is the formula to get the current substring.length e.g. index(3) - index(0) + 1 = 4,
            // shrink the window if substring.length - mostFreq char gets more than k char
            if((right - left + 1) - mostFreq > k){
                int reduceCharVal = charFreq.get(sArr[left]) - 1;
                charFreq.put(sArr[left], reduceCharVal); // sArr[left] value gets reduced
                System.out.println("sArr[" + left + "]: " + sArr[left] + ", new value: " + reduceCharVal);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1); // stores the max length all throughout the string iteration
            System.out.println("maxLen: " + maxLen);
            right++;
        }
        return maxLen;

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
        List<String> strsX = Arrays.asList("Back", "to", "the", "Future");
        String encoded = encode(strsX);
        System.out.println("Encode string: " + encoded);
        System.out.println("Decode string: " + decode(encoded));

        System.out.println("-----Longest Consecutive------");
//        int[] numsZ = {2,2,3,1,11,6,9,7,8,4};
//        int[] numsZ = {100,4,200,1,1,3,2};
        int[] numsZ = {0,3,7,2,5,8,4,6,0,1};
        System.out.println("longest consecutive numbers: " + longestConsecutive(numsZ));

        System.out.println("-----Valid Palindrome------");
//        String str = "race a car";
        String str = "A man, a plan, a canal: Panama";
        System.out.println("is " + str + " a palindrome? " + isPalindrome(str));

        System.out.println("------Three Sum-----");
        int[] numsU = {-1,0,1,2,-1,-4};
        System.out.println("Three sum: " + threeSum(numsU));

        System.out.println("-----Container with most water-----");
//        int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height = {1,6,2,5,4,8,3,7};
        System.out.println("Max area: " + maxArea(height));

        System.out.println("-----Best time to buy and sell stock-----");
        int[] prices = {7,1,5,3,6,4};
        System.out.println("Max profit: " + maxProfit(prices));

        System.out.println("-----Longest Substring without repeating characters------");
        String sX = "abcabcbb";
        System.out.println("Max Length: " + lengthOfLongestSubstring(sX));

        System.out.println("-----Longest Repeating character replacement-----");
        String sY = "ABBBA";
        int kX = 2;

//        String sY = "AABABBA";
//        int kX = 1;
        System.out.println("Longest Repeating character after replacement: " + characterReplacement(sY, kX));
    }


}
