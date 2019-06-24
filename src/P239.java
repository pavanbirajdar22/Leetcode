import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P239 {
    public static void main(String[] args) {
        int[] a = {3, -1, -2, 1, -3, 2, 5};
        int[] b = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(new P239().maxSlidingWindow(a, 1)));
        System.out.println(Arrays.toString(new P239().maxSlidingWindow(a, 2)));
        System.out.println(Arrays.toString(new P239().maxSlidingWindow(a, 3)));
        System.out.println(Arrays.toString(new P239().maxSlidingWindow(a, 7)));
        System.out.println(Arrays.toString(new P239().maxSlidingWindow(b, 1)));
        System.out.println(Arrays.toString(new P239().maxSlidingWindow(b, 2)));
        System.out.println(Arrays.toString(new P239().maxSlidingWindow(b, 3)));
        System.out.println(Arrays.toString(new P239().maxSlidingWindow(b, 4)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k <= 0 || nums.length == 0) return new int[0];

        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>(k);
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            //remove index out of window
            while (!dq.isEmpty() && dq.peekFirst() < (i - k + 1)) {
                dq.pollFirst();
            }

            //remove smaller numbers from dq as they are useless
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offer(i);

            //start from i-k+1
            if (i >= k - 1) {
                ans[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}