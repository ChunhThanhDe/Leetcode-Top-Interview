## 138. Copy List with Random Pointer 🔗

**Difficulty**: `Medium` - **Tags**: `Linked List`, `Hashing`

[LeetCode Problem Link](https://leetcode.com/problems/copy-list-with-random-pointer/)

---

### Problem Statement 📜

A linked list of length `n` is given such that each node contains an additional `random` pointer, which could point to any node in the list, or `null`.

Construct a **deep copy** of the list. The deep copy should consist of exactly `n` brand-new nodes, where each new node has its value set to the value of its corresponding original node. Both the `next` and `random` pointers of the new nodes should point to new nodes in the copied list, replicating the structure of the original list.

Return the head of the copied linked list.

---

### Examples 🌟

🔹 **Example 1**:

![](e1.png)

**Input:**

```plaintext
head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
```

**Output:**

```plaintext
[[7,null],[13,0],[11,4],[10,2],[1,0]]
```

---

🔹 **Example 2**:

![](e2.png)

**Input:**

```plaintext
head = [[1,1],[2,1]]
```

**Output:**

```plaintext
[[1,1],[2,1]]
```

---

🔹 **Example 3**:

![](e3.png)

**Input:**

```plaintext
head = [[3,null],[3,0],[3,null]]
```

**Output:**

```plaintext
[[3,null],[3,0],[3,null]]
```

---

### Constraints ⚙️

- The number of nodes in the list is in the range `[0, 1000]`.
- `-10^4 <= Node.val <= 10^4`
- `Node.random` is `null` or points to a node in the list.

---

### Solution 💡

We can solve this problem using **three passes** with a hash map to maintain the original node and its corresponding copied node.

---

#### Java Solution

```java
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Create a mapping of original nodes to their copies
        HashMap<Node, Node> map = new HashMap<>();
        Node current = head;

        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        // Step 2: Set the next and random pointers for the copied nodes
        current = head;
        while (current != null) {
            Node copy = map.get(current);
            copy.next = map.get(current.next); // Link to the copied next node
            copy.random = map.get(current.random); // Link to the copied random node
            current = current.next;
        }

        // Step 3: Return the copied head
        return map.get(head);
    }
}
```

---

### Explanation of the Solution

1. **Mapping Original Nodes to Copies**:

   - Use a hash map to store each original node and its corresponding copied node.

2. **Linking the `next` and `random` Pointers**:

   - Traverse the original list again and set the `next` and `random` pointers of the copied nodes using the hash map.

3. **Returning the Copied Head**:
   - Return the copied node corresponding to the original head from the hash map.

---

### Time Complexity ⏳

- **O(n)**: We traverse the list twice — once to create the nodes and once to set the pointers.

### Space Complexity 💾

- **O(n)**: The hash map stores mappings for `n` nodes.

You can find the full solution [here](Solution.java).
