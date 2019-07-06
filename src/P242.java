public class P242 {
    public static void main(String[] args) {
        System.out.println(new P242().isAnagram("aa", "b"));
        System.out.println(new P242().isAnagram("aa", "bb"));

        System.out.println(new P242().isAnagram("", ""));
        System.out.println(new P242().isAnagram("ab", "ba"));
        System.out.println(new P242().isAnagram("ccbad", "dacbc"));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) a[s.charAt(i) - 'a'] += 1;
        for (int i = 0; i < t.length(); i++) a[t.charAt(i) - 'a'] -= 1;
        for (int i = 0; i < 26; i++) if (a[i] != 0) return false;
        return true;
    }
}
