import java.util.*;

public class Advanced {
    // Between two sets
    // n1 is first element of the list, n2 is the next integer in the iteration of the list
    public static int getLCM(int n1, int n2) {
        if (n1 == 0 || n2 == 0) // make sure ints are valid
            return 0;
        else {
            int gcd = getGCD(n1, n2);
            return Math.abs(n1 * n2) / gcd; // Least common multiple
        }
    }

    public static int getGCD(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
//        System.out.println(getGCD(n2, n1 % n2));
        return getGCD(n2, n1 % n2);
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int result = 0;
        int lcm = a.get(0);
        for (Integer integer : a) {
            lcm = getLCM(lcm, integer);
        }

        int gcd = b.get(0);
        for (Integer integer : b) {
            gcd = getGCD(gcd, integer);
        }

        int multiple = 0;
        while (multiple <= gcd) {
            multiple += lcm;


            if (gcd % multiple == 0)
                result++;
        }
        return result;
    }

    // Migratory Birds - return the ID of the bird that has the most sightings (pick the lowest ID# for a tie)
    public static int migratoryBirds(List<Integer> arr) {
        int birdID = 0;
        int[] countArray = new int[arr.size()]; //
        Arrays.fill(countArray, 0); // increments the index by 1 with every sighting

        // loop through the arr
        for (int id : arr) {
            countArray[id] += 1; // increments the count of the index in the countArray
            System.out.println(id + ": " +  Arrays.toString(countArray));
        }
//        System.out.println("countArray: " + Arrays.toString(countArray));

        for (int i = 0; i < countArray.length; i++) {
            // compare count at given index with the max in the array
            if (countArray[i] > countArray[birdID]) {
                birdID = i;
            }
        }
        return birdID;
    }

