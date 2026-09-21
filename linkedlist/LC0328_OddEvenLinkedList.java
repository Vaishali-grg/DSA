package linkedlist;

public class LC0328_OddEvenLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode d1 = new ListNode(-1);
        ListNode d2 = new ListNode(-1);

        ListNode t1 = d1;
        ListNode t2 = d2;

        ListNode t = head;
        int count = 1;

        while (t != null) {
            if (count % 2 != 0) {
                t1.next = t;
                t1 = t1.next;
            } else {
                t2.next = t;
                t2 = t2.next;
            }
            t = t.next;
            count++;
        }
        t2.next = null;
        t1.next = d2.next;
        return d1.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode res = oddEvenList(head);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}