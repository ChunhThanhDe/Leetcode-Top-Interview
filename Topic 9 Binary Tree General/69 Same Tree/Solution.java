
class TreeNode {
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

// input: 2 root of TreeNode
// output: boolean by compare 2 Binary tree
public class Solution {
    public boolean isSameTree (TreeNode p, TreeNode q){
        if (p == null && q == null) return true;

         // One node is null, or the values are different: the trees are not the same
        if (q == null || p == null || q.val != p.val){
            return false;
        }

        // Recursively check left and right subtrees
        return isSameTree(q.left, q.left) && isSameTree(p.right, q.right);
    }
}

// unit test
class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        // Input: p = [1,2,3], q = [1,2,3]
        TreeNode p1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        boolean result1 = solution.isSameTree(p1, q1);
        System.out.println("Test Case 1: Expected = true, Actual = " + result1);

        // Test Case 2
        // Input: p = [1,2], q = [1,null,2]
        TreeNode p2 = new TreeNode(1, new TreeNode(2), null);
        TreeNode q2 = new TreeNode(1, null, new TreeNode(2));
        boolean result2 = solution.isSameTree(p2, q2);
        System.out.println("Test Case 2: Expected = false, Actual = " + result2);
    }
}