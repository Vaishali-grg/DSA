package doublylinkedlist;

public class DoublyLinkedListReverse {

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // Insert At Beginning (Fixed syntax errors)
    static Node insertAtBeginning(Node head, int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
        return head;
    }

    // Traverses to end and prints backward using .prev
    static void printReverse(Node head) {
        if (head == null) return;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
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

        printReverse(head);
    }
}