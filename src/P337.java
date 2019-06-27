public class P337 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        System.out.println(new P337().rob(root));
        root.left = new TreeNode(100);
        System.out.println(new P337().rob(root));
        System.out.println(new P337().rob(root));
    }

    public int rob(TreeNode root) {
        return 0;
    }
}
