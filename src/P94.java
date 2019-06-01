import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !nodes.empty()) {
            while (curr!=null) {
                nodes.push(curr);
                curr = curr.left;
            }
            curr = nodes.pop();
            integers.add(curr.val);
            curr = curr.right;
        }
        return integers;
    }
}
