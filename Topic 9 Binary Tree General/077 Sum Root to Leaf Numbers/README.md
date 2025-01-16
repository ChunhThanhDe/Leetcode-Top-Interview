## 129. Sum Root to Leaf Numbers 🔗

**Difficulty**: `Medium` - **Tags**: `Binary Tree`, `Depth-First Search (DFS)`, `Backtracking`, `Math`

[LeetCode Problem Link](https://leetcode.com/problems/sum-root-to-leaf-numbers/)

---

### Problem Statement 📜

You are given the root of a binary tree containing digits from `0` to `9` only.

Each **root-to-leaf path** in the tree represents a number. For example:
- The root-to-leaf path `1 -> 2 -> 3` represents the number `123`.

**Task**:
- Return the total sum of all root-to-leaf numbers.

- A **leaf node** is a node with no children.

---

### Examples 🌟

🔹 **Example 1**:

![](num1tree.jpg)

**Input**:

```plaintext
root = [1,2,3]
```

**Output**:

```plaintext
25
```

**Explanation**:
- The root-to-leaf path `1 -> 2` represents the number `12`.
- The root-to-leaf path `1 -> 3` represents the number `13`.

Total sum: `12 + 13 = 25`.

---

🔹 **Example 2**:

![](num2tree.jpg)

**Input**:

```plaintext
root = [4,9,0,5,1]
```

**Output**:

```plaintext
1026
```

**Explanation**:
- The root-to-leaf path `4 -> 9 -> 5` represents the number `495`.
- The root-to-leaf path `4 -> 9 -> 1` represents the number `491`.
- The root-to-leaf path `4 -> 0` represents the number `40`.

Total sum: `495 + 491 + 40 = 1026`.

---

### Constraints ⚙️

- The number of nodes in the tree is in the range `[1, 1000]`.
- `0 <= Node.val <= 9`
- The depth of the tree will not exceed `10`.

---

### Solution 💡

To compute the sum of all root-to-leaf numbers:
1. Use **Depth-First Search (DFS)** or **Backtracking** to traverse the binary tree.
2. Pass the current accumulated value (a running total) down the recursion stack.
3. When a leaf node is reached, add the accumulated value to the result.

---

#### Java Solution

```java
class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode node, int currentSum) {
        // Base case: if the node is null, return 0
        if (node == null) return 0;
        
        // Update the current sum (append the node's value to the path)
        currentSum = currentSum * 10 + node.val;
        
        // If the node is a leaf, return the current sum
        if (node.left == null && node.right == null) {
            return currentSum;
        }
        
        // Recursive case: traverse left and right subtrees
        int leftSum = dfs(node.left, currentSum);
        int rightSum = dfs(node.right, currentSum);
        
        // Return the total sum from both subtrees
        return leftSum + rightSum;
    }
}
```

---

### Explanation of the Solution

1. **DFS Traversal**:
   - Start from the root with an initial `currentSum` of `0`.
   - As you traverse, update `currentSum` by multiplying it by `10` and adding the node's value.

2. **Leaf Node Check**:
   - If the current node is a **leaf** (no children), return the `currentSum`.

3. **Recursive Calls**:
   - Recurse on the left and right children, passing the updated `currentSum`.

4. **Combine Results**:
   - Add up the results from the left and right subtrees to get the total sum.

---

### Time Complexity ⏳

- **O(n)**: Each node is visited once.

### Space Complexity 💾

- **O(h)**: Where `h` is the height of the tree (due to recursion stack).

---

### Follow-up Challenges 🧐

1. How would you implement an iterative solution for this problem using a stack or queue?
2. Could you optimize the memory usage further in the recursive solution?

You can find the full solution [here](Solution.java) and what is DFS?  [here](What_is_DFS.md). 