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
                    encrypted += ((char) (((int) c + shift - 65) % 26 + 65)); // code that allows the char to keep the uppercase and be encrypted
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
        }
    }
