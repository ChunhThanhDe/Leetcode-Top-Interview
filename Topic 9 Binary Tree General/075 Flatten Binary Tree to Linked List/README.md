## 114. Flatten Binary Tree to Linked List 🔗

**Difficulty**: `Medium` - **Tags**: `Binary Tree`, `Depth-First Search (DFS)`, `Linked List`

[LeetCode Problem Link](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)

---

### Problem Statement 📜

Given the root of a binary tree, flatten the tree into a "linked list":

1. The "linked list" should use the same `TreeNode` class where:
   - The **right child pointer** points to the next node in the list.
   - The **left child pointer** is always `null`.

2. The "linked list" should follow the **pre-order traversal** of the binary tree.

---

### Examples 🌟

🔹 **Example 1**:

![](flaten.jpg)

**Input**:

```plaintext
root = [1,2,5,3,4,null,6]
```

**Output**:

```plaintext
[1,null,2,null,3,null,4,null,5,null,6]
```

**Explanation**:

The binary tree:

```plaintext
    1
   / \
  2   5
 / \    \
3   4    6
```

is flattened to:

```plaintext
1 -> 2 -> 3 -> 4 -> 5 -> 6
```

---

🔹 **Example 2**:

**Input**:

```plaintext
root = []
```

**Output**:

```plaintext
[]
```

---

🔹 **Example 3**:

**Input**:

```plaintext
root = [0]
```

**Output**:

```plaintext
[0]
```

---

### Constraints ⚙️

- The number of nodes in the tree is in the range `[0, 2000]`.
- `-100 <= Node.val <= 100`.

---

### Follow-up 🧐

- Can you flatten the tree **in-place** (using `O(1)` extra space)?

---

### Solution 💡

To solve this problem:
1. Use **pre-order traversal** to flatten the tree into a linked list.
2. Modify the `TreeNode` pointers **in-place** to achieve `O(1)` space complexity.

---

#### Java Solution

```java
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode current = root;

        while (current != null) {
            // If the current node has a left child
            if (current.left != null) {
                // Find the rightmost node in the left subtree
                TreeNode rightmost = current.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }

                // Connect the rightmost node to the current's right subtree
                rightmost.right = current.right;

                // Move the left subtree to the right
                current.right = current.left;
                current.left = null;
            }

            // Move to the next node
            current = current.right;
        }
    }
}
```

---

### Explanation of the Solution

1. **Traversal**:
   - Start from the root and traverse down the tree using the right child.

2. **Rearranging Nodes**:
   - For each node:
     - If it has a left child, locate the **rightmost node** in the left subtree.
     - Attach the right subtree to the rightmost node.
     - Move the left subtree to the right and set the left child to `null`.

3. **In-place Modification**:
   - The tree is modified directly without using any extra space.

---

### Time Complexity ⏳

- **O(n)**: Each node is visited once.

### Space Complexity 💾

- **O(1)**: The tree is modified in-place without any extra data structures.

---

### Follow-up Challenges 🧐

- How would you approach the problem using recursion?
- Can you adapt this solution to work for a general graph structure?

You can find the full solution [here](Solution.java).