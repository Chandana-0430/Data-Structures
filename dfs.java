import java.util.*;

// Tree Node definition
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BinaryTreeDFS {

    // DFS method using recursion (Pre-order traversal)
    public void dfsRecursive(TreeNode root) {
        if (root == null) return;

        System.out.print(root.val + " "); // Print the current node value
        dfsRecursive(root.left);  // Recur on the left subtree
        dfsRecursive(root.right); // Recur on the right subtree
    }

    // DFS method using iteration (using stack)
    public void dfsIterative(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        System.out.println("DFS Traversal (Iterative):");
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.print(current.val + " "); // Print the current node value

            // Push right child first so that left child is processed first
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Constructing the binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        BinaryTreeDFS tree = new BinaryTreeDFS();

        // Recursive DFS Traversal
        System.out.println("DFS Traversal (Recursive):");
        tree.dfsRecursive(root);
        System.out.println();

        // Iterative DFS Traversal
        tree.dfsIterative(root);
    }
}
