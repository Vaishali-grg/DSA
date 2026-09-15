package doublylinkedlist;

public class DoublyLinkedListDeleteFront {

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;

    public void deleteAtFront() {
        if (head == null) {
            return;
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
    }

    public void display() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " <-> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedListDeleteFront list = new DoublyLinkedListDeleteFront();

        // Building the list via head variable inside class instance
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);

        list.head = first;
        first.next = second;
        second.prev = first;
        second.next = third;
        third.prev = second;
        third.next = fourth;
        fourth.prev = third;

        System.out.print("Before deletion: ");
        list.display();

        list.deleteAtFront();

        System.out.print("After deletion at front: ");
        list.display();
    }
}