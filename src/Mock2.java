import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mock2 {

}

class GS2 {

    static int getCountOfPossibleTeams(List<Integer> coders) {
        int groupSize = 3;
        int n = coders.size();
        int[][] dp1 = new int[groupSize][n];
        int[][] dp2 = new int[groupSize][n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            dp1[0][i] = 1;
            dp2[0][i] = 1;
        }

        System.out.println(coders);

        for (int s = 1; s < groupSize; s++) {
            for (int i = s; i < n; i++) {
                dp1[s][i] = 0;
                dp2[s][i] = 0;
                for (int j = s - 1; j < i; j++) {
                    if (coders.get(j) < coders.get(i)) dp1[s][i] += dp1[s - 1][j];
                    else dp2[s][i] += dp2[s - 1][j];
                }
            }
        }

        for (int i = groupSize - 1; i < n; i++)
            ans += (dp1[groupSize - 1][i] + dp2[groupSize - 1][i]);

        System.out.println(Arrays.deepToString(dp1));
        System.out.println(Arrays.deepToString(dp2));

        return ans;
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(5);
        nums.add(2);
        nums.add(1);
        nums.add(3);
        nums.add(4);
        System.out.println("Number of Increasing Subsequences of size " + 3 + " = " + getCountOfPossibleTeams(nums));
    }
}

