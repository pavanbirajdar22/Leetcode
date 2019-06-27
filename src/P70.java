public class P70 {
    public static void main(String[] args) {
        System.out.println(new P70().climbStairs(3));
        System.out.println(new P70().climbStairs(1));
        System.out.println(new P70().climbStairs(2));
        System.out.println(new P70().climbStairs(10));
    }

    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return helper(n, 1, 2, 3);
    }

    private int helper(int n, int a, int b, int curr) {
        if (n == curr) return a + b;
        return helper(n, b, a + b, curr + 1);
    }
}
