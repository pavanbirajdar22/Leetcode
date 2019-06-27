public class P771 {
    public int numJewelsInStones(String J, String S) {
        boolean[] a = new boolean[52];
        for (int i = 0; i < J.length(); i++) {
            a[J.charAt(i) - 'a'] = true;
        }
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (a[S.charAt(i) - 'a']) count++;
        }
        return count;
    }

}
