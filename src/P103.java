import java.util.*;

public class P103 {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        SortedMap<Integer, List<Integer>> sortedMap = new TreeMap<>();
        Queue<MyPair> queue = new LinkedList<>();
        queue.add(new MyPair(0, root));
        queue.add(null);
        while (!queue.isEmpty()) {
            while (queue.peek() != null) {
                MyPair pair = queue.poll();
                if (pair.node.left != null) queue.add(new MyPair(pair.level - 1, pair.node.left));
                if (pair.node.right != null) queue.add(new MyPair(pair.level + 1, pair.node.right));
                List<Integer> integers = sortedMap.get(pair.level);
                if (integers == null) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(pair.node.val);
                    sortedMap.put(pair.level, tmp);
                } else {
                    integers.add(pair.node.val);
                }
            }
            queue.poll();
            if (!queue.isEmpty()) queue.add(null);
        }
        return new ArrayList<>(sortedMap.values());
    }

    class MyPair {
        int level;
        TreeNode node;

        MyPair(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }


}