    // Forming a Magic Square (Medium)
    public static int formingMagicSquare(List<List<Integer>> s) {
        int[][][] squares = {
                {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
                {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
                {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
                {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
                {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
                {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
                {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}}
        };

        int minCost = Integer.MAX_VALUE;
        // squares.length = length of the parent array (8)
        for (int i = 0; i < squares.length; i++) {
            int total = 0;
            // squares[i].length = length of the nested array (3)
            for (int j = 0; j < squares[i].length; j++) {
                // squares[k].length = length of the array (integers) inside the nested array (3)
                for(int k = 0; k<squares[j].length; k++) {
                    total += Math.abs(s.get(j).get(k) - squares[i][j][k]);
                }
            }
            minCost = Math.min(minCost, total);
        }
        return minCost;
    }

    // Picking Numbers - return the number of elements in a subarray where each pair would have a difference of >2.
    public static int pickingNumbers(List<Integer> a){
        Collections.sort(a);
        System.out.println(a);
        int count = 0;
        int max = 0;
        for(int i = 0; i<a.size(); i++){
            for(int j = i; j<a.size(); j++){
                System.out.println(a.get(i) + " - " + a.get(j));
                if(Math.abs(a.get(i) - a.get(j)) <= 1){
                    count++;
                }
            }
            // Reset the count if the iteration goes over 1 and save it to the max variable.
            if(count>max) {
                max = count;
            }
            count=0;
        }
        return max;
    }

    // Circular Array Rotation
    public static void reverse(int[] a, int m, int n) {
        // m = start element index
        // n = last element index
        while (m < n) {
            int temp = a[m]; // store first element to a temp
            a[m] = a[n]; // replace first element with last element
            a[n] = temp; // replace last element with first element
            ++m; // change to next index (to the right)
            --n; // change to next index (to the left)
        }
        System.out.println("Reversed in array: " + Arrays.toString(a));
    }

    // Helper function is required to rotate an int[]
    public static int[] circularArrayRotation(int[] a, int k, int[] queries){
        // a = initial array arrangement
        // k = shift count
        // queries = the new indices of the elements
        k = k % a.length;
        final int SIZE = a.length - 1;

        reverse(a, 0, SIZE); // return the elements queried in this list
//        reverse(a, 0, k-1);
//        reverse(a, k, SIZE);

        int[] arr = new int[queries.length]; // arr.length = queries.length
        for(int i = 0; i < arr.length; ++i)
            arr[i] = a[queries[i]];
        return arr;
    }

    // Rotate a List; no helper function required
    public static List<Integer> circularListRotation(List<Integer> a, int k, List<Integer> queries){
//        public static List<Integer> circularListRotation(List<Integer> a, int k){

        List<Integer> queriedList = new LinkedList<>();

        Collections.rotate(a, k);
//        System.out.println("Shifted List by " + k + ": " + a);
        for(int i = 0; i < queries.size(); i++){
//                System.out.println("Query index " + queries.get(i) + " of" + " list " + a);
//                System.out.println("Index " + a.get(queries.get(i)) + " of" + a);
            queriedList.add(a.get(queries.get(i))); // a.get(value of queries.get(i))
        }
        return queriedList;
    }

    // To simply reverse an int[]
    public static void reverse2(int[] a){
        Integer[] newA = Arrays.stream(a).boxed().toArray(Integer[]::new);
        Collections.reverse(Arrays.asList(newA));
        System.out.println("reverse2: " + Arrays.toString(newA));
    }

    public static void main(String[] args) {
        System.out.println("#### Between two Sets ####");
        List<Integer> a = new LinkedList<>();
        a.addAll(Arrays.asList(2,4));
        System.out.println("List a: " + a);
        List<Integer> b = new LinkedList<>();
        b.addAll(Arrays.asList(16,32,96));
        System.out.println("List b: " + b);
        System.out.println("LCM: " + getLCM(2, 4));
        System.out.println("GCD: " + getGCD(16, 96));
        System.out.println("LCM and GCD: " + getTotalX(a, b));

        System.out.println("### Migratory Birds ###");
        List<Integer> arr = new ArrayList<>();
        arr.addAll(Arrays.asList(3,3,1,1,2,2,3));
        System.out.println("Sighted birds (ID): " + arr);
        System.out.println("Bird ID that's been spotted the most: " + migratoryBirds(arr));

        System.out.println("### Forming a Magic Square ###");
        List<List<Integer>> input = List.of(
                List.of(5,3,4),
                List.of(1,5,8),
                List.of(6,4,2)
        );
        System.out.println(formingMagicSquare(input));

        System.out.println("### Picking Numbers ####");
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(4, 6, 5, 3, 3, 1));
        System.out.println(numbers);
        System.out.println(pickingNumbers(numbers));

        System.out.println("### Circular array rotation ###");
        int[] az = new int[]{1,2,3, 4, 5}; // declaring/initializing an int[] (immutable)
        System.out.println("Given int array: " + Arrays.toString(az));
        Integer[] azInt = Arrays.stream(az).boxed().toArray(Integer[]::new); // convert int[] to an Integer[]
//        Integer[] az = {1,2,3,4,5}; // initializing a mutable Int array
        int mx = 0;
        int nu = 2;
//        reverse(az, mx, nu);
        Collections.reverse(Arrays.asList(azInt));
        System.out.println("Reversed Int Array: " + Arrays.toString(azInt));

        int[] aw = new int[]{6,7,8,9,10,11};
        System.out.println("Given int array: " + Arrays.toString(aw));
        reverse(aw,0,5);
        System.out.println();
        int[] ay = new int[]{3,4,5, 6, 7, 8, 9, 10};
        int m = 2; // number of shifts to the right
        int[] nz = new int[]{0, 2, 4}; // length
        System.out.println("Given int array: " + Arrays.toString(ay));
        System.out.println("Queried array elements: " + Arrays.toString(circularArrayRotation(ay, m, nz)));

        System.out.println();
        System.out.println("### Circular list rotation ###");
        List<Integer> au = new ArrayList<>();
        au.addAll(Arrays.asList(6,7,8,9,10,11,12));
        System.out.println("Given List: " + au);

//        Collections.reverse(au);
//        System.out.println("Reversed List: " + au);

//        Collections.rotate(au, 2);
//        System.out.println("Shift list " + au + " by: " + 2);

        List<Integer> queries = new ArrayList<>();
        queries.addAll(Arrays.asList(0,2,6));
        System.out.println("Queries: " + queries.toString());
        System.out.println("Queried elements: " + circularListRotation(au, 2, queries));
    }
}
