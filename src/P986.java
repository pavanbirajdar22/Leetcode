import java.util.ArrayList;
import java.util.Arrays;

class MyPair {
    int x, y;

    public MyPair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class P986 {
    //A = [[0,2],[5,10],[13,23],[24,25]],
    //B = [[1,5],[8,12],[15,24],[25,26]]
    //[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

    public static void main(String[] args) {
        int[][] a = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] b = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        System.out.println(Arrays.deepToString(new P986().intervalIntersection(a, b)));

        a = new int[][]{{0, 100}};
        b = new int[][]{{2, 5}, {45, 99}};

        System.out.println(Arrays.deepToString(new P986().intervalIntersection(a, b)));

        a = new int[][]{{2, 5}, {45, 99}};
        b = new int[][]{{0, 100}};

        System.out.println(Arrays.deepToString(new P986().intervalIntersection(a, b)));

        a = new int[][]{{2, 5}, {45, 99}};
        b = new int[][]{{4, 50}};

        System.out.println(Arrays.deepToString(new P986().intervalIntersection(a, b)));

        a = new int[][]{{2, 5}, {45, 99}};
        b = new int[][]{{4, 50}, {99, 100}};

        System.out.println(Arrays.deepToString(new P986().intervalIntersection(a, b)));

        /*
        [[4,5],[8,11],[13,15],[19,20]]
        [[0,1],[3,6],[16,17],[18,19]]
         */

        a = new int[][]{{4, 5}, {8, 11}, {13, 15}, {19, 20}};
        b = new int[][]{{0, 1}, {3, 6}, {16, 17}, {18, 19}};
        System.out.println(Arrays.deepToString(new P986().intervalIntersection(a, b)));
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) return new int[0][];

        int i = 0, j = 0;
        ArrayList<MyPair> list = new ArrayList<>();

        while (i < A.length && j < B.length) {
            if (A[i][1] <= B[j][1]) {
                if (A[i][1] >= B[j][0]) {
                    list.add(new MyPair(B[j][0] < A[i][0] ? A[i][0] : B[j][0], A[i][1]));
                    //System.out.println(ans[count][0] + " " + ans[count][1]);
                }
                i++;
            } else {
                if (B[j][1] >= A[i][0]) {
                    list.add(new MyPair(A[i][0] < B[j][0] ? B[j][0] : A[i][0], B[j][1]));
                    //System.out.println(ans[count][0] + " " + ans[count][1]);
                }
                j++;
            }
        }
        int[][] ans = new int[list.size()][2];
        int count = 0;

        for (MyPair myPair : list) {
            ans[count][0] = myPair.x;
            ans[count][1] = myPair.y;
            count++;
        }

        return ans;
    }
}
