## 117. Populating Next Right Pointers in Each Node II 🔗

**Difficulty**: `Medium` - **Tags**: `Binary Tree`, `Breadth-First Search (BFS)`, `Linked List`

[LeetCode Problem Link](https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/)

---

### Problem Statement 📜

Given a binary tree:

```java
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
```

Populate each `next` pointer to point to its next right node. If there is no next right node, the `next` pointer should be set to `NULL`.

Initially, all `next` pointers are set to `NULL`.

---

### Examples 🌟

🔹 **Example 1**:

![](117_sample.png)

**Input**:

```plaintext
root = [1,2,3,4,5,null,7]
```

**Output**:

```plaintext
[1,#,2,3,#,4,5,7,#]
```

**Explanation**:

Given the tree:

```plaintext
    1
   / \
  2   3
 / \    \
4   5    7
```

The `next` pointers should connect nodes as:

```plaintext
1 -> NULL
2 -> 3 -> NULL
4 -> 5 -> 7 -> NULL
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

### Constraints ⚙️

- The number of nodes in the tree is in the range `[0, 6000]`.
- `-100 <= Node.val <= 100`.

---

### Follow-up 🧐

- You may only use **constant extra space**.
- The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.

---

### Solution 💡

To solve this problem:
1. Use a **level-order traversal** to connect nodes at the same level.
2. For the constant space requirement, use a **dummy node** to traverse each level without additional data structures.

---

#### Java Solution

```java
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        // Initialize the current level
        Node current = root;
        Node dummyHead = new Node(0); // Dummy head for the next level
        Node previous = dummyHead;

        while (current != null) {
            while (current != null) {
                if (current.left != null) {
                    previous.next = current.left;
                    previous = previous.next;
                }
                if (current.right != null) {
                    previous.next = current.right;
                    previous = previous.next;
                }
                current = current.next; // Move to the next node in the current level
            }

            // Move to the next level
            current = dummyHead.next;
            dummyHead.next = null; // Reset the dummy head
            previous = dummyHead;
        }

        return root;
    }
}
```

---

### Explanation of the Solution

1. **Dummy Node Approach**:
   - Use a dummy node to build the `next` pointers for the next level.
   - Traverse each level, connecting child nodes to the dummy node.

2. **Level Traversal**:
   - Move through the current level using `next` pointers.
   - Update the `next` pointers of child nodes to establish connections.

3. **Space Efficiency**:
   - The solution uses constant space by avoiding auxiliary data structures like queues.

---

### Time Complexity ⏳

- **O(n)**: Each node is visited exactly once.

### Space Complexity 💾

- **O(1)**: No additional space is used beyond the dummy node and pointers.

---

### Follow-up Challenges 🧐

- Could you adapt this solution for a more generalized graph structure?
- How would the solution change if the binary tree could contain cycles?

You can find the full solution [here](Solution.java).