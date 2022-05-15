package DSA;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedList obj = new ReverseLinkedList();
        ListNode ip = new ListNode(1);
        ListNode ip2 = new ListNode(2);
        ListNode ip3 = new ListNode(3);
        ListNode ip4 = new ListNode(4);
        ListNode ip5 = new ListNode(5);
        ListNode ip6 = new ListNode(6);
        ip.next = ip2;
        ip2.next = ip3;
        ip3.next = ip4;
        ip4.next = ip5;
        ip5.next = ip6;
        obj.reverseList(ip, 3);
    }

    public ListNode reverseList(ListNode A, int B) {
        if(A == null) return null;
        ListNode curr = A;
        ListNode prev = null;
        ListNode output = null;
        while(curr != null) {
            ListNode temp = curr;
            for(int i = 1; i <= B; i++) {
                temp = temp.next;
            }
            ListNode currHead = reverse(curr, B);
            if(output == null) output = currHead;
            if(prev != null) prev.next = currHead;
            for(int i = 1; i < B; i++) {
                currHead = currHead.next;
            }
            currHead.next = temp;
            prev = currHead;
            curr = temp;
        }
        return output;
    }

    private ListNode reverse(ListNode head, int B) {
        ListNode curr = head;
        ListNode prev = null;
        for(int i = 1; i <= B && curr != null; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
