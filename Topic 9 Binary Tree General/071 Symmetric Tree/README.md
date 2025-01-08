## 101. Symmetric Tree 🔗

**Difficulty**: `Easy` - **Tags**: `Binary Tree`, `DFS`, `BFS`, `Recursion`, `Iteration`

[LeetCode Problem Link](https://leetcode.com/problems/symmetric-tree/)

---

### Problem Statement 📜

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

---

### Examples 🌟

🔹 **Example 1**:

**Input**:

```plaintext
root = [1,2,2,3,4,4,3]
```

**Output**:

```plaintext
true
```

---

🔹 **Example 2**:

**Input**:

```plaintext
root = [1,2,2,null,3,null,3]
```

**Output**:

```plaintext
false
```

---

### Constraints ⚙️

- The number of nodes in the tree is in the range `[1, 1000]`.
- `-100 <= Node.val <= 100`.

---

### Follow-up 🧐

Can you solve it both recursively and iteratively?

---

### Solution 💡

To determine if a binary tree is symmetric:
1. Compare the left and right subtrees to see if they are mirrors of each other.
2. Perform this comparison recursively or iteratively.

---

#### Java Solution (Recursive Approach)

```java
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
```

---

#### Java Solution (Iterative Approach)

```java
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();

            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null || t1.val != t2.val) {
                return false;
            }

            queue.offer(t1.left);
            queue.offer(t2.right);
            queue.offer(t1.right);
            queue.offer(t2.left);
        }

        return true; // All nodes are symmetric
    }
}
```

---

### Explanation of the Solutions

1. **Recursive Approach**:
   - Compare the root's left and right subtrees.
   - Recursively check the symmetry of the outer and inner pairs of nodes.

2. **Iterative Approach**:
   - Use a queue to compare nodes in a level-order fashion.
   - Add pairs of nodes to the queue, ensuring the outer and inner children are paired.

---

### Time Complexity ⏳

- **O(n)**, where `n` is the number of nodes in the tree. Each node is visited once.

### Space Complexity 💾

- **O(h)** for the recursive approach, where `h` is the height of the tree (stack space for recursion).
- **O(n)** for the iterative approach due to the queue.

---

### Follow-up Challenges 🧐

- Can you solve this problem for a multi-ary tree?
- What modifications would you make if the tree's symmetry condition depended on node depth?