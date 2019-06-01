class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class P101 {
    public int[] twoSum(int[] numbers, int target) {
        int ptrStart = 0;
        int ptrEnd = numbers.length - 1;
        while (ptrStart < ptrEnd) {
            int temp = numbers[ptrStart] + numbers[ptrEnd];
            if (temp == target)
                return new int[]{ptrStart + 1, ptrEnd + 1};
            if (temp > target) ptrEnd--;
            else ptrStart++;
        }
        throw new IllegalArgumentException("Not valid");
    }
}
