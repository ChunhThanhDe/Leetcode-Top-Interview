/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2025-01-16 08:57:03
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int x) { val = x; }
    TreeNode(int x, TreeNode left, TreeNode right) {
        this.val = x;
        this.left = left;
        this.right = right;
    }
}


// input: TreeNode, root of a binary tree
// output: int, max of sum of any path in the tree
class Solution {
    private int maxSum = Integer.MIN_VALUE;
    
    public int  maxPathSum(TreeNode root){
        dfs(root);
        return maxSum;
    }


    private int dfs (TreeNode root){
        if (root == null) return 0;

            // Recursively calculate the max sum of path for the left and right subtree
            int left = Math.max(dfs(root.left), 0);
            int right = Math.max(dfs(root.right), 0);

            // Calculate the current sum passing through the current node
            int currentSum = root.val + left + right;

            // Update the max sum if current sum is greater
            maxSum = Math.max(currentSum, maxSum);

            // return the max path sum thay can be extended to the parent node;
            return root.val + Math.max(right, left);
    }
}
