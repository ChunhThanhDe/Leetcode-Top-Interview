## 105. Construct Binary Tree from Preorder and Inorder Traversal 🔗

**Difficulty**: `Medium` - **Tags**: `Binary Tree`, `Divide and Conquer`, `Recursion`

[LeetCode Problem Link](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

---

### Problem Statement 📜

Given two integer arrays `preorder` and `inorder`:
- `preorder` represents the preorder traversal of a binary tree.
- `inorder` represents the inorder traversal of the same binary tree.

Construct and return the binary tree.

---

### Examples 🌟

🔹 **Example 1**:

![](tree.jpg)

**Input**:

```plaintext
preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
```

**Output**:

```plaintext
[3,9,20,null,null,15,7]
```

---

🔹 **Example 2**:

**Input**:

```plaintext
preorder = [-1]
inorder = [-1]
```

**Output**:

```plaintext
[-1]
```

---

### Constraints ⚙️

- `1 <= preorder.length <= 3000`
- `inorder.length == preorder.length`
- `-3000 <= preorder[i], inorder[i] <= 3000`
- `preorder` and `inorder` consist of **unique values**.
- Each value in `inorder` also appears in `preorder`.
- `preorder` is guaranteed to be the preorder traversal of the tree.
- `inorder` is guaranteed to be the inorder traversal of the tree.

---

### Solution 💡

To construct the binary tree:
1. The first value in `preorder` is the root node.
2. Find the root node's position in `inorder`. Values to the left belong to the left subtree, and values to the right belong to the right subtree.
3. Recursively repeat this process for the left and right subtrees.

---

#### Java Solution

```java
import java.util.HashMap;

class Solution {
    private int preorderIndex = 0;
    private HashMap<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Create a map to store the index of each value in the inorder array
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildSubtree(preorder, 0, inorder.length - 1);
    }

    private TreeNode buildSubtree(int[] preorder, int left, int right) {
        if (left > right) {
            return null; // Base case: no elements to construct the tree
        }

        // Get the current root value from preorder
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Find the index of the root value in the inorder array
        int inorderIndex = inorderIndexMap.get(rootValue);

        // Recursively construct the left and right subtrees
        root.left = buildSubtree(preorder, left, inorderIndex - 1);
        root.right = buildSubtree(preorder, inorderIndex + 1, right);

        return root;
    }
}
```

---

### Explanation of the Solution

1. **Preorder Traversal**:
   - The first element is the root.
   - Subsequent elements belong to the left or right subtree.

2. **Inorder Traversal**:
   - Left subtree elements come before the root.
   - Right subtree elements come after the root.

3. **Recursive Construction**:
   - Use the `preorder` array to pick the root.
   - Divide the `inorder` array into left and right subtrees.
   - Recursively construct the tree for both subtrees.

---

### Time Complexity ⏳

- **O(n)**, where `n` is the number of nodes. Each node is visited once, and the `HashMap` provides `O(1)` lookups for the index.

### Space Complexity 💾

- **O(n)** for the `HashMap` and recursive stack space.

---

### Follow-up Challenges 🧐

- What changes would you make to solve the problem if the tree was not guaranteed to have unique values?
- How would the approach differ for constructing a binary search tree?

You can find the full solution [here](Solution.java).