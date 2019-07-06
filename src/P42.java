import java.util.Stack;

public class P42 {
    public static void main(String[] args) {
        new P42().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }

    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0, curr = 0;
        while (curr < height.length) {
            while (!stack.empty() && (height[curr] > height[stack.peek()])) {
                int top = stack.pop();
                if (stack.empty()) break;
                int distance = curr - stack.peek() - 1;
                int h = Integer.min(height[stack.peek()], height[curr]) - height[top];
                ans += (distance * h);
                System.out.println("curr - " + curr
                        + " top - " + top
                        + " stack prev - " + stack.peek()
                        + " water - " + distance * h);
            }
            stack.add(curr);
            curr++;
        }
        return ans;
    }
}
