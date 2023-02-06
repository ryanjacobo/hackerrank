import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Practice {

    // Determine if to kangaroos will ever be in the same location give their starting location and velocity.
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        int loc1 = x1;
        int vel1 = v1;
        int loc2 = x2;
        int vel2 = v2;

        while (loc1 <= loc2) {
            if (loc1 == loc2) {
                return "YES";
            }
            loc1 = loc1 + vel1;
            loc2 += vel2;
        }
        return "NO";
    }

    // Breaking the records
    public static List<Integer> breakingRecords(List<Integer> scores) {
        int highest = 0;
        int lowest = 0;
        int highestScore = scores.get(0);
        int lowestScore = scores.get(0);

        for (int i = 1; i < scores.size(); i++) {
            int currentScore = scores.get(i);
            if (currentScore > highestScore) {
                highestScore = currentScore;
                highest++;
            }
            if (currentScore < lowestScore) {
                lowestScore = currentScore;
                lowest++;
            }
        }
        List<Integer> records = new ArrayList<>();
        records.add(highest);
        records.add(lowest);
        return records;
    }

    // Subarray division (Lily's chocolate bar)
    // Share according to Ron's birthday
    //  segments = adjacent segments whose integers are sum of Ron's birthday
    //  length = number of segments according to Ron's birth month
    public static int birthday(List<Integer> s, int d, int m) {
        int result = 0;
        // Iterate through the List
        for (int i = 0; i < s.size(); i++) {
            int sum = 0;
            // Iterate through consecutive segments i.e. 0-1, 1-2, etc.
            for (int j = i; j < i + m; j++) {
                if (i + m <= s.size()) {
                    sum += s.get(j);
                }
            }
            // If day == sum of int on segments. "else" not required
            if (d == sum) {
                result++;
            }
        }
        return result;
    }

    // Between two sets
    // n1 is first element of the list, n2 is the next integer in the iteration of the list
    public static int getLCM(int n1, int n2) {
        if (n1 == 0 || n2 == 0)
            return 0;
        else {
            int gcd = getGCD(n1, n2);
            return Math.abs(n1 * n2) / gcd;
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
        System.out.println(result);

        return result;
    }

    // Divisible Sum Pairs
    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        int modK = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((ar.get(i) + ar.get(j)) % k == 0) {
                    modK++;
                }
            }
        }
        return modK;
    }

    // Migratory Birds
    public static int migratoryBirds(List<Integer> arr) {
        int max = 0;
        int[] countArray = new int[arr.size()];
        Arrays.fill(countArray, 0); // determines how many times the same ID shows up

        // loop through the arr
        for (int id : arr) {
          countArray[id] += 1; // increments the count of the index in the countArray
        }

        for (int i = 0; i < countArray.length; i++) {
            // compare count at given index with the max in the array
            if (countArray[i] > countArray[max]) {
                max = i;
            }
        }
   return max;
    }

    // Day of the programmer
    public static String dayOfProgrammer(int year) {
        String date = "";
        if (year == 1918) {
            date += "26.09." + year;
        } else if (year < 1918) {
            date += year % 4 == 0 ? "12.09." + year : "13.09." + year;
        } else {
            date += year % 400 == 0 || year % 4 == 0 && year % 100 != 0 ? "12.09." + year : "13.09." + year;
        }
        return date;
    }

        // Bill Division
    public static void bonAppetit(List<Integer> bill, int k, int b) {
        bill.remove(k);
        int sum = 0;

        for (int i = 0; i < bill.size(); i++) {
            sum += bill.get(i);
        }
        ;
        int splitAmount = sum / 2;
        if (splitAmount == b) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(b - splitAmount);
        }
    }

    // Sales by Match
    public static int sockMerchant(int n, List<Integer> ar) {
//        Collections.sort(ar);
//        System.out.println(ar);
        int pairCount = 0;
        for (int i = 0; i < ar.size(); i++) {
            for (int j = i + 1; j < ar.size(); j++) {
                if (ar.get(i) == ar.get(j)) {
                    pairCount++;
                    ar.remove(j);
                    System.out.println(ar);
                    break;
                }
//                System.out.println(ar.get(i) + " " + ar.get(j));
            }
        }
        return pairCount;
    }

    // Drawing Book
    public static int pageCount(int n, int p) {
        int turnsToLastPage = n / 2; // divide by 2 since 1 turn = 2 pages
        int turnsToDestPageFromFront = p / 2;
        int turnsToDestPageFromBack = turnsToLastPage - turnsToDestPageFromFront;

        return Math.min(turnsToDestPageFromFront, turnsToDestPageFromBack);
    }

    // Counting Valleys
    public static int countingValleys(int steps, String path) {
        int seaLevel = 0;

        int traversed = 0;
        for (int i = 0; i < steps; i++) {
            if (path.charAt(i) == 'U') {
                seaLevel++;

            } else {
                if (seaLevel == 0) {
                    traversed++;
                }
                seaLevel--;
            }
        }
        System.out.println(traversed);
        return traversed;
    }

    // Electronics shop
    public static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int bestDeal = 0;
        int total;
        for (int i = 0; i < keyboards.length; i++) {
            for (int j = 0; j < drives.length; j++) {
                total = keyboards[i] + drives[j];
                if (total <= b && total > bestDeal) {
                    bestDeal = total;

                }
            }
        }
