public class P74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] > target) break;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) return true;
                if (matrix[i][j] > target) break;
            }
        }
        return false;
    }
}
