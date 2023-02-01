package Primitives;

public class MultiDimensionalArrays {
    public static void main(String[] args) {
        int[][] grid = {
                {1,2,3},
                {4,5,6,65},
                {7,8,9}
        };
        System.out.println(grid[0][0]);
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
                System.out.print(grid[row][col] + "\t");
            }
            System.out.println();
        }

        String[][] words = new String[2][3]; // String array with 3 X 4 elements
        words[0][1] = "Hello there!";
        System.out.println(words[0][1]);
    }
}
