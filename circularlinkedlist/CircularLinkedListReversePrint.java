package circularlinkedlist;

public class CircularLinkedListReversePrint {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node head = null;

    static void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = head;
    }

    // Recursively prints the circular linked list in reverse order
    static void printReverse(Node curr, Node start) {
        if (curr == null) return;

        // Recurse to the next node if it hasn't looped back to start
        if (curr.next != start) {
            printReverse(curr.next, start);
        }

        // Print node data on unwinding the stack
        System.out.print(curr.data + " ");
    }

    public static void main(String[] args) {
        insert(10);
        insert(20);
        insert(30);
        insert(40);
        insert(50);

        System.out.print("Reverse order: ");
        printReverse(head, head);
        System.out.println();
    }
}