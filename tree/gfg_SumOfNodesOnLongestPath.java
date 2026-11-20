package tree;

public class gfg_SumOfNodesOnLongestPath {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    private static int maxSum = 0;
    private static int maxLength = 0;

    private static void solve(Node root, int length, int sum) {
        if (root == null) return;
        length++;
        sum += root.data;

        if (root.left == null && root.right == null) {
            if (length > maxLength) {
                maxLength = length;
                maxSum = sum;
            } else if (length == maxLength) {
                maxSum = Math.max(sum, maxSum);
            }
            return;
        }

        solve(root.left, length, sum);
        solve(root.right, length, sum);
    }

    public static int sumOfLongRootToLeafPath(Node root) {
        maxLength = 0;
        maxSum = 0;
        solve(root, 0, 0);
        return maxSum;
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(7);
        root.left.right = new Node(1);
        root.right.left = new Node(2);
        root.right.right = new Node(3);
        root.left.right.left = new Node(6);

        System.out.println("Sum of nodes on longest path: " + sumOfLongRootToLeafPath(root));
    }
}