/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2025-01-10 08:13:17
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (){}
    TreeNode (int val){
        this.val = val;
    }
    TreeNode (int val, TreeNode left, TreeNode right){
        this.val =val;
        this.left = left;
        this.right = right;
    }
}


///
/// Binary Tree Structure:
///         1
///       /   \
///      2     3
///     / \   / \
///    4   5 6   7
///
/// Step-by-step explanation:
/// 
/// * Postorder Traversal (Left → Right → Root):
/// 
/// Step 1: Visit the left subtree of the root (1).
///   - Go to node 2.
///   - Visit the left child of 2, which is 4 (leaf node).
///   - Visit the right child of 2, which is 5 (leaf node).
///   - Visit the root of this subtree, which is 2.
/// Step 2: Visit the right subtree of the root (1).
///   - Go to node 3.
///   - Visit the left child of 3, which is 6 (leaf node).
///   - Visit the right child of 3, which is 7 (leaf node).
///   - Visit the root of this subtree, which is 3.
/// Step 3: Finally, visit the root node (1).
///
/// Postorder Traversal Result:
/// [4, 5, 2, 6, 7, 3, 1]
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
/// 
/// Result of Inorder Traversal: 
/// [4, 2, 5, 1, 6, 3, 7]
///


// input: 2 arrays int inorder and postorder of binary tree
// output: root of binary tree
class Solution {
    private int postorderIndex;
    private HashMap<Integer, Integer> inorderIndexMap;
    public TreeNode buildTree (int[] inorder, int[] postorder){
        // Initialize postorder index to the last element
        postorderIndex = postorder.length - 1;

        // create a map to store the index of each value in the inorder array
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i ++){
            inorderIndexMap.put(inorder[i],i);
        }

        return buildSubTree(postorder, 0, inorder.length - 1);
    }

    public TreeNode buildSubTree(int[] postorder, int left, int right){
        if (left > right){
            return null; // base case: no element to construct the ree
        }

        // get the current root value from postorder
        int rootValue = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootValue);

        // Find the index of the root value in the inorder array
        int inorderIndex = inorderIndexMap.get(rootValue);

        // ReCúiveLy construct the right and left subtrees
        root.right = buildSubTree (postorder, inorderIndex + 1, right);
        root.left = buildSubTree (postorder, left, inorderIndex -1);

        return root;
    }
}

// Unit test
class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] postorder1 = { 9,15,7,20,3 };
        int[] inorder1 = { 9,3,15,20,7 };
        TreeNode root1 = solution.buildTree(inorder1, postorder1);
        System.out.println("Test Case 1:");
        printTree(root1); // Expected output: Tree representation

        System.out.println();

        // Test Case 2
        int[] postorder2 = { -1 };
        int[] inorder2 = { -1 };
        TreeNode root2 = solution.buildTree( inorder2, postorder2);
        System.out.println("Test Case 2:");
        printTree(root2); // Expected output: Tree representation
    }

    // Helper method to print the tree in level order for validation
    private static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
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


