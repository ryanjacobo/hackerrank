public class SortedMatrix {
    public static void search(int[][] matrix, int n, int x) {
        int i = 0; // row
        int j = n - 1; // column

        while(i<n && j<=n){
            if(x == matrix[i][j]){
                System.out.println(x + " is at" + " row " + i + ", column " + j);
                return;
            }
            if(x < matrix[i][j]){
                // x < matrix[i][j], move the the previous column
                  j--;
            } else {
                // x > matrix[i][j], move to the next row
                i++;
            }
        }
        System.out.println(x + " not found in the matrix");
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {10,20,30,40},
                {15,25,35,45},
                {27,29,37,48},
                {32,33,39,51}
        };

        System.out.println("---Search for value in the matrix---");
        search(matrix, 4, 32);
    }
}
