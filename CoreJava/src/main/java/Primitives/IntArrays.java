package Primitives;

public class IntArrays {

    public static void main(String[] args) {
        int[] numbers; // declare an array

        numbers = new int[3]; // define the length of the array

        // assign values to numbers' index
        numbers[0] = 1;
        numbers[1] = 2;
        numbers[2] = 3;
//        numbers[3] = 4; // causes an error

        System.out.println(numbers); // cannot be printed as a set
        System.out.println(numbers[0]);
        System.out.println(numbers[1]);
        System.out.println(numbers[2]);
//        System.out.println(numbers[3]); // goes beyond the defined length of the array

        System.out.println("For Loop");
        for(int i=0; i< numbers.length; i++){
            System.out.println(numbers[i]);
        }

        System.out.println("For Loop 2");
        int[] numbers2 = {4,5,6}; // declaring and defining an array
        for(int i = 0; i < numbers2.length; i++){
            System.out.println(numbers2[i]);
        }
    }
}
