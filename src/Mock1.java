import java.util.ArrayList;
import java.util.List;

public class Mock1 {
    static int countSubSequence(List<Integer> inputSeq, int targetSum) {
        int count = 0;
        for (int i = 0; i < inputSeq.size(); i++) {
            int sum = 0;
            for (int j = i; j < inputSeq.size(); j++) {
                sum += inputSeq.get(j);
                if (sum == targetSum) count++;
                else if (sum > targetSum) break;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(0);
        nums.add(1);
        nums.add(0);
        nums.add(5);
        System.out.println(Mock1.countSubSequence(nums, 1));
    }
}
