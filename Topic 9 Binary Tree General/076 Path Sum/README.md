## 112. Path Sum 🔗

**Difficulty**: `Easy` - **Tags**: `Binary Tree`, `Depth-First Search (DFS)`, `Recursion`

[LeetCode Problem Link](https://leetcode.com/problems/path-sum/)

---

### Problem Statement 📜

Given the root of a binary tree and an integer `targetSum`, return `true` if the tree has a **root-to-leaf path** such that the sum of all the node values along the path equals `targetSum`.

- A **leaf** is a node with no children.

---

### Examples 🌟

🔹 **Example 1**:

![](pathsum1.jpg)

**Input**:

```plaintext
root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
```

**Output**:

```plaintext
true
```

**Explanation**:

The root-to-leaf path `[5,4,11,2]` has a sum of `22`.

---

🔹 **Example 2**:

![](pathsum2.jpg)

**Input**:

```plaintext
root = [1,2,3], targetSum = 5
```

**Output**:

```plaintext
false
```

**Explanation**:

There are two root-to-leaf paths:
- Path `1 -> 2`: Sum is `3`.
- Path `1 -> 3`: Sum is `4`.

Neither equals `5`.

---

🔹 **Example 3**:

**Input**:

```plaintext
root = [], targetSum = 0
```

**Output**:

```plaintext
false
```

**Explanation**:

The tree is empty, so there are no root-to-leaf paths.

---

### Constraints ⚙️

- The number of nodes in the tree is in the range `[0, 5000]`.
- `-1000 <= Node.val <= 1000`
- `-1000 <= targetSum <= 1000`

---

### Solution 💡

To determine if there is a root-to-leaf path with the given `targetSum`:
1. Use **Depth-First Search (DFS)** to traverse the binary tree.
2. Subtract the current node's value from `targetSum` as you traverse.
3. Check if:
   - The current node is a **leaf**.
   - The updated `targetSum` equals `0`.

---

#### Java Solution

```java
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Base case: if the tree is empty, there is no path
        if (root == null) return false;

        // If it's a leaf node, check if the targetSum matches the node's value
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Recursively check left and right subtrees
        int remainingSum = targetSum - root.val;
        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }
}
```

---

### Explanation of the Solution

1. **Base Case**:
   - If the root is `null`, the tree is empty, and no path exists.

2. **Leaf Node Check**:
   - If the node has no children, compare its value to the remaining `targetSum`.

3. **Recursive Calls**:
   - Subtract the current node's value from `targetSum`.
   - Recursively check the left and right subtrees.

4. **Combine Results**:
   - Use the logical `OR` operator to combine results from both subtrees.

---

### Time Complexity ⏳

- **O(n)**: Each node is visited once.

### Space Complexity 💾

- **O(h)**: Where `h` is the height of the tree (due to recursion stack).

---

### Follow-up Challenges 🧐

- How would you modify this solution to return all paths with the target sum?
- Can you solve this iteratively instead of using recursion?

You can find the full solution [here](Solution.java).