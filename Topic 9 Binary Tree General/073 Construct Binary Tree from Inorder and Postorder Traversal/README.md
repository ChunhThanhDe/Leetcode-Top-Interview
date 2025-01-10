## 106. Construct Binary Tree from Inorder and Postorder Traversal 🔗

**Difficulty**: `Medium` - **Tags**: `Binary Tree`, `Divide and Conquer`, `Recursion`

[LeetCode Problem Link](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

---

### Problem Statement 📜

Given two integer arrays `inorder` and `postorder`:
- `inorder` represents the inorder traversal of a binary tree.
- `postorder` represents the postorder traversal of the same binary tree.

Construct and return the binary tree.

---

### Examples 🌟

🔹 **Example 1**:

![](tree.jpg)

**Input**:

```plaintext
inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
```

**Output**:

```plaintext
[3,9,20,null,null,15,7]
```

---

🔹 **Example 2**:

**Input**:

```plaintext
inorder = [-1]
postorder = [-1]
```

**Output**:

```plaintext
[-1]
```

---

### Constraints ⚙️

- `1 <= inorder.length <= 3000`
- `postorder.length == inorder.length`
- `-3000 <= inorder[i], postorder[i] <= 3000`
- `inorder` and `postorder` consist of **unique values**.
- Each value of `postorder` also appears in `inorder`.
- `inorder` is guaranteed to be the inorder traversal of the tree.
- `postorder` is guaranteed to be the postorder traversal of the tree.

---

### Solution 💡

To construct the binary tree:
1. The last value in `postorder` is the root node.
2. Find the root node's position in `inorder`. Values to the left belong to the left subtree, and values to the right belong to the right subtree.
3. Recursively repeat this process for the left and right subtrees.

---

#### Java Solution

```java
import java.util.HashMap;

class Solution {
    private int postorderIndex;
    private HashMap<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Initialize postorder index to the last element
        postorderIndex = postorder.length - 1;

        // Create a map to store the index of each value in the inorder array
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildSubtree(postorder, 0, inorder.length - 1);
    }

    private TreeNode buildSubtree(int[] postorder, int left, int right) {
        if (left > right) {
            return null; // Base case: no elements to construct the tree
        }

        // Get the current root value from postorder
        int rootValue = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootValue);

        // Find the index of the root value in the inorder array
        int inorderIndex = inorderIndexMap.get(rootValue);

        // Recursively construct the right and left subtrees
        root.right = buildSubtree(postorder, inorderIndex + 1, right);
        root.left = buildSubtree(postorder, left, inorderIndex - 1);

        return root;
    }
}
```

---

### Explanation of the Solution

1. **Postorder Traversal**:
   - The last element is the root.
   - The second-to-last element is part of the right subtree.

2. **Inorder Traversal**:
   - Left subtree elements come before the root.
   - Right subtree elements come after the root.

3. **Recursive Construction**:
   - Use the `postorder` array to pick the root.
   - Divide the `inorder` array into left and right subtrees.
   - Recursively construct the tree for both subtrees.

---

### Time Complexity ⏳

- **O(n)**, where `n` is the number of nodes. Each node is visited once, and the `HashMap` provides `O(1)` lookups for the index.

### Space Complexity 💾

- **O(n)** for the `HashMap` and recursive stack space.

---

### Follow-up Challenges 🧐

- Could you modify the solution if the tree had duplicate values?
- What if the input arrays were very large? How would you optimize memory usage?

You can find the full solution [here](Solution.java).