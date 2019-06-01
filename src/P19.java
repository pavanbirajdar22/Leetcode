public class P19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        ListNode tbd = head;
        ListNode pre = null;
        while (n!=0) {
            temp = temp.next;
            n--;
        }
        while (temp!=null) {
            temp = temp.next;
            pre = tbd;
            tbd = tbd.next;
        }
        if (pre == null) {
            if (tbd.next == null) return null;
            else return head.next;
        }
        pre.next = tbd.next;
        return head;
    }

}
