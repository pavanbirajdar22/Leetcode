import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        //boolean straight = true;
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            while (queue.peek() != null) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                tmp.add(node.val);
            }
            queue.poll();
            if (!queue.isEmpty()) queue.add(null);
            /*
            if (!straight) {
                Collections.reverse(tmp);
            }
            straight = !straight;
            */
            ans.add(tmp);
        }
        return ans;
    }
}
