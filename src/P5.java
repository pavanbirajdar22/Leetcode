public class P5 {
    public static void main(String[] args) {
        System.out.println(new P5().longestPalindrome(""));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0, end = 0;
        for (int outer = 0; outer < n; outer++) {
            for (int i = 0; i < n - outer; i++) {
                int j = i + outer;
                if (i == j) {
                    start = i;
                    end = j;
                    dp[i][j] = true;
                } else if (j - i == 1 && s.charAt(i) == s.charAt(j)) {
                    start = i;
                    end = j;
                    dp[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    start = i;
                    end = j;
                    dp[i][j] = true;
                }
            }
        }

        return s.substring(start, end + 1);
    }
}
