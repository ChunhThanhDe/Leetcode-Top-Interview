## 226. Invert Binary Tree 🔗

**Difficulty**: `Easy` - **Tags**: `Binary Tree`, `DFS`, `BFS`, `Recursion`

[LeetCode Problem Link](https://leetcode.com/problems/invert-binary-tree/)

---

### Problem Statement 📜

Given the root of a binary tree, invert the tree (swap the left and right subtrees), and return its root.

---

### Examples 🌟

🔹 **Example 1**:

**Input**:

```plaintext
root = [4,2,7,1,3,6,9]
```

**Output**:

```plaintext
[4,7,2,9,6,3,1]
```

---

🔹 **Example 2**:

**Input**:

```plaintext
root = [2,1,3]
```

**Output**:

```plaintext
[2,3,1]
```

---

🔹 **Example 3**:

**Input**:

```plaintext
root = []
```

**Output**:

```plaintext
[]
```

---

### Constraints ⚙️

- The number of nodes in the tree is in the range `[0, 100]`.
- `-100 <= Node.val <= 100`.

---

### Solution 💡

To invert a binary tree:
1. Swap the left and right children of the current node.
2. Recursively apply the same operation for each child.

---

#### Java Solution (Recursive Approach)

```java
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null; // Base case: empty tree
        }

        // Swap the left and right subtrees
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert the left and right subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root; // Return the modified tree
    }
}
```

---

### Explanation of the Solution

1. **Base Case**: If the current node is `null`, return `null`.
2. Swap the left and right children of the node.
3. Recursively call `invertTree` for the left and right subtrees.
4. Return the root after performing all swaps.

---

#### Java Solution (Iterative Approach with Queue)

```java
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            // Swap the left and right subtrees
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            // Add children to the queue
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        return root; // Return the modified tree
    }
}
```

---

### Time Complexity ⏳

- **O(n)**, where `n` is the number of nodes in the tree. Each node is visited once.

### Space Complexity 💾

- **O(h)** for the recursive approach, where `h` is the height of the tree (stack space for recursion).
- **O(n)** for the iterative approach due to the queue.

---

### Follow-up 🧐

- How would you modify the solution for a n-ary tree?
- Implement a solution to invert a binary tree in postorder traversal.