import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P957 {
    public static void main(String[] args) {
        int[] a = {0, 1, 0, 1, 1, 0, 0, 1};
        System.out.println(Arrays.toString(new P957().prisonAfterNDays(a, 7)));
    }

    public int[] prisonAfterNDays(int[] cells, int N) {
        if (cells == null || N == 0) return cells;
        Set<String> set = new HashSet<>();
        int cycle = 0;
        boolean cycleDetected = false;
        for (int i = 0; i < N; i++) {
            int[] next = nextDay(cells);
            String s = Arrays.toString(next);
            if (!set.contains(s)) {
                set.add(s);
                cycle++;
            } else {
                cycleDetected = true;
                break;
            }
            cells = next;
        }
        if (cycleDetected) {
            N = N % cycle;
            for (int i = 0; i < N; i++) {
                cells = nextDay(cells);
            }
        }
        return cells;
    }

    private int[] nextDay(int[] cells) {
        int[] a = new int[8];
        for (int i = 1; i < 7; i++) {
            a[i] = (cells[i - 1] == cells[i + 1]) ? 1 : 0;
        }
        return a;
    }
}
