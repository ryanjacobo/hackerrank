public class Arrays {
    public static void main(String[] args) {
        int[] values; // holds a list of integers
        values = new int[3]; // [3] means values can hold up to 3 integers

        // set values
        values[0] = 1;
        values[1] = 2;
        values[2] = 3;
//        values[3] = 4;

        // get values
        System.out.println(values[0]);
        System.out.println(values[1]);
        System.out.println(values[2]);
//        System.out.println(values[3]); // out of bound for length 3

        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }

        int[] valuesArr = {1, 2, 3};

        for (int i = 0; i < valuesArr.length; i++) {
            System.out.println(values[i]);
        }

        String[] words = new String[3];
        words[0] = "Hello";
        words[1] = "Ryan";
        words[2] = "Jacobo";

        System.out.println(words[0] + " " + words[1] + " " + words[2]);

        String[] sentence = {"Hello", "Jamie", "Hsu"};

        for (String s : sentence) {
            System.out.print(s + " ");
        }
        System.out.println("-------Multidimensional arrays--------");
        //Multidimensional array - array of arrays
        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(grid[1][2]);

        String[][] texts = new String[2][3];
        texts[0][1] = "Hello there!";
        texts[0][0] = "Good bye!";
        texts[0][2] = "Thank you!";
//        texts[0][3] = "Welcome!";
        System.out.println(texts[0][1]);
        System.out.println(texts[0][0]);
//        System.out.println(texts[0][2]);

        for(int row=0; row<grid.length; row++){
            for(int col=0; col<grid[row].length; col++){
                System.out.print(grid[row][col]+"\t");
            }
            System.out.println();
        }

        String[][] words2 = new String[2][];
        words2[0] = new String[3];
        words2[0][1]="hi there!";
        System.out.println(words2[0][1]);
    }











}
