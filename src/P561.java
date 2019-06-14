import java.math.BigInteger;
import java.util.Arrays;

public class P561 {
    public static void main(String[] args) {
        //System.out.println(new P561().arrayPairSum(new int[]{1, 4, 3, 2}));
        //System.out.println(new P561().arrayPairSum(new int[]{-1, -4, -3, -2}));
        System.out.println(new P561().reverse(15));
        System.out.println(new P561().reverse(-15));
        System.out.println(new P561().reverse(0));
        System.out.println(new P561().reverse(Integer.MAX_VALUE));
        System.out.println(new P561().reverse(Integer.MIN_VALUE));
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public int reverse1(int x) {
        boolean isNeg = false;
        if (x < 0) {
            isNeg = true;
            x *= -1;
        }
        String s = String.valueOf(x);
        String reverse = new StringBuilder(s).reverse().toString();
        double r = Double.valueOf(reverse);
        if (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) {
            return 0;
        }
        if (isNeg) return (int) (-1 * r);
        else return (int) r;
    }

    private int reverse(int y) {
        boolean isNeg = false;
        BigInteger b1 = new BigInteger(String.valueOf(y));
        if (b1.compareTo(BigInteger.ZERO) < 0) {
            isNeg = true;
            b1 = b1.multiply(new BigInteger(String.valueOf(-1)));
        }
        String reverse = new StringBuilder(b1.toString()).reverse().toString();

        if (isNeg) {
            String s = "-" + reverse;
            BigInteger reversed = new BigInteger(s);
            if (reversed.compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE))) < 0) {
                return 0;
            } else {
                return reversed.intValue();
            }
        } else {
            BigInteger reversed = new BigInteger(reverse);
            if (reversed.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE))) > 0) {
                return 0;
            } else {
                return reversed.intValue();
            }
        }
    }
}
