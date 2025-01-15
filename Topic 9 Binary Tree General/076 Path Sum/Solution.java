class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){
        this.val = val;
    }
    TreeNode (int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// input: head of the tree, int target sum
// output: true if there is a path from root to leaf that sums up to target sum, false otherwise
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum){
        if (root == null) return false;

        // if it is a leaf Node, check if the targetSum matches the value of the leaf node
               
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
         }
    
        // Recursively check left and right subtrees
        int remainingSum = targetSum - root.val;
        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }
     
}
