/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2025-01-03 08:09:08
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

// Definition for a binary tree node

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode right;
    TreeNode left;
    TreeNode (){}
    TreeNode (int val){this.val = val;}
    TreeNode (int val, TreeNode right, TreeNode left){
        this.val = val;
        this.right = right;
        this.left = left;
    }
}

// input: root of tree node
// output: int, max depth of tree node
//
// Queue is a data structure that operates on the FIFO (First In, First Out) principle.
// Stack  is a data structure that operates on the FILO (First In, Last Out) principle.
class Solution {
    public int maxDepth (TreeNode root){
        if (root == null) return 0;

        // Use a queue for level-order traversal (Breadth-First Search)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // add root node ti queue
        int depth = 0;

        // loop until the queue is empty
        while (!queue.isEmpty()){
            int size = queue.size(); // Get the number of nodes at the current level

            // Process all nodes at this level
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll(); // Remove the front node from the queue

                // add the left child to que queue if it exits
                if (currentNode.left != null){
                    queue.offer(currentNode.left);
                }

                // add the right child to the queue if it exists
                if (currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }

            depth ++;
        }

        return depth;
    }

}

// Unit test
class Main {
    public static void main(String[] args) {
        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Test Case 1
        // Input: root = [3, 9, 20, null, null, 15, 7]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        int result1 = solution.maxDepth(root1);
        System.out.println("Test Case 1: Expected = 3, Actual = " + result1);

        // Test Case 2
        // Input: root = [1, null, 2]
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        int result2 = solution.maxDepth(root2);
        System.out.println("Test Case 2: Expected = 2, Actual = " + result2);
    }
}