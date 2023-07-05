import java.util.Arrays;
import java.util.Scanner;

public class Recursion {
    public static boolean findVal(int num){
        if(num == 10){
            return true;
        }
        System.out.println(num);
        return findVal(num + 1);
    }
    public static String A(){
        return "hello " + B();
    }
    public static String B(){
        return "my " + C();
    }
    public static String C(){
        return "friends.";
    }

    public static String revString(String str){

        if(str.equals("")){
            return "";
        }
        return revString(str.substring(1)) + str.charAt(0);
    }

    public static boolean isPalindrome(String str){
        if(str.length() == 0 || str.length() == 1){
            return true;
        }

        if(str.charAt(0) == str.charAt(str.length() - 1))
        {
            // if first and last characters of the string are equal, reduce the string to next inner substring and use it as an argument in the method recursion
            return isPalindrome(str.substring(1, str.length() - 1));
        }

        // if str.charAt(0) != str.charAt(str.length() - 1
        return false;
    }

    public static String findBinary(int decimal, String result){
        if(decimal == 0){
            return result;
        }

        result = decimal % 2 + result; // store the String result
        return findBinary(decimal/2, result); // run the method til
    }

    public static int recursiveSum(int num){
        int result = 0;
        if(num <= 1){
            return num;
        }

        return num + recursiveSum(num - 1);
    }

    // find the index of x in a sorted array
    public static int binarySearch(int[] A, int left, int right, int x){
        // base case 1: to return -1 if left is invalid
        if(left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        // base case 2: mid is the index of x that we want to return
        if(x == A[mid]){
            return mid;
        }

        //  x will be in the first half of the subarray
        if(x < A[mid]){
            return binarySearch(A, left, mid -1, x);
        }

        // x > A[mid], x will be in the 2nd half of the subarray
        return binarySearch(A, mid + 1, right, x);
    }

    public static long fib(long n) {
        // n signifies the nth number of the fibonacci sequence
        if((n == 0) || (n == 1)){
            return n;
        }
        else {
            // fibonacci is sum of 2 previous numbers e.g. fib(6) = 0 + 1 + 1 + 2 + 3 + 5 + 8
            return fib(n-1) + fib(n-2);
        }
    }

    // sort halves of the array
    public static void mergeSort(int[] data, int start, int end){
        // base case: only sort if end index > start index to make sure there's more than 1 element in the array
        if(start < end) {
            int mid = (start + end)/2; // data[] is split in 2 at the first iteration, ex. index 0 + index 1 / 2
            mergeSort(data, start, mid); // split left (recursively) in half til only 2 digits need to be swapped
            mergeSort(data, mid + 1, end); // split right (recursively) in half til only 2 digits need to be swapped
            merge(data, start, mid, end); // merge the data of two halves
        }
    }

    // merge the sorted halves
    public static void merge(int[] data, int start, int mid, int end){
        // build temp array to avoid modifying the original contents
//        int[] temp = new int[end - start + 1]; // temp array to hold subarray with end-start+1 as the size
        int[] temp = new int[data.length]; // can replace [end - start + 1] since temp length stays the same

        int i = start, j = mid + 1, k = 0;

        // while both sub-array have 2 values, then try and merge them in sorted order
        while(i<=mid && j <= end){
            if(data[i] <= data[j]){
                // insert data[i] in the left sub-array
                temp[k++] = data[i++];
//                i++;
//                k++;
            } else {
                // insert data[i] in the right sub-array
                temp[k++] = data[j++];
//                k++;
//                j++;
            }
        }

        // add the rest of the values from the left sub-array into the result
        while(i<= mid){
            temp[k++] = data[i++];
//            k++;
//            i++;
        }

        // add the rest of the values from the right
        // sub-array into the result
        while (j<= end){
            temp[k] = data[j];
            k++;
            j++;
        }

        // replace the data[i] with temp[i]
        for(i=start; i<= end; i++){
            data[i] = temp[i - start];
        }
    }
    public static void main(String[] args) {
        int num = 2;
        System.out.println(findVal(num));
        System.out.println(A());

        System.out.println("---Reverse a string---");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter str to reverse: ");
        String rev = input.nextLine();
//        System.out.println("Reversed: " + revString(rev));

        System.out.println("---is str palindrome---");
        System.out.print("Enter str to check if palindrome: ");
        String isPal = input.nextLine();
//        System.out.println("Is Palindrome?: " + isPalindrome(isPal));

        System.out.println("---Decimal to binary---");
        int dec = 233;
        String res = "";
        System.out.println("Binary of " + dec + ": " + findBinary(dec, res));

        System.out.println("---sum of natural numbers---");
        int recSum = 10;
        System.out.println("Recursive sum: " + recursiveSum(recSum));

        System.out.println("---find index of element x---");
        int[] A = {-1, 0, 1, 2, 3, 4, 7, 9, 10, 20};
        int left = 0; // start index
        int right = 9; // end index
        int x = 4;
        System.out.println(x + " is index " + binarySearch(A, left, right, x));

        System.out.println("---fibonacci---");
        long n = 6;
        System.out.println("fibonacci " + n + " is " + fib(n));

        System.out.println("---sort array---");
        int[] data = {-5, 20, 10, 3, 2, 0};
        int[] data2 = {3,2,1};
        System.out.println("unsorted: " + Arrays.toString(data));
        mergeSort(data, 0, data.length-1);
        System.out.println("sorted: " + Arrays.toString(data));
    }
}
