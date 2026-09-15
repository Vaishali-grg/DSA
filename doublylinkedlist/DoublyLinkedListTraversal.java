package doublylinkedlist;


public class DoublyLinkedListTraversal {

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static void printForward(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);

        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;
        third.next = fourth;
        fourth.prev = third;
        fourth.next = null;

        printForward(head);
    }
}