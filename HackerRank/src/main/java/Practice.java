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

    // Breaking the records - Return number of times highest and lowest scores have been beaten
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



    // Divisible Sum Pairs - number of pairs in the List that are divisible by k
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
        bill.remove(k); // remove the item with corresponding index(k)
        int sum = 0;

        for (int i = 0; i < bill.size(); i++) {
            sum += bill.get(i);
        }
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

    // return the element where the last candy has landed
    public static int saveThePrisoner(int n, int m, int s){
        // n is the number of prisoners
        // m is the number of candies
        // s is the starting point of the distribution
        //s-1 is to start the candy distribution to position 0
        if((s-1+m) % n == 0)
            return n;
        else
            return (s-1+m)%n;
        //2-1+6 % 4 = 3
    }

    public static int[] permutationEquationArray(int[] p){
        int n = p.length;
        int[]a = new int[n];

        for(int i = 1; i<=n; i++){
            int index = 0;
            for(int j = 0; j<n; j++){
                if(p[j]==i){
                    index = j + 1;
                    break;
                }
            }

            for(int j = 0; j<n; j++){
                if(p[j]==index){
                    index = j + 1;
                    break;
                }
            }

            a[i-1] = index;
        }
        System.out.println(Arrays.toString(a));

        return a;
    }

    public static List<Integer> permutationEquation(List<Integer> p) {
        List<Integer> indices = new ArrayList<>();
        int elNum = 1, xIndex = 0;
        // x are the elements 1 - 5
        while(elNum <= p.size()){

            for(int i = 0; i <= p.size(); i++){
                System.out.println("x: " + elNum + ", " + "i: " + i);
                // find element 1 in the p list
                if(elNum == p.get(i)){
                    // find the element corresponding to the element's number(x) in the list
                    for(int j = 0; j < p.size(); j++){
                        int elVal = i+1;
//                       find element equivalent
                        if(elVal==p.get(j)){
                            System.out.println("elVal: " + elVal);
                            System.out.println("p.get(j): " + p.get(j));
                            xIndex = j+1;
                            System.out.println("xIndex " + xIndex);
                            break;
                        }
                    }
                    indices.add(xIndex);
                    xIndex=0;
                    elNum++; // proceed to element 2
                    break;
                }
            }
        }
        return indices;
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

        System.out.println("### Divisible Sum Pairs ###");
        int k = 5;
        int n = 6;
        List<Integer> ar = new ArrayList<>();
        ar.addAll(Arrays.asList(1,2,3,4,5,6));
        System.out.println("Number of pairs divisible by k is: " + divisibleSumPairs(n, k,ar));

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

        System.out.println("### Sequence Equation ###");
        List<Integer> N = new ArrayList<>();
        N.addAll(Arrays.asList(5,2,1,3,4));
        System.out.println(permutationEquation(N));

        int[] arr = {5,2,1,3,4};
//        permutationEquationArray(arr);
    }

}
