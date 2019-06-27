public class P198 {
    public static void main(String[] args) {
        System.out.println(new P198().rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(new P198().rob(new int[]{1, 2, 3, 1}));
        System.out.println(new P198().rob(new int[]{2, 1, 1, 2}));
        System.out.println(new P198().rob(new int[]{2, 1, 1, 2}));
        System.out.println(new P198().rob(new int[]{2, 3, 2}));
        System.out.println(new P198().rob(new int[]{2}));
    }

    public int rob(int[] nums) {
        return Integer.max(helper(nums, 0, nums.length - 1), helper(nums, 1, nums.length));
    }

    int helper(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int currMax = 0, prevMax = 0;

        for (int i = start; i < end; i++) {
            int tmp = currMax;
            currMax = Integer.max(prevMax + nums[i], currMax);
            prevMax = tmp;
        }
        return currMax;
    }
}
