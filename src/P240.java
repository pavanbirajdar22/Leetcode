public class P240 {
    public static void main(String[] args) {
        System.out.println(new P240().searchMatrix(new int[][]{{1, 4}, {5, 10}}, 5));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        return search(matrix, target, 0, matrix[0].length - 1);
    }

    private boolean search(int[][] matrix, int target, int i, int j) {
        if (i >= matrix.length || j < 0) return false;
        if (matrix[i][j] == target) return true;
        else if (matrix[i][j] > target) return search(matrix, target, i, j - 1);
        else return search(matrix, target, i + 1, j);
    }
}
