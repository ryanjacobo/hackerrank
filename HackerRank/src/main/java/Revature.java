import java.math.BigInteger;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Revature {
    //Hunger Hub
    // Sampling and Combinations

    // birthdayChocolates
    public static int birthdayChocolates(int N, int M, int K){
        int total = 0;
        return total;
    }

    // Minimize Partitions
    public static int findWeight(int N, int K, int[] A) {
        int weight = 0;
        int total = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                weight = A[i] + A[j];
                if (weight == K) {
                    total++;
                }
            }
        }
        if (total == 0) return 0;
        return total;
    }

    // Caesar Cipher
    public static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    // Caesar Cipher Youtube
    public static String caesarCipher(String regText, int shift){
        String encrypted = "";
        String alphabetInside = "abcdefghijklmnopqrstuvwxyz";

        if(shift > 0) {
            for (int i = 0; i < regText.length(); i++) {
                char c = regText.charAt(i);
                int letterIndex = alphabetInside.indexOf(c);
                int newIndex = (letterIndex + shift) % 26; // rotates index to the beginning when it goes over 26
                char cipherChar = alphabetInside.charAt(newIndex); // new char corresponding to original letter

                if (Character.isUpperCase(c)) {
                    encrypted += ((char) (((int) c + shift - 65) % 26 + 65)); // code that allows the char to keep the uppercase and be encrypted, "65" is the ascii number of "A"
                } else if (letterIndex == -1) {
                    encrypted += c;
                    continue;
                } else {
                    encrypted += cipherChar;
                }
            }
        } else {
            return regText;
        }
        return encrypted;
    }

    // 2D Array - DS
    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here
        int max = Integer.MIN_VALUE;
        int total = 0;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                total = arr.get(row).get(col) + arr.get(row).get(col + 1) + arr.get(row).get(col + 2);
                total += arr.get(row + 1).get(col + 1);
                total += arr.get(row + 2).get(col) + arr.get(row + 2).get(col + 1) + arr.get(row + 2).get(col + 2);
                max = total > max ? total : max;
            }
        }
        return max;
    }

    public static BigInteger fibonacci(int n) {
        if(n==1 || n ==2)
            return BigInteger.ONE;

        return fibonacci(n-1).add(fibonacci(n-2));
    }

    public static BigInteger fibonacci2(int n) {
        BigInteger total = BigInteger.valueOf(0);
        return total;
    }

    public static int findCost(int N,int R,int X[],int Y[]){
        int sumY = 0;
        int totalTreeCost = 0;
        int max = 0;
        int result = 0;

        for(int y: Y){
            sumY+=y;
        }
        totalTreeCost = sumY + R;
        System.out.println("totalTreeCost: " + totalTreeCost);

        for(int y: Y){
            if(y > max)
                max = y;
        }
        System.out.println("max: " + max);
        result = totalTreeCost - max;

        return result ;
    }


    public static int MaxLength (int N, int[] A, int M, int[] B){

        List<Integer> newA = new ArrayList<>();
        List<Integer> newB = new ArrayList<>();

        int maxLength;

        for(int i = 0; i < N; i++) {
            int aSum = 0;
            for(int j = 0; j < N; j++){
                aSum = A[i] + A[j];
            }
            System.out.println(aSum);
            for(int k = 0; k < M; k++){
                int bSum = 0;
                for(int l = 0; l<M; l++){
                    bSum = B[k] + B[l];
                }
                System.out.println(bSum);
                if(aSum == bSum){
                    newA.add(aSum);
                    newB.add(bSum);
                }
            }
        }
        System.out.println(newA);
        System.out.println(newB);
        if(newA.size() == newB.size()){
            maxLength = newA.size();
        } else {
            maxLength = -1;
        }
        return maxLength;
    }
    public static void reverse(char[] a){
        int halfSize = a.length/2;
        char letter;

        for(int i = 0; i < halfSize; i++){
            letter = a[i];
            a[i] = a[ halfSize - i -1];
            a[halfSize - i -1] = letter;
        }
    }
    public static String lexicographyDecreasing(String s) {
        char[] sArr = s.toCharArray();
        Arrays.sort(sArr);
        String sStr = new String(sArr);
        return sStr;
    }
        public static void main (String[]args){
//        System.out.println(birthdayChocolates(3, 7, 2));

            System.out.println("### Minimize Paritions ###");
            int [] A = {8};
        System.out.println(findWeight(1, 9, A));

            System.out.println("### 2D Array - DS ###");
            List<List<Integer>> arr = List.of(
                    List.of(1, 1, 1, 0, 0, 0),
                    List.of(0, 1, 0, 0, 0, 0),
                    List.of(1, 1, 1, 0, 0, 0),
                    List.of(0, 0, 2, 4, 4, 0),
                    List.of(0, 0, 0, 2, 0, 0),
                    List.of(0, 0, 1, 2, 4, 0)
            );
            System.out.println(hourglassSum(arr));

            System.out.println("### Caesar Ciper###");
            String s = "Ryan-J";
            int k = 1;
            System.out.println(caesarCipher(s, k));
            System.out.println(caesarCipher("middle-Outz", 2));

            System.out.println("### Tree vertices ###");
            int N = 4;
            int R = 1;
            int[] X = new int[]{1, 1, 1};
            int[] Y = new int[]{2, 3, 4};
            System.out.println("Cost: " + findCost(N, R, X, Y));

            System.out.println("### Equal Subarray ###");
            int Nx = 5;
            int Ax[] = {11,2,3,5,7};
            int M = 4;
            int B[] = {11,7,3,7};
            System.out.println(MaxLength (Nx, Ax, M, B));

            System.out.println("### Sort String char alphabetically ###");
            String su = "oklahoma";
            System.out.println(lexicographyDecreasing(su));
        }
    }
