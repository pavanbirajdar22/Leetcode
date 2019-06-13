import java.util.ArrayList;
import java.util.List;

class P763 {

    public static void main(String[] args) {
        P763 m = new P763();
        System.out.println(m.partitionLabels("aaaaaab"));
    }

    //
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        //one rectangle is on left of other
        if (rec2[2] <= rec1[0] || rec1[2] <= rec2[0]) {
            return false;
        }

        //one rectangle is on top of other
        return rec1[3] > rec2[1] && rec2[3] > rec1[1];
    }

    public List<Integer> partitionLabels(String S) {
        List<List<Character>> list = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            findInPreviousStacksAndMerge(list, S.charAt(i));
        }
        List<Integer> ans = new ArrayList<>();
        for (List s : list) {
            ans.add(s.size());
        }
        return ans;
    }

    private void findInPreviousStacksAndMerge(List<List<Character>> list, char charAt) {
        for (int i = 0; i < list.size(); i++) {
            List<Character> set = list.get(i);
            if (set.contains(charAt)) {
                for (int j = i + 1; j < list.size(); ) {
                    List<Character> setNext = list.get(j);
                    set.addAll(setNext);
                    list.remove(j);
                }
                set.add(charAt);
                return;
            }
        }
        List<Character> s = new ArrayList<>();
        s.add(charAt);
        list.add(s);
    }
}