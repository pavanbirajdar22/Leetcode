public class P206 {
    public ListNode reverseList(ListNode head) {
        return rev(null, head);
    }

    private ListNode rev(ListNode prev, ListNode curr) {
        if (curr == null) return prev;
        ListNode tmp = curr.next;
        curr.next = prev;
        return rev(curr, tmp);
    }
}
