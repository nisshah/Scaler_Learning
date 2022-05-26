package dsa;

public class ReverseLinkedList2 {
    public static void main(String[] args) {
        ReverseLinkedList2 obj = new ReverseLinkedList2();
        ListNode ip = new ListNode(1);
        ListNode ip2 = new ListNode(2);
        ListNode ip3 = new ListNode(3);
        ListNode ip4 = new ListNode(4);
        ListNode ip5 = new ListNode(5);
        ip.next = ip2;
        ip2.next = ip3;
        ip3.next = ip4;
        ip4.next = ip5;
        System.out.println(obj.reverseList(ip, 2, 4));
    }

    public ListNode reverseList(ListNode A, int B, int C) {
        ListNode head = A;
        ListNode temp = null;
        int count = 1;
        while(head != null && count != B) {
            temp = head;
            head = head.next;
            count++;
        }

        ListNode curr = head;
        ListNode prev = null;
        while(count != C + 1 && curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if(head != null) {
            head.next = curr;
            if(temp != null) {
                temp.next = prev;
            }
            else {
                A = prev;
            }
        }
        return A;
    }

    private static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
        StringBuilder builder = new StringBuilder();

        @Override
        public String toString() {
            ListNode node = this;
            while(node != null) {
                builder.append(node.val);
                builder.append("_");
                node = node.next;
            }
            return builder.toString();
        }
    }
}
