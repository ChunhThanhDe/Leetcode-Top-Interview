// Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true; // An empty tree is symmetric
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true; // Both nodes are null, symmetric
        }
        if (t1 == null || t2 == null) {
            return false; // One node is null, asymmetric
        }
        return (t1.val == t2.val) // Check values
            && isMirror(t1.left, t2.right) // Compare outer children
            && isMirror(t1.right, t2.left); // Compare inner children
    }
}