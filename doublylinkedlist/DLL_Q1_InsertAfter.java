package doublylinkedlist;
public class DLL_Q1_InsertAfter {
    static class Node {
        int val;
        Node prev;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    public static void insertAfter(Node head, int key, int val) {
        Node curr = head;
        while (curr != null && curr.val != key) {
            curr = curr.next;
        }

        if (curr == null) return;

        Node newNode = new Node(val);
        newNode.next = curr.next;
        newNode.prev = curr;

        if (curr.next != null) {
            curr.next.prev = newNode;
        }
        curr.next = newNode;
    }
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;

        System.out.println("Original list:");
        printList(head);

        insertAfter(head, 2, 4);

        System.out.println("List after inserting 4 after 2:");
        printList(head);
    }
}