import com.sun.jdi.Value;

import java.util.*;

public class Quiz {
    int x = 1;

    public int generateNumber() {
        return 3;
    }
    public void Quiz() {
        int y = generateNumber();
        this.x = y;
    }

    public int getNumber() {
        int x= 2;
        x++;
        return x * 10;
    }

    public static String transform(String s) {
        String newStr = s.replace("e","a");
        return newStr;
    }

    public static double doStuff() {
        return 10.3;
    }

//    private static void doSomething(int i){
//        if(0>i){
//            throw new IllegalArgumentException();
//
//        } else {
//            // do something else
//        }
//    }

    // String Palindrome
    private static boolean isPalindrome(String str){
        System.out.println(str);
        String word = "";

        boolean ans = false;

        for(int i = str.length() - 1; i >= 0; i--){
            word = word + str.charAt(i);
            System.out.println(word);
        }

        if(str.equals(word)){
            ans = true;
        }
        return ans;
    }


    public static int getMaxPoint(int N, ArrayList<Integer> A){
        Collections.sort(A);
        System.out.println(A);
        Set<Integer> freq = new HashSet<>(A);
        List<Integer> pointsList = new ArrayList<>();
        int totalPoints = 0;

        for(Integer a: A){
           pointsList.add(Collections.frequency(freq, a));
        }

        for(Integer p: pointsList){
            totalPoints+=p;
        }
        return totalPoints;
    }

    public static String solution(String OldCode){
        String result = new String(OldCode);

        return result;
    }

    public static int neutralizer(int acid){
        int nz = acid - 1;
        int combo = 0;
        int i = acid*(acid-1);
        return i;
    }

    public static int maxLength(String[] str) {
        int counter = 0;

        return counter;
    }

    public static int neonLights(String str){
        int counter = 0;

        for(int i = 0; i < str.length(); i++){
            char digit = str.charAt(i);
            if(digit == '1'){
                counter+=2;
            }
            else if(digit == '2'){
                counter+=5;
            }
            else if(digit == '3'){
                counter+=5;
            }
            else if(digit == '4'){
                counter+=4;
            }
            else if(digit == '5'){
                counter+=5;
            }
            else if(digit == '6'){
                counter+=6;
            }
            else if(digit == '7'){
                counter+=4;
            }
            else if(digit == '8'){
                counter+=7;
            }
            else if(digit == '9'){
                counter+=6;
            }
            else if(digit == '0'){
                counter+=6;
            }
        }

        return counter;
    }

//    public static int matrix(int[][] bits){
//        int counter = 0;
//
//       for(int i = 0; i<4; i++){
//           if(bits[i] == 1){
//               for(int j = i+1; i<3; j++){
//                   if(bits.get(i) == bits.get(j)){
//                       horizontal++;
//                       break;
//                   }
//               }
//           }
//           counter++;
//       }
//
//        return counter;
//    }

//    public static int speedOptions(int maxSpeed){
//        int counter = 0;
//
//        for(int i = 0; )
//        return counter;
//    }

//    public static int teams(int person){
//        int pairs = 0;
//        if(person%2==0){
//            for(int i = person; i  person; i++){
//                pairs = i
//            }
//            return pairs;
//        }
//        return pairs;
//    }
    public static void main(String[] args) {
        int[] arr = new int[]{3,9,5,9,1,2};
        System.out.println(arr[2]);

        List<String> myCollection = new LinkedList<>();

        Quiz e = new Quiz();
        int y = e.getNumber();
        System.out.println(y);

        String[] words = {"hello", "goodbye", "aloha", "qwerty"};
        for (String w : words) {
            System.out.println(transform(w));
        }

        boolean flag = true;
        int x = 0;
        while(flag) {
            x++;
            if (x == 10) {
                x++;
                break;
            }
        }
        System.out.println(x);

        long l1 = 5;
        int i1 = 3;
        double d1 = doStuff();
        System.out.println(i1 + d1 + l1);

        boolean b1 = true;
        boolean b2 = false;
        if (b1 || b2) {
            System.out.println("foo");
        }
        if (b1 && b2) {
            System.out.println("bar");
        }
        if (!b1) {
            System.out.println("baz");
        } else if (!b2) {
            System.out.println("bat");
        } else {
            System.out.println("zab");
        }

//        doSomething(-1);

        String a = "Hello";
        String b = "World";
        a = a + b;
//        a = new String("Hello");
        String c = "World";

        // Palindrome
//        String original, reverse = ""; // Objects of String class
//        Scanner in = new Scanner(System.in);
//        System.out.println("Enter a string/number to check if it is a palindrome");
//        original = in.nextLine();
//        int length = original.length();
//        for ( int i = length - 1; i >= 0; i-- )
//            reverse = reverse + original.charAt(i);
//        if (original.equals(reverse))
//            System.out.println("Entered string/number is a palindrome.");
//        else
//            System.out.println("Entered string/number isn't a palindrome.");

        System.out.println("### Is Palindrome? ###");
        String str = new String();
        str = "qwerew";
        System.out.println(isPalindrome(str));

        System.out.println("### Max Points ###");
        int Nx = 10;
        List<Integer> A = Arrays.asList(1, 3,2,2,2,3,4,3,1);
//        ArrayList<Integer> A = new ArrayList<>(ax);

//        System.out.println("Total points: " + getMaxPoint(Nx, A));
//        getMaxPoint(Nx, A);

        System.out.println("### Acid - Neutralizer ###");
        int acid = 4;
        System.out.println("Acid-Neutralizer combo: " + neutralizer(acid));

        System.out.println("### Max sub-string length ###");
        String[] strx = {"asam", "asrdr", "rdras"};
        maxLength(strx);

        System.out.println("### Neon lights ####");
        String stry = "12134";
        System.out.println("Number of lights: " + neonLights(stry));

        int ax = 4;
        System.out.println(ax<4?"a is greater than 4" : "a is less than 4");
    }
}
