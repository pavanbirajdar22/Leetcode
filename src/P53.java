public class P53 {
    public static void main(String[] args) {
        int[] a = {0, -1, -2, 5, -1, 5};
        int[] b = {4, -1, -2, 5};
        System.out.println(new P53().maxSubArray(a));
        System.out.println(new P53().maxSubArray(b));
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int global_max = nums[0];
        int max_ending_here = nums[0];
        int start = 0, end = 0;
        boolean flag = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > (nums[i] + max_ending_here)) {
                max_ending_here = nums[i];
                flag = true;
            } else {
                max_ending_here = nums[i] + max_ending_here;
                flag = false;
            }
            if (max_ending_here > global_max) {
                if (flag) {
                    start = i;
                    end = i;
                } else {
                    end = i;
                }
                global_max = max_ending_here;
            }
        }
        System.out.println(nums[start] + " " + nums[end]);
        return global_max;
    }
}
