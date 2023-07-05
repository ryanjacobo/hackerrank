public class SortedMatrix {
    public static void search(int[][] matrix, int n, int x) {
        int i = 0; // row
        int j = n - 1; // column

        while(i<n && j<=n){
            if(x == matrix[i][j]){
                System.out.println(x + " is at" + " row " + i + ", column " + j);
                return;
            }
            // matrix needs to be arranged in ascending order
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

    public static void spiralPrint(int[][] matrix, int r, int c){
        int i, k = 0, l = 0; // k = row, l = column
        while(k < r && l < c){
            for(i = l; i < c; i++){
                // k = row, i = column
                System.out.print(matrix[k][i]+ ", ");
            }
            k++; // move the index down
            for(i = k; i < r; i++){
                //
                System.out.print(matrix[i][c-1]+", ");
            }
            c--; // right to left
            if(k<r){
                for(i=c-1;i>=l;i--){
                    System.out.print(matrix[r-1][i]+", ");
                }
                r--; // moves the row towards inner circle
            }
            if(l<c){
                for(i=r-1;i>=k;i--){
                    System.out.print(matrix[i][l]+", ");
                }
                l++; // moves the column towards inner circle
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {10,20,30,40},
                {15,25,35,45},
                {27,29,37,48},
                {32,33,39,51}
        };

        System.out.println("---Search for value in the matrix---");
        search(matrix, 4, 100);

        System.out.println("---Spiral Print---");
        spiralPrint(matrix, 4, 4);
    }
}
