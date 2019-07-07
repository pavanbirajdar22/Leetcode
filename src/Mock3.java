import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Mock3 {
    public char longestRepeatingChar(String s) {
        if (s == null || s.length() == 0) return ' ';
        int index = 0;
        int lcr = 1;
        int temp = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) temp++;
            else temp = 1;
            if (temp > lcr) {
                lcr = temp;
                index = i;
            }
        }
        return s.charAt(index);
    }

    @Test
    public void lcrTest() {
        assertEquals(' ', new Mock3().longestRepeatingChar(""));
        assertEquals('d', new Mock3().longestRepeatingChar("aaabccdddd"));
        assertEquals('a', new Mock3().longestRepeatingChar("aabc"));
        assertEquals('a', new Mock3().longestRepeatingChar("adbce"));
        assertEquals('b', new Mock3().longestRepeatingChar("aabbbaa"));
        assertEquals(' ', new Mock3().longestRepeatingChar(null));
        assertEquals(' ', new Mock3().longestRepeatingChar(""));
    }
}
