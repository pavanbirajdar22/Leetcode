import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P387 {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        int[] index = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a'] += 1;
            index[s.charAt(i) - 'a'] = i;
        }
        int ans = s.length();
        for (int i = 0; i < 26; i++) {
            if (count[i] == 1) {
                if (index[i] < ans) ans = index[i];
            }
        }
        return ans == s.length() ? -1 : ans;
    }

    @Test
    public void firstUniqChar() {
        assertEquals(0, new P387().firstUniqChar("leetcode"));
        assertEquals(-1, new P387().firstUniqChar(""));
        assertEquals(8, new P387().firstUniqChar("abcdabcde"));
    }
}
