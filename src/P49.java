import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for (String s : strs) {
            String encode = generateString(s);
            if (hm.containsKey(encode)) {
                List<String> l1 = hm.get(encode);
                l1.add(s);
            } else {
                List<String> l2 = new ArrayList<>();
                l2.add(s);
                hm.put(encode, l2);
            }
        }
        return new ArrayList<>(hm.values());
    }

    private String generateString(String x) {
        int[] a = new int[26];
        for (int i = 0; i < x.length(); i++) {
            a[x.charAt(i) - 'a'] += 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(a[i]).append("X");
        }
        return sb.toString();
    }
}
