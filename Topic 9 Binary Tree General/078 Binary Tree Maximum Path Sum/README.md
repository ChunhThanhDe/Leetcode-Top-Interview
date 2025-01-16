## 124. Binary Tree Maximum Path Sum 🔗

**Difficulty**: `Hard` - **Tags**: `Binary Tree`, `Dynamic Programming`, `Depth-First Search (DFS)`

[LeetCode Problem Link](https://leetcode.com/problems/binary-tree-maximum-path-sum/)

---

### Problem Statement 📜

A **path** in a binary tree is a sequence of nodes where:
1. Each pair of adjacent nodes in the sequence is connected by an edge.
2. A node can only appear in the sequence at most once.
3. The path does not need to pass through the root.

The **path sum** of a path is the sum of the node values along the path.

**Task**:
- Given the root of a binary tree, return the **maximum path sum** of any non-empty path.

---

### Examples 🌟

![](exx1.jpg)

🔹 **Example 1**:

**Input**:

```plaintext
root = [1,2,3]
```

**Output**:

```plaintext
6
```

**Explanation**:
- The optimal path is `2 -> 1 -> 3` with a path sum of `2 + 1 + 3 = 6`.

---

🔹 **Example 2**:

![](exx2.jpg)

**Input**:

```plaintext
root = [-10,9,20,null,null,15,7]
```

**Output**:

```plaintext
42
```

**Explanation**:
- The optimal path is `15 -> 20 -> 7` with a path sum of `15 + 20 + 7 = 42`.

---

### Constraints ⚙️

- The number of nodes in the tree is in the range `[1, 30,000]`.
- `-1000 <= Node.val <= 1000`

---

### Solution 💡

The solution involves:
1. Using **Depth-First Search (DFS)** to explore the tree.
2. At each node, calculate:
   - The **maximum path sum** that can be extended to its parent.
   - The **maximum path sum** passing through the current node.
3. Update the global maximum path sum during the traversal.

---

#### Java Solution

```java
class Solution {
    private int maxSum = Integer.MIN_VALUE; // Global variable to store the maximum path sum

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0; // Return 0 for null nodes
        }

        // Recursively compute the maximum path sum for left and right subtrees
        int leftSum = Math.max(dfs(node.left), 0); // Ignore negative sums
        int rightSum = Math.max(dfs(node.right), 0);

        // Calculate the path sum passing through the current node
        int currentPathSum = leftSum + rightSum + node.val;

        // Update the global maximum path sum
        maxSum = Math.max(maxSum, currentPathSum);

        // Return the maximum path sum that can be extended to the parent node
        return node.val + Math.max(leftSum, rightSum);
    }
}
```

---

### Explanation of the Solution

1. **DFS Traversal**:
   - Traverse the binary tree using DFS to calculate the maximum path sum at each node.

2. **Maximum Sum at Each Node**:
   - At each node, calculate:
     - The **left subtree sum** and **right subtree sum**, ignoring negative sums (as they reduce the total sum).
     - The **current path sum**, which includes the node's value and both left and right subtree sums.

3. **Global Maximum Update**:
   - Update the `maxSum` (global variable) with the maximum value between its current value and the `currentPathSum`.

4. **Return Value**:
   - Return the sum of the current node's value and the larger of its left or right subtree sums. This represents the maximum path sum that can be extended to its parent node.

---

### Time Complexity ⏳

- **O(n)**: Each node is visited once.

### Space Complexity 💾

- **O(h)**: Where `h` is the height of the tree (due to recursion stack).

---

### Follow-up Challenges 🧐

1. How would you modify this solution to track the path that produces the maximum sum?
2. Can this solution be converted into an iterative approach using a stack?

You can find the full solution [here](Solution.java)