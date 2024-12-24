## 141. Linked List Cycle 🔁

**Difficulty**: `Easy` - **Tags**: `Linked List`, `Two Pointers`

[LeetCode Problem Link](https://leetcode.com/problems/linked-list-cycle/)

---

### Problem Statement 📜

Given the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be revisited by continuously following the `next` pointer. Internally, `pos` is used to denote the index of the node that the tail's `next` pointer connects to, but `pos` is not passed as a parameter.

Return `true` if there is a cycle in the linked list. Otherwise, return `false`.

---

### Examples 🌟

🔹 **Example 1**:

![](circularlinkedlist.png)

**Input:**

```plaintext
head = [3,2,0,-4], pos = 1
```

**Output:**

```plaintext
true
```

**Explanation**: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

---

🔹 **Example 2**:

![](circularlinkedlist_test2.png)

**Input:**

```plaintext
head = [1,2], pos = 0
```

**Output:**

```plaintext
true
```

**Explanation**: There is a cycle in the linked list, where the tail connects to the 0th node.

---

🔹 **Example 3**:

![](circularlinkedlist_test3.png)

**Input:**

```plaintext
head = [1], pos = -1
```

**Output:**

```plaintext
false
```

**Explanation**: There is no cycle in the linked list.

---

### Constraints ⚙️

- The number of the nodes in the list is in the range `[0, 10^4]`.
- `-10^5 <= Node.val <= 10^5`.
- `pos` is `-1` or a valid index in the linked list.

---

### Follow-Up 🔎

Can you solve it using `O(1)` (i.e., constant) memory?

---

### Solution 💡

The problem can be solved using the **two-pointer technique (Floyd’s Cycle Detection Algorithm)**:

1. Use two pointers:
   - A `slow` pointer moves one step at a time.
   - A `fast` pointer moves two steps at a time.
2. If there is a cycle, the `slow` and `fast` pointers will meet at some point inside the cycle.
3. If the `fast` pointer reaches the end (`null`), then there is no cycle.

---

#### Java Solution

```java
class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow meets fast, there is a cycle
            if (slow == fast) {
                return true;
            }
        }

        return false; // No cycle detected
    }
}
```

---

### Explanation of the Solution

1. **Two Pointers**:

   - The `slow` pointer moves step by step.
   - The `fast` pointer skips one step to move faster.

2. **Cycle Detection**:

   - If a cycle exists, the `fast` pointer will eventually catch up to the `slow` pointer.

3. **Edge Cases**:
   - If the list is empty (`head == null`) or contains only one node (`head.next == null`), there can be no cycle.

---

### Time Complexity ⏳

- **O(n)**: Both pointers traverse the list. In the worst case, they traverse each node once.

### Space Complexity 💾

- **O(1)**: The solution uses constant memory, satisfying the follow-up constraint.

You can find the full solution [here](Solution.java).
