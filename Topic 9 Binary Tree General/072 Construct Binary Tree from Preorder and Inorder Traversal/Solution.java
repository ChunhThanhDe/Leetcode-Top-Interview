/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2025-01-09 08:52:33
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode(int x, TreeNode left, TreeNode right) {
        val = x;
        this.left = left;
        this.right = right;
    }
}

/// What is preorder traversal and inorder traversall
///
/// Binary Tree Structure:
///         1
///       /   \
///      2     3
///     / \   / \
///    4   5 6   7
///
/// ----------------------------------------------------------------
///
/// * Preorder Traversal (Root → Left → Right):
///
/// Step 1: Start with the root node (1).
/// Step 2: Visit the left subtree:
/// - Root of the left subtree is 2.
/// - Visit the left child of 2, which is 4.
/// - Visit the right child of 2, which is 5.
/// Step 3: Visit the right subtree:
/// - Root of the right subtree is 3.
/// - Visit the left child of 3, which is 6.
/// - Visit the right child of 3, which is 7.
/// Result of Preorder Traversal: [1, 2, 4, 5, 3, 6, 7]
///
/// ----------------------------------------------------------------
///
/// * Inorder Traversal (Left → Root → Right):
///
/// Step 1: Start with the left subtree of the root (1).
/// - Visit the left child of 2, which is 4.
/// - Visit the root of the left subtree, which is 2.
/// - Visit the right child of 2, which is 5.
/// Step 2: Visit the root node (1).
/// Step 3: Visit the right subtree of the root (1):
/// - Visit the left child of 3, which is 6.
/// - Visit the root of the right subtree, which is 3.
/// - Visit the right child of 3, which is 7.
/// Result of Inorder Traversal: [4, 2, 5, 1, 6, 3, 7]
///

// input: 2 arrays, preorder and inorder
// output: head node of the tree
class Solution {
    // Pointer to track the current index in preorder array
    private int preorderIndex = 0;
    // Map to store the index of each value in inorder array
    private HashMap<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // create a map to store the index of each value in the inorder array
        inorderIndexMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        // Start building the binary tree
        return buildSubtree(preorder, 0, inorder.length - 1);
    }

    ///
    /// for Example:
    ///
    /// Preorder Traversal: [1, 2, 4, 5, 3, 6, 7]
    /// (Root -> Left -> Right)
    /// Inorder Traversal: [4, 2, 5, 1, 6, 3, 7]
    /// (Left -> Root -> Right)
    ///
    /// Goal: Reconstruct the binary tree from preorder and inorder arrays.
    ///
    /// Step-by-step explanation using the example:
    /// - Start with preorderIndex = 0 (points to the root in the preorder array).
    /// - Find rootValue = preorder[preorderIndex].
    /// - Locate rootValue in the inorder array to divide it into left and right
    /// subtrees.
    /// - Recursively repeat the process for left and right subtrees.
    ///
    private TreeNode buildSubtree(int[] preorder, int left, int right) {
        // If there are no elements in the current subtree
        // For example, when left > right, it means the subtree is empty.
        if (left > right) {
            return null; // No tree can be built, return null
        }

        // Get the current value from the preorder array (root of the subtree)
        // Example: At the start, preorderIndex = 0, so rootValue = preorder[0] = 1.
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue); // Create a new TreeNode with rootValue.

        // Find the index of rootValue in the inorder array.
        // Example: rootValue = 1, its index in inorder = 3.
        // Left subtree in inorder: [4, 2, 5]
        // Right subtree in inorder: [6, 3, 7]
        int inorderIndex = inorderIndexMap.get(rootValue);

        // Recursively build the left subtree
        // For rootValue = 1, left subtree is built from inorder[0] to inorder[2].
        root.left = buildSubtree(preorder, left, inorderIndex - 1);

        // Recursively build the right subtree
        // For rootValue = 1, right subtree is built from inorder[4] to inorder[6].
        root.right = buildSubtree(preorder, inorderIndex + 1, right);

        // Return the constructed subtree rooted at the current root.
        return root;
    }

}

// Unit test
class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] preorder1 = { 3, 9, 20, 15, 7 };
        int[] inorder1 = { 9, 3, 15, 20, 7 };
        TreeNode root1 = solution.buildTree(preorder1, inorder1);
        System.out.println("Test Case 1:");
        printTree(root1); // Expected output: Tree representation

        System.out.println();

        // Test Case 2
        int[] preorder2 = { -1 };
        int[] inorder2 = { -1 };
        TreeNode root2 = solution.buildTree(preorder2, inorder2);
        System.out.println("Test Case 2:");
        printTree(root2); // Expected output: Tree representation
    }

    // Helper method to print the tree in level order for validation
    private static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current != null) {
                System.out.print(current.val + " ");
                queue.offer(current.left);
                queue.offer(current.right);
            } else {
                System.out.print("null ");
            }
        }
    }
}
