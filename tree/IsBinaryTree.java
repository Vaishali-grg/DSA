package tree;

import java.util.ArrayList;
import java.util.List;

public class IsBinaryTree {
    static class Node {
        int val;
        List<Node> children;

        Node(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    public static boolean isBinaryTree(Node root) {
        if (root == null) return true;
        if (root.children.size() > 2) return false;
        for (Node child : root.children) {
            if (!isBinaryTree(child)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.children.add(new Node(2));
        root.children.add(new Node(3));
        root.children.add(new Node(4));

        System.out.println("Is Binary Tree: " + isBinaryTree(root));
    }
}