import java.util.PriorityQueue;

public class P215 {
    public static void main(String[] args) {
        System.out.println(new P215().findKthLargest(new int[]{5, 4, 1, 5, 2, 4}, 1));
        System.out.println(new P215().findKthLargest(new int[]{5}, 1));
        System.out.println(new P215().findKthLargest(new int[]{5, 4, 1, 1, 4}, 4));
        System.out.println(new P215().findKthLargest(new int[]{5, 5, 5, 6, 6}, 3));
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return -1;
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() == k) {
                if (queue.peek() < nums[i]) {
                    queue.poll();
                    queue.offer(nums[i]);
                }
            } else queue.offer(nums[i]);
        }
        return queue.peek();
    }
}
