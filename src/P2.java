import java.math.BigInteger;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class P2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger sum = BigInteger.ZERO;
        BigInteger ten = BigInteger.ONE;
        ListNode temp = l1;
        while (temp != null) {
            sum = sum.add(ten.multiply(BigInteger.valueOf(temp.val)));
            ten = ten.multiply(BigInteger.TEN);
            temp = temp.next;
        }
        ten = BigInteger.ONE;
        temp = l2;
        while (temp != null) {
            sum = sum.add(ten.multiply(BigInteger.valueOf(temp.val)));
            ten = ten.multiply(BigInteger.TEN);
            temp = temp.next;
        }
        String reverse = new StringBuffer(sum.toString()).reverse().toString();

        int i = 0;
        ListNode start = new ListNode(Character.getNumericValue(reverse.charAt(i)));
        temp = start;
        while (i < reverse.length()) {
            i++;
            temp.next = new ListNode(Character.getNumericValue(reverse.charAt(i)));
            temp = temp.next;
        }
        return start;
    }
}
