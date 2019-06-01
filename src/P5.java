public class P5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n - 1; i++) {
            dp[i][i] = true;
        }
        return null;
    }
}
