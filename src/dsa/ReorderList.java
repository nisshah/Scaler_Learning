package dsa;

public class ReorderList {

    public static void main(String[] args) {
        ReorderList obj = new ReorderList();
        ListNode ip1 = new ListNode(1);
        ListNode ip2 = new ListNode(2);
        ListNode ip3 = new ListNode(3);
        ListNode ip4 = new ListNode(4);
        ip1.next = ip2;
        ip2.next = ip3;
        ip3.next = ip4;
        obj.reorderList(ip1);
    }

    public ListNode reorderList(ListNode A) {
        if (A == null) return null;
        ListNode fast = A;
        ListNode slow = A;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode reverse = reverse(slow);

        ListNode ans = A;
        ListNode head = ans;
        ListNode curr = A.next;
        int count = 0;
        while (curr != null && reverse != null && curr != reverse) {
            if (count % 2 == 0) {
                head.next = reverse;
                reverse = reverse.next;
            } else {
                head.next = curr;
                curr = curr.next;
            }
            head = head.next;
            count++;
        }
        return ans;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static class ListNode {
        public int val;
        public ReorderList.ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