//        Not possible to buy both items (bestDeal will remain 0 and therefor return -1)
        if (bestDeal == 0) return -1;
        return bestDeal;
    }

    // Cats and a Mouse
    static String catAndMouse(int x, int y, int z) {
        int catA = Math.abs(z - x);
        int catB = Math.abs(y - z);

        if (catA > catB) {
            return "Cat B";
        } else if (catA < catB) {
            return "Cat A";
        } else {
            return "Mouse C";
        }

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

    // Picking Numbers - objective create a subarray with the most elements where each pair would have a difference of >2.
    public static int pickingNumbers(List<Integer> a) {
        Collections.sort(a);
        System.out.println(a);
        List<Integer> count  = new ArrayList<>();

        // a.size()-1 means end the loop at second to last element to add the last element to the second to the last element
        for (int i = 0; i < a.size()-1; i++) {
            List<Integer> temp = new LinkedList<>();
            temp.add(a.get(i));
            for(int j = i+1; j < a.size(); j++){
                // if difference is >=2, add count temp size to count list
                if (Math.abs(a.get(i)-a.get(j)) < 2){
                    temp.add(j);
                }
//                System.out.println(temp);
            }
            count.add(temp.size());
            System.out.println(temp);
        }
        return Collections.max(count);
    }

    // Picking Numbers 2
    public static int pickingNumbers2(List<Integer> a){
        Collections.sort(a);
        System.out.println(a);
        int count = 0;
        int max = 0;
        Collections.sort(a);
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

    public static int hurdleRace(int k, List<Integer> height) {
            int maxHurdle = Collections.max(height);
            int reqBoost = maxHurdle - k;
            if(k>=maxHurdle){
                return 0;
      } else {
                return reqBoost;
            }
    }

    public static int designerPdfViewer(List<Integer> h, String word) {
        int max = -1; // will be used as comparison to h.get(val) which i
        for(int i = 0; i<word.length();i++){
//            int ascii = (int)word.charAt(i);
            int letterIndex = word.charAt(i); // using "charAt(i) on a String is getting the ascii # of the letter
            int val = letterIndex - 97; // "97" is the  ascii # of "a", deducting "97" makes it "0", "0" used for h.get(val) gives you the first element of h List.
            System.out.println(letterIndex);
            System.out.println(val);
            if(h.get(val)>max){
                max=h.get(val);
            }
        }
        return word.length()*max;
    }

    // Utopian Tree
    public static int utopianTree(int n, int height) {
//        int height = 2;

        for(int i = 1; i <= n; i++){
            if(i%2 == 1){
                height*=2;
            } else {
                height++;
            }
            System.out.println("Cycle " + i + ": " + height);
        }

        return height;
    }

    public static String angryProfessor(int k, List<Integer> a) {
        String cancel = "YES";
        int attendance = 0;

        for(int i = 0; i < a.size(); i++){
            if(a.get(i) <= 0){
                attendance++;
            }
        }
        System.out.println("Attendance min: " + k);
        System.out.println("Attendance: " + attendance);
        if(attendance >= k){
            return cancel = "NO";
        } else {
            cancel = "YES";
        }
        return cancel;
    }

    public static int reversed(int num){
        int reversed = 0;
        while(num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;

            num /= 10;
        }
        return reversed;
    }
    public static int beautifulDays(int i, int j, int k) {
        int beautifulDays = 0;
        int days = j - i;
        for(int l = 0; l <= days; l++){
            int day = i;
            int rDay = day - reversed(day);
            System.out.println(i);
            System.out.println(rDay);
            if(rDay%k == 0){
                System.out.println(rDay);
                beautifulDays++;
            }
            i+=1;
        }
//        System.out.println("Reversed: " + reversed(1234));
//        System.out.println("Number of beautiful days: " + beautifulDays);
        return beautifulDays;
    }

    public static int viralAdvertising(int n){
        int shared = 5;
        int cumulative = 0;

        for(int i = 1; i <= n; i++ ){
            int liked = (int)Math.floor(shared/2);
            cumulative+=liked;
            shared = liked*3;
        }
        return cumulative;
    }

    public static int saveThePrisoner(int n, int m, int s){
        //s-1 is to start the candy distribution to position 0
        if((s-1+m) % n == 0)
            return n;
        else
            return (s-1+m)%n;
        //2-1+6 % 4 = 3
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
        System.out.println("Reversed array: " + Arrays.toString(a));
    }

    public static void reverse2(int[] a){
        Integer[] newA = Arrays.stream(a).boxed().toArray(Integer[]::new);
        Collections.reverse(Arrays.asList(newA));
        System.out.println("reverse2: " + Arrays.toString(newA));
    }
    public static int[] circularArrayRotation(int[] a, int k, int[] queries){
        // a = initial array arrangement
        // k = shift count
        // queries = the new indices of the elements
        k = k % a.length;
        final int SIZE = a.length - 1;

        reverse(a, 0, SIZE);
//        reverse(a, 0, k-1);
//        reverse(a, k, SIZE);

        int[] arr = new int[queries.length]; // arr.length = queries.length
        for(int i = 0; i < arr.length; ++i)
            arr[i] = a[queries[i]];
        return arr;
    }

    // Collections.reverse(<listName>) long method
//    public static <T> void reverseList(List<T> list) {
//       if(list.size() <=1 || list == null)
//           return;
//
//       T value = list.remove(0);
//
//       reverseList(list);
//        list.add(value);
//    }
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

    public static void main(String[] args) {
        System.out.println("#### Kangaroos ####");
        System.out.println(kangaroo(0, 2, 5, 3));
        System.out.println(kangaroo(2, 3, 1, 4));

        System.out.println("#### Breaking the records ####");
        List<Integer> scores = new ArrayList<>();
        scores.addAll(Arrays.asList(10, 5, 20, 20, 4, 5, 2, 25, 1));
        List<Integer> scoresArr = breakingRecords(scores);
        int lowestCount = scoresArr.get(0);
        int highestCount = scoresArr.get(1);
        System.out.println("Beat lowest score count: " + lowestCount);
        System.out.println("Beat highest score count: " + highestCount);

        System.out.println("#### Subarray Division ####");
        List<Integer> s = new LinkedList<>();
        s.add(1);
        s.add(2);
        s.add(1);
        s.add(3);
        s.add(2);

        System.out.println(birthday(s, 3, 2));

        System.out.println("#### Between two Sets ####");
        System.out.println(getLCM(2, 4));
        System.out.println(getGCD(16, 96));
        List<Integer> a = new LinkedList<>();
        a.add(2);
        a.add(4);
        System.out.println(a);
        List<Integer> b = new LinkedList<>();
        b.add(16);
        b.add(32);
        b.add(96);
        System.out.println(b);
        System.out.println(getTotalX(a, b));

        System.out.println("### Divisible Sum Pairs ###");
        int k = 5;
        int n = 6;
        List<Integer> ar = new ArrayList<>();
        ar.addAll(Arrays.asList(1,2,3,4,5,6));
        System.out.println("Number of pairs divisible by k is: " + divisibleSumPairs(n, k,ar));

        System.out.println("### Migratory Birds ###");
        List<Integer> arr = new ArrayList<>();
        arr.addAll(Arrays.asList(3,3,1,1,2,2,3));
        System.out.println("Bird ID that's been spotted the most: " + migratoryBirds(arr));

        System.out.println("#### Day of programmer ####");
        System.out.println(dayOfProgrammer(2017));
        System.out.println(dayOfProgrammer(2018));
        System.out.println(dayOfProgrammer(2016));
        System.out.println(dayOfProgrammer(1800));

        System.out.println("### Bill Division ###");
        List<Integer> foodID = new LinkedList<>();
        foodID.addAll(Arrays.asList(3, 10, 2, 9));
        bonAppetit(foodID, 1, 12);

        List<Integer> foodID2 = new LinkedList<>();
        foodID2.addAll(Arrays.asList(3, 10, 2, 9));
        bonAppetit(foodID2, 1, 7);

        System.out.println("### Sales by Match ###");
        List<Integer> arx = new LinkedList<>();
        ar.addAll(Arrays.asList(1, 2, 1, 2, 1, 3, 2, 2));
        System.out.println(sockMerchant(7, arx));

        System.out.println("### Drawing Book ###");
        System.out.println(pageCount(5, 4));
        System.out.println(pageCount(6, 2));

        System.out.println("### Counting Valleys ###");
        String steps = "DDUU";
        countingValleys(4, steps);

        System.out.println("### Electronics Shop ###");
//        int[] keyboards = {40, 50, 60};
//        int[] drives = {5, 8, 12};
//        int budget = 60;

        int[] keyboards = {4};
        int[] drives = {5};
        int budget = 5;
        System.out.println(getMoneySpent(keyboards, drives, budget));

        System.out.println("### Cats and a Mouse ###");
        int x = 1;
        int y = 2;
        int z = 3;
        System.out.println(catAndMouse(x, y, z));

        System.out.println("### Forming a Magic Square ###");
//        List<List<Integer>> input = List.of(
//                List.of(8, 3, 4, 1, 5, 9, 6, 7, 2),
//                List.of(4, 3, 8, 9, 5, 1, 2, 7, 6),
//                List.of(8, 3, 4, 1, 5, 9, 6, 7, 2),
//                List.of(4, 3, 8, 9, 5, 1, 2, 7, 6),
//                List.of(8, 1, 6, 3, 5, 7, 4, 9, 2),
//                List.of(6, 1, 8, 7, 5, 3, 2, 9, 4),
//                List.of(2, 9, 4, 7, 5, 3, 6, 1, 8),
//                List.of(4, 9, 2, 3, 5, 7, 8, 1, 6),
//                List.of(2, 7, 6, 9, 5, 1, 4, 3, 8),
//                List.of(6, 7, 2, 1, 5, 3, 8, 3, 4)
//        );
        List<List<Integer>> input = List.of(
                List.of(5,3,4),
                List.of(1,5,8),
                List.of(6,4,2)
        );
        System.out.println(formingMagicSquare(input));

        System.out.println("### Picking Numbers ####");
//        List<Integer> numbers = List.of(4, 6, 5, 3, 3, 1);
// List.of makes the List unmodifiable
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(4, 6, 5, 3, 3, 1));
        System.out.println(numbers);
        System.out.println(pickingNumbers2(numbers));

        System.out.println("### The Hurdle Race ###");
        List<Integer> height = new ArrayList<>();
        height.addAll(Arrays.asList(2, 5, 4, 5, 2));
        int kx = 7;
        System.out.println(hurdleRace(kx, height));

        System.out.println("### Designer PDF Viewer ###");
        List<Integer> h = new ArrayList<>();
        h.addAll(Arrays.asList(1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7));
        String word = "abc";
        System.out.println(designerPdfViewer(h, word));

        System.out.println("### Utopian Tree ###");
        int nx = 5;
        int heightx = 2;
        System.out.println(utopianTree(nx, heightx));

        System.out.println("### Angry Professor ###");
        int ky = 3;
        List<Integer> ax = (Arrays.asList(-1, -3, 4, 2));
        System.out.println("Cancel class: " + angryProfessor(ky , ax));

        System.out.println("### Reversed number ####");
        int numx = 1234;
        System.out.println("Reverse of " + numx + " is " + reversed(numx));

        System.out.println("#### Beautiful Days at the Movie ####");
        int i = 20;
        int j = 23;
        int kz = 6;
        System.out.println("Number of beautiful days: " + beautifulDays(i, j, kz));

        System.out.println("### Viral Advertising ###");
        int ny = 3;
        System.out.println("Cummulative likes: " + viralAdvertising(ny));

        System.out.println("### Save the Prisoner ###");
        int numX = 4;
        int candies = 6;
        int sit = 1;

        System.out.println("Lucky prisoner: " + saveThePrisoner(numX, candies, sit));

        System.out.println("### Circular array rotation ###");
        int[] az = new int[]{1,2,3, 4, 5}; // declaring/initializing an int[] (immutable)
        Integer[] azInt = Arrays.stream(az).boxed().toArray(Integer[]::new);
//        Integer[] az = {1,2,3,4,5}; // initializing a mutable Int array
        System.out.println("Given int array: " + Arrays.toString(az));
        int mx = 0;
        int nu = 2;
//        reverse(az, mx, nu);
        Collections.reverse(Arrays.asList(azInt));
        System.out.println("Reversed Int Array: " + Arrays.toString(azInt));


        int[] aw = new int[]{6,7,8,9,10,11};
        System.out.println("Given int array: " + Arrays.toString(aw));
//        reverse2(aw);
        int[] ay = new int[]{3,4,5, 6, 7, 8, 9, 10};
        int m = 2; // number of shifts to the right
        int[] nz = new int[]{0, 2, 4}; // length
        System.out.println("Given array: " + Arrays.toString(ay));
        System.out.println("Queried elements: " + Arrays.toString(circularArrayRotation(ay, m, nz)));

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
