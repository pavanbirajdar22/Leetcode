public class P266 {
    public static void main(String[] args) {
        System.out.println(new P266().canPermutePalindrome("abab"));
        System.out.println(new P266().canPermutePalindrome(""));
        System.out.println(new P266().canPermutePalindrome("adbc"));
        System.out.println(new P266().canPermutePalindrome("a"));
        System.out.println(new P266().canPermutePalindrome("AaBb//a"));
        System.out.println(new P266().canPermutePalindrome("&&"));
        System.out.println(new P266().canPermutePalindrome("&@1&@"));
    }

    public boolean canPermutePalindrome(String s) {
        if (s == null || s.isEmpty()) return true;
        int[] a = new int[128];
        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i);
            a[pos]++;
        }
        int oddCounts = 0;
        for (int i = 0; i < 128; i++) {
            if (a[i] % 2 != 0) oddCounts++;
        }
        if (s.length() % 2 == 0 && oddCounts == 0) return true;
        return s.length() % 2 != 0 && oddCounts == 1;
    }
}
