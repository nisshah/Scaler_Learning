package dsa;

public class RandomListDeepCopy {

    static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    public static void main(String[] args) {
        RandomListDeepCopy obj = new RandomListDeepCopy();
        RandomListNode one = new RandomListNode(1);
        RandomListNode two = new RandomListNode(2);
        RandomListNode three = new RandomListNode(3);
        one.next = two;
        two.next = three;
        one.random = three;
        two.random = one;
        three.random = one;
        obj.copyRandomList(one);
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode curr = head;
        if (curr == null) return null;

        while (curr != null) {
            RandomListNode next = curr.next;
            RandomListNode newCurr = new RandomListNode(curr.label);
            curr.next = newCurr;
            newCurr.next = next;
            curr = curr.next.next;
        }

        curr = head;
        while (curr != null && curr.next != null) {
            RandomListNode random = curr.random;
            curr.next.random = random.next;
            curr = curr.next.next;
        }

        curr = head;
        curr = curr.next;
        RandomListNode ans = curr;
        RandomListNode newHead = ans;
        while (curr != null && curr.next != null) {
            curr = curr.next.next;
            newHead.next = curr;
            newHead = newHead.next;
        }

        return ans;
    }
}
