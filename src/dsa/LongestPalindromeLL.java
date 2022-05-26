package dsa;

public class LongestPalindromeLL {

    public int solve(ListNode A) {
        if (A == null) return 0;
        ListNode copy = createCopy(A);
        int max = 0;

        ListNode node = A;
        ListNode next = node.next;
        ListNode prev = null;
        while (node != null) {
            int count = 1;
            ListNode nextTemp = next;
            ListNode prevTemp = prev;
            while (prev != null && next != null && prev.val == next.val) {
                prev = prev.next;
                next = next.next;
                count += 2;
            }
            max = Math.max(max, count);

            node.next = prevTemp;
            if(nextTemp != null) {
                next = nextTemp.next;
            }
            prev = node;
            node = nextTemp;
        }

        if(copy.next == null) return max;

        ListNode node1 = copy;
        ListNode node2 = copy.next;
        next = node2.next;
        prev = null;
        while (node1 != null && node2 != null) {
            int count = node1.val == node2.val ? 2 : 0;
            ListNode nextTemp = next;
            ListNode prevTemp = prev;
            while (node1.val == node2.val && prev != null && next != null && prev.val == next.val) {
                prev = prev.next;
                next = next.next;
                count += 2;
            }
            max = Math.max(max, count);

            node1.next = prevTemp;
            if(nextTemp != null) {
                next = nextTemp.next;
            }
            prev = node1;
            node1 = node2;
            node2 = nextTemp;
        }

        return max;
    }

    private ListNode createCopy(ListNode A) {
        ListNode curr = A;
        ListNode head = null;
        ListNode prev = null;
        while(curr != null) {
            ListNode node = new ListNode(curr.val);
            if(prev == null) {
                head = node;
            }
            if(prev != null) {
                prev.next = node;
            }
            prev = node;
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        LongestPalindromeLL obj = new LongestPalindromeLL();
        ListNode ip = new ListNode(2);
        ListNode ip2 = new ListNode(2);
//        ListNode ip3 = new ListNode(2);
//        ListNode ip4 = new ListNode(1);
//        ListNode ip5 = new ListNode(2);
//        ListNode ip6 = new ListNode(2);
//        ListNode ip7 = new ListNode(1);
//        ListNode ip8 = new ListNode(3);
//        ListNode ip9 = new ListNode(2);
//        ListNode ip10 = new ListNode(2);
        ip.next = ip2;
//        ip2.next = ip3;
//        ip3.next = ip4;
//        ip4.next = ip5;
//        ip5.next = ip6;
//        ip6.next = ip7;
//        ip7.next = ip8;
//        ip8.next = ip9;
//        ip9.next = ip10;
        obj.solve(ip);
    }

    private static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
