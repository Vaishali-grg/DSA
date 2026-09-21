package linkedlist;

public class LC1721_SwappingNodesInLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode swapNodes(ListNode head, int k) {
        ListNode first = head;
        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        ListNode second = head;
        ListNode temp = first;
        while (temp.next != null) {
            temp = temp.next;
            second = second.next;
        }

        int v = first.val;
        first.val = second.val;
        second.val = v;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode res = swapNodes(head, 2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}