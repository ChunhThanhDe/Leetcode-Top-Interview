## 100. Same Tree 🔗

**Difficulty**: `Easy` - **Tags**: `Binary Tree`, `DFS`, `Recursion`

[LeetCode Problem Link](https://leetcode.com/problems/same-tree/)

---

### Problem Statement 📜

Given the roots of two binary trees `p` and `q`, write a function to check if they are the same or not.

Two binary trees are considered the same if they are:
1. Structurally identical.
2. Have nodes with the same values.

---

### Examples 🌟

🔹 **Example 1**:

![](ex1.jpg)

**Input**:

```plaintext
p = [1,2,3], q = [1,2,3]
```

**Output**:

```plaintext
true
```

---

🔹 **Example 2**:

![](ex2.jpg)

**Input**:

```plaintext
p = [1,2], q = [1,null,2]
```

**Output**:

```plaintext
false
```

---

🔹 **Example 3**:

![](ex3.jpg)

**Input**:

```plaintext
p = [1,2,1], q = [1,1,2]
```

**Output**:

```plaintext
false
```

---

### Constraints ⚙️

- The number of nodes in both trees is in the range `[0, 100]`.
- `-10⁴ <= Node.val <= 10⁴`.

---

### Solution 💡

To determine if two trees are the same, compare the following for both trees:
1. Values of the current nodes.
2. Recursively check their left and right subtrees.

---

#### Java Solution (Recursive Approach)

```java
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Both nodes are null: the trees are identical
        if (p == null && q == null) {
            return true;
        }
        // One node is null, or the values are different: the trees are not the same
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        // Recursively check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
```

---

### Explanation of the Solution

1. If both nodes are `null`, the subtrees are identical, return `true`.
2. If only one node is `null` or their values are not equal, return `false`.
3. Recursively compare the left and right subtrees of `p` and `q`.
4. If both recursive calls return `true`, the trees are the same.

---

### Time Complexity ⏳

- **O(n)**, where `n` is the minimum number of nodes in both trees. Each node is visited once.

### Space Complexity 💾

- **O(h)**, where `h` is the height of the tree (stack space for recursion).

---

### Follow-up 🧐

- Consider solving the problem iteratively using a stack or queue.
- How would the solution change if the input was not binary trees but general trees?

You can find the full solution [here](Solution.java)