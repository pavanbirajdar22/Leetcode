public class P189 {
    public static void main(String[] args) {
        new P189().rotate(new int[]{1, 2, 4, 5, 6}, 2);
        new P189().rotate(new int[]{1, 2, 4, 5}, 2);
        new P189().rotate(new int[]{1, 2, 4}, 1);
        new P189().rotate(new int[]{1, 2, 4}, 4);
        new P189().rotate(new int[]{1, 2, 4}, 3);
    }

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        k = k % nums.length;
        if (k == 0) return;
        else {
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            nums[start] = nums[start] ^ nums[end];
            nums[end] = nums[start] ^ nums[end];
            nums[start] = nums[start] ^ nums[end];
            start++;
            end--;
        }
    }
}
