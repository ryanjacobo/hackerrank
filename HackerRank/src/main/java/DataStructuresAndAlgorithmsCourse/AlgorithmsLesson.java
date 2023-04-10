package DataStructuresAndAlgorithmsCourse;

import java.util.Arrays;

public class AlgorithmsLesson {
    public static void printArray(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    // Move 0 elements to the end of the array. To move the 0s to the start of the array, just change the "==" to "!=" and vise versa.
    public static void moveZeros(int[] arr){
//        System.out.println("arr: " + Arrays.toString(arr));
        int j = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0 && arr[j] == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if(arr[j] != 0) {
                j++;
            }
        }
//        System.out.println("new arr: " + Arrays.toString(arr));
    }

    public void arrayDemo() {
        int[] arr = {8, 1, 0, 2, 1, 0, 3};
        printArray(arr);
        moveZeros(arr);
        printArray(arr);
    }
    public static void main(String[] args) {
//        int[] arr = {8,1,0,2,1,0,3};
//       moveZeros(arr);
        System.out.println("----Move Zeros to end of array----");
       AlgorithmsLesson moveZeros = new AlgorithmsLesson();
       moveZeros.arrayDemo();
    }
}
