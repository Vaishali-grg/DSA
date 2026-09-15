package circularlinkedlist;

public class JosephusProblemCLL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node createList(int n) {
        Node head = null;
        Node tail = null;

        for (int i = 1; i <= n; i++) {
            Node newNode = new Node(i);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        if (tail != null) {
            tail.next = head;
        }
        return head;
    }

    static int josephus(int n, int k) {
        Node head = createList(n);
        Node prev = head;
        Node curr = head;

        // Position 'prev' at the last node of the circular list
        while (prev.next != head) {
            prev = prev.next;
        }

        // Eliminate every k-th node until only one remains
        while (curr.next != curr) {
            for (int i = 1; i < k; i++) {
                prev = curr;
                curr = curr.next;
            }
            System.out.println("Eliminated: " + curr.data);
            prev.next = curr.next;
            curr = prev.next;
        }

        return curr.data;
    }

    public static void main(String[] args) {
        int n = 6;
        int k = 2;
        int winner = josephus(n, k);
        System.out.println("Winner (Safe Position): " + winner);
    }
}