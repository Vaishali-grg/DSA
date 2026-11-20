package tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteBinaryTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static boolean isCompleteBinaryTree(Node root) {
        if (root == null) return true;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean nullSeen = false;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr == null) {
                nullSeen = true;
            } else {
                if (nullSeen) {
                    return false; // Non-null node found after null -> not complete
                }
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);

        System.out.println("Is Complete Binary Tree: " + isCompleteBinaryTree(root));
    }
}