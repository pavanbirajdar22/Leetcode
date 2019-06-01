public class P98 {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root, long minValue, long maxValue) {
        if (root == null) return true;
        if (root.val >= maxValue || root.val <= minValue) return false;
        boolean left = helper(root.left, minValue, root.val);
        if (!left) return false;
        boolean right = helper(root.right, root.val, maxValue);
        return right;
    }
}
