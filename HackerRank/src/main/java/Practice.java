import org.w3c.dom.ls.LSOutput;

import java.math.BigInteger;
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
        if (k >= maxHurdle) {
            return 0;
        } else {
            return reqBoost;
        }
    }


    // Utopian Tree
    public static int utopianTree(int n, int height) {
//        int height = 2;

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                height *= 2;
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

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) <= 0) {
                attendance++;
            }
        }
        System.out.println("Attendance min: " + k);
        System.out.println("Attendance: " + attendance);
        if (attendance >= k) {
            return cancel = "NO";
        } else {
            cancel = "YES";
        }
        return cancel;
    }

    public static int reversed(int num) {
        int reversed = 0;
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;

            num /= 10;
        }
        return reversed;
    }

    public static int beautifulDays(int i, int j, int k) {
        int beautifulDays = 0;
        int days = j - i;
        for (int l = 0; l <= days; l++) {
            int day = i;
            int rDay = day - reversed(day);
            System.out.println(i);
            System.out.println(rDay);
            if (rDay % k == 0) {
                System.out.println(rDay);
                beautifulDays++;
            }
            i += 1;
        }
//        System.out.println("Reversed: " + reversed(1234));
//        System.out.println("Number of beautiful days: " + beautifulDays);
        return beautifulDays;
    }

    public static int viralAdvertising(int n) {
        int shared = 5;
        int cumulative = 0;

        for (int i = 1; i <= n; i++) {
            int liked = (int) Math.floor(shared / 2);
            cumulative += liked;
            shared = liked * 3;
        }
        return cumulative;
    }

    // return the element where the last candy has landed
    public static int saveThePrisoner(int n, int m, int s) {
        // n is the number of prisoners
        // m is the number of candies
        // s is the starting point of the distribution
        //s-1 is to start the candy distribution to position 0
        if ((s - 1 + m) % n == 0)
            return n;
        else
            return (s - 1 + m) % n;
        //2-1+6 % 4 = 3
    }

    public static int[] permutationEquationArray(int[] p) {
        int n = p.length;
        int[] a = new int[n];

        for (int i = 1; i <= n; i++) {
            int index = 0;
            for (int j = 0; j < n; j++) {
                if (p[j] == i) {
                    index = j + 1;
                    break;
                }
            }

            for (int j = 0; j < n; j++) {
                if (p[j] == index) {
                    index = j + 1;
                    break;
                }
            }

            a[i - 1] = index;
        }
        System.out.println(Arrays.toString(a));

        return a;
    }

    public static int findDigits(int n) {
        int counter = 0;
        int nCopy = n;
        System.out.println("Example: " + "n = " + n);
        while (n != 0) {
            int rem = n % 10;
            System.out.println(n + " % 10 " + " remainder: " + rem);

            if (rem > 0 && nCopy % rem == 0) {
                counter++;
                System.out.println("counter: " + counter);
            }
            n = n / 10;
            System.out.println("running " + n);
        }
        return counter;

        // Convert digits to a separate int and divide the n with each digit
//        return (int)Integer.toString(n).chars().map(Character::getNumericValue).filter(num -> num > 0 && n % num == 0).count();
    }

    // Factorial
    public static void extraLongFactorials(int n) {
        BigInteger factorial = BigInteger.ONE;

        // comparing to 2 or 1 results in the same final value
        for (int counter = n; counter >= 1; counter--) {
            factorial = factorial.multiply(BigInteger.valueOf(counter));
        }
        System.out.println(factorial);
        System.out.printf("%d! = %d\n", n, factorial);
    }


    // Append and Delete String
    public static String appendAndDelete(String s, String t, int k) {
        int sIndex = 0;
        int tIndex = 0;

        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
                tIndex++;
            } else {
                break;
            }
        }

        int minMoves = 0;
        minMoves = s.length() - sIndex + t.length() - tIndex;
        if (k < minMoves) return "No";

        if (k >= s.length() + t.length()) return "Yes";

        if ((k - minMoves) % 2 == 0) return "Yes";

        return "No";
    }

    public static int jumpingOnClouds(int[] c, int k) {
        int energy = 100;
        int cloud = 0;
        int stops = 0;
        System.out.println(Arrays.toString(c));

        System.out.println("cloud = " + c.length);
        System.out.println("k = " + k);

//        for(int i = 0; i < c.length;){
//            i = (i + k)%c.length;
//            System.out.println(i);
//            energy--;
//            if(c[i] == 1){
//                energy-=2;
//            }
//            else if(i == 0){
//                break;
//            }
//        }

        // will go through the loop at least once
        do {
            cloud += k;
            System.out.println("cloud: " + cloud);
//            System.out.println("cloud: " + c[cloud]);

            int temp = cloud;
            // check whether or not jump has reached or overjumped that start
            if (cloud >= c.length) {
                cloud = cloud % c.length; // resets cloud back to start
                System.out.println(temp + " % " + c.length + " = " + cloud);
            }

//            energy = c[cloud] == 1 ? energy - 3 : energy - 1;
            if (c[cloud] == 1) {
//                System.out.println("-3");
                energy -= 3;
                stops++;
                System.out.println("Stops: " + stops);
                System.out.println("energy" + " - " + "3" + " = " + energy);
            } else {
//                System.out.println("-3");
                energy -= 1;
                stops++;
                System.out.println("Stops: " + stops);
                System.out.println("energy" + " - " + "1" + " = " + energy);
            }
        } while (cloud != 0);
        return energy;
    }

    public static int squares(int a, int b) {
        int squares = 0;
        System.out.println("a: " + a);
        System.out.println("b: " + b);

//        System.out.println("First d: " + Math.sqrt(a));

        long d = (long) Math.ceil(Math.sqrt(Double.valueOf(a))); // gets the sqrt of the number before the actual sqrt-able number then rounds it to the ceil int, "long" makes it capable to big numbers
//        long d = (long)(Math.sqrt(Double.valueOf(a)));
//        int d = (int)Math.ceil(Math.sqrt(Double.valueOf(a))); // fails by timeout, can't support long integers
        while (d * d <= b) {
//            System.out.println(d); // slows down the processing
            squares++;
            d++;
        }
        return squares;
    }

    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        int fine = 0;
        if (y2 > y1)
            fine = (y2 - y1) * 10000;
        else if (y2 == y1) {
            if (m2 == m1 && d2 > d1)
                fine = (d2 - d1) * 15;
            else if (m2 > m1)
                fine = (m2 - m1) * 500;
        }
        return fine;
    }

    public static int minStick(List<Integer> sticks){
        int min = Collections.min(sticks);
        return min;
    }

    // Jumping on clouds 2
    public static int jumpingOnClouds2(List<Integer> c){
        int cloud = 0;
        int jumps = 0;

        while(cloud < c.size() - 1){
            if(cloud + 2 == c.size() || c.get(cloud + 2) == 1 ){
                    // should always test first for cloud not going passed last index
                    // take only 1 jump if 2 jumps would equal to the arr.size() since that would go over the index border OR if taking 2 jumps would land on a thundercloud(1)
                cloud++;
            } else {
                // else always take 2 jumps
                cloud += 2;
            }
            jumps++;
        }
        return jumps;
    }

    // Equalize array
    public static int equalizeArray(List<Integer> arr) {
        // Write your code here
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println("List: " + arr);
        for (int n : arr) {
            if (map.get(n) == null)
            {
                // if element value == 0
                map.put(n, 1);
                System.out.println("null: " + map.get(n));
            }
            else {
                map.put(n, map.get(n)+1);
                System.out.println("n: " + n);
            }
//            map.put(n, map.get(n)+1);
//            System.out.println("n: " + n);
            if (map.get(n) > max) {
                max = map.get(n);
            }
        }
        return arr.size() - max;
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
        ar.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println("Number of pairs divisible by k is: " + divisibleSumPairs(n, k, ar));

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

        System.out.println("### Utopian Tree ###");
        int nx = 5;
        int heightx = 2;
        System.out.println(utopianTree(nx, heightx));

        System.out.println("### Angry Professor ###");
        int ky = 3;
        List<Integer> ax = (Arrays.asList(-1, -3, 4, 2));
        System.out.println("Cancel class: " + angryProfessor(ky, ax));

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

        System.out.println("### Sequence Equation (array)###");
        int[] arr = {5, 2, 1, 3, 4};
//        permutationEquationArray(arr);

        System.out.println("### Find Digits ###");
        int nu = 1012;
        System.out.println("Divisors of " + nu + " are: " + findDigits(nu));

        System.out.println("### Factorial ###");
        int nv = 1;
        System.out.print("Factorial of " + nv + " is ");
        extraLongFactorials(nv);

        System.out.println("### Delete and Append ###");
        String su = "aba";
        String t = "aba";
        int ku = 7;
        System.out.println(appendAndDelete(su, t, ku));

        System.out.println("### Jumping on Clouds ###");
        int[] c = {1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1};
        int kv = 18;
        System.out.println(jumpingOnClouds(c, kv));

        System.out.println("### Squares ###");
        int a = 24;
        int b = 49;
        System.out.println(squares(a, b));

        System.out.println("### Library Fine ###");
        int d1 = 2;
        int m1 = 5;
        int y1 = 2015;
        int d2 = 30;
        int m2 = 5;
        int y2 = 2015;
        System.out.println("Fine: " + libraryFine(d1, m1, y1, d2, m2, y2));

        System.out.println("### Cut the sticks ###");
        List<Integer> stickArr = new ArrayList<>();
        stickArr.addAll(Arrays.asList(5, 4, 4, 2, 2, 8));
        System.out.println("Min stick: " + minStick(stickArr));

        System.out.println("### Jumping on clouds 2 ###");
        List<Integer> cu = new ArrayList<>();
        cu.addAll(Arrays.asList(0,0,0,1,0,0));
        System.out.println("Minimum jumps: " + jumpingOnClouds2(cu));

        System.out.println("### Equalize Array ###");
        List<Integer> arrx = new ArrayList<>();
        arrx.addAll(Arrays.asList(1,2,3,1,2,3,3,3));
//        arrx.addAll(Arrays.asList(0));
        System.out.println("Elements removed: " + equalizeArray(arrx));
    }
}
