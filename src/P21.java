/*
1->2->4,
3->5
1->1->2->3->4->4
 */
public class P21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        return null;
    }
}
