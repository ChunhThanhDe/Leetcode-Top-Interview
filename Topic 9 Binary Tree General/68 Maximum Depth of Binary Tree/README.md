## 104. Maximum Depth of Binary Tree 🔗

**Difficulty**: `Easy` - **Tags**: `Binary Tree`, `DFS`, `BFS`

[LeetCode Problem Link](https://leetcode.com/problems/maximum-depth-of-binary-tree/)

---

### Problem Statement 📜

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

---

### Examples 🌟

🔹 **Example 1**:

![](tmp-tree.jpg)

**Input**:

```plaintext
root = [3,9,20,null,null,15,7]
```

**Output**:

```plaintext
3
```

---

🔹 **Example 2**:

**Input**:

```plaintext
root = [1,null,2]
```

**Output**:

```plaintext
2
```

---

### Constraints ⚙️

- The number of nodes in the tree is in the range `[0, 10⁴]`.
- `-100 <= Node.val <= 100`.

---

### Solution 💡

To determine the maximum depth of the binary tree, we can use two common approaches:
1. **Depth-First Search (DFS)**: Traverse the tree recursively and calculate the depth at each level.
2. **Breadth-First Search (BFS)**: Use a queue to traverse level by level, tracking the depth.

---

#### Java Solution (Recursive DFS)

```java
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0; // Base case: An empty tree has a depth of 0
        }
        int leftDepth = maxDepth(root.left);  // Depth of left subtree
        int rightDepth = maxDepth(root.right); // Depth of right subtree
        return Math.max(leftDepth, rightDepth) + 1; // Add 1 for the root node
    }
}
```

---

#### Java Solution (Iterative BFS)

```java
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0; // Base case: An empty tree has a depth of 0
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size(); // Number of nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            depth++; // Increment depth after processing one level
        }

        return depth;
    }
}
```

---

### Explanation of the Solution

1. **Recursive DFS**:
   - At each node, compute the depth of the left and right subtrees recursively.
   - The maximum depth at any node is `1 + max(leftDepth, rightDepth)`.

2. **Iterative BFS**:
   - Use a queue to traverse the tree level by level.
   - Each level's nodes are processed, and their children are added to the queue.
   - Increment the depth counter after processing each level.

---

### Time Complexity ⏳

- **DFS**: O(n), where `n` is the number of nodes in the tree.
- **BFS**: O(n), since each node is visited exactly once.

### Space Complexity 💾

- **DFS**: O(h), where `h` is the height of the tree (stack space for recursion).
- **BFS**: O(n), for the queue to store nodes at each level.

---

### Follow-up 🧐

- Compare the performance of recursive DFS versus iterative BFS for very large trees.
- Consider using a stack-based iterative DFS implementation for avoiding stack overflow in deep trees.

You can find the full solution: to-learn [here](Solution.java), to coding interview [here](Solution2.java).