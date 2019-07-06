/*
Input:
[
  [1,1,2,4],
  [3,4,0,2],
  [1,0,1,5]
]
Output:
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
We could have used 2 sets to keep a record of rows/columns which need to be set to zero.
But for an O(1) space solution,
you can use one of the rows and and one of the columns to keep track of this information.
 */

public class P73 {
    public static void main(String[] args) {
    }

    public void setZeroes(int[][] matrix) {
        boolean row0 = false, col0 = false;
        int i, j;
        for (i = 0; i < matrix.length; i++) {
            for (j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        row0 = true;
                    }
                    if (j == 0) {
                        col0 = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (j = 1; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (int k = 1; k < matrix.length; k++) {
                    matrix[k][j] = 0;
                }
            }
        }

        if (row0) {
            for (j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        if (col0) {
            for (i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
