package tree;

import java.util.ArrayList;
import java.util.Stack;

public class gfg_IterativePreorderTraversal {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static ArrayList<Integer> preOrder(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        if (root == null) return arr;

        Stack<Node> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            Node curr = st.pop();
            arr.add(curr.data);

            if (curr.right != null) st.push(curr.right);
            if (curr.left != null) st.push(curr.left);
        }
        return arr;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Iterative Preorder Traversal: " + preOrder(root));
    }
}