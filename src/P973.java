import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P973 {
    public static void main(String[] args) {
        int[][] a = {{1, 3}, {-2, -2}};
        int[][] b = {{3, 3}, {5, -1}, {-2, 4}}; //[[3,3],[5,-1],[-2,4]]
        System.out.println(Arrays.deepToString(new P973().kClosest(a, 1)));
    }

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<MyPair> queue = new PriorityQueue<>(points.length, Comparator.comparingInt(o -> o.square));
        for (int i = 0; i < points.length; i++) {
            queue.offer(new MyPair(i, (int) (Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2))));
        }
        int[][] ans = new int[K][];
        for (int i = 0; i < K; i++) {
            MyPair pair = queue.poll();
            ans[i] = points[pair.index];
        }
        return ans;
    }

    class MyPair {
        int index;
        int square;

        public MyPair(int index, int square) {
            this.index = index;
            this.square = square;
        }

        @Override
        public String toString() {
            return "MyPair{" +
                    "index=" + index +
                    ", square=" + square +
                    '}';
        }
    }
}
