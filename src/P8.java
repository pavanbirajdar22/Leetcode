import java.math.BigInteger;

class P8 {
    public static void main(String[] args) {
        System.out.println(new P8().myAtoi("words and 987"));
        System.out.println(new P8().myAtoi("-91283472332"));
        System.out.println(new P8().myAtoi("4193 with words"));
        System.out.println(new P8().myAtoi("   -42"));
        System.out.println(new P8().myAtoi("55"));
        System.out.println(new P8().myAtoi("-55"));
        System.out.println(new P8().myAtoi(""));
        System.out.println(new P8().myAtoi("     "));
        System.out.println(new P8().myAtoi("    +"));
        System.out.println(new P8().myAtoi("    + 123"));
        System.out.println(new P8().myAtoi("-    "));
        System.out.println(new P8().myAtoi("  0000000000012345678"));
        System.out.println(new P8().myAtoi("20000000000000000000"));
    }

    public int myAtoi(String str) {
        //String s = str.stripLeading(); java11
        if (str.length() == 0) {
            return 0;
        }
        int start = 0;
        while (start < str.length() && str.charAt(start) == ' ') {
            start++;
        }
        String s = str.substring(start);
        if (s.length() == 0) return 0;
        if (s.charAt(0) == '+') {
            return getNumber(s, 1, 1);
        } else if (s.charAt(0) == '-') {
            return getNumber(s, 1, -1);
        } else if (Character.isDigit(s.charAt(0))) {
            return getNumber(s, 0, 1);
        } else {
            return 0;
        }
    }

    private int getNumber(String s, int start, int sign) {
        if (s.length() == 0) return 0;
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else {
                break;
            }
        }
        if (sb.length() == 0) return 0;
        //-214_748_364_8
        /*
        if (sb.length() > 10) {
            if (sign == -1) return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }
        */

        BigInteger b1, b2;
        if (sign == -1) {
            b1 = new BigInteger("-" + sb.toString());
            b2 = new BigInteger(String.valueOf(Integer.MIN_VALUE));
            if (b1.compareTo(b2) < 0) {
                return Integer.MIN_VALUE;
            } else return b1.intValue();
        }


        b1 = new BigInteger(sb.toString());
        b2 = new BigInteger(String.valueOf(Integer.MAX_VALUE));
        if (b1.compareTo(b2) > 0) {
            return Integer.MAX_VALUE;
        } else return b1.intValue();
    }
}