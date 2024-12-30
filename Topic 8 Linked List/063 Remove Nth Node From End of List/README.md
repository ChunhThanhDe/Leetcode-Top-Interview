## 19. Remove Nth Node From End of List 🗑️

**Difficulty**: `Medium` - **Tags**: `Linked List`, `Two Pointers`

[LeetCode Problem Link](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)

---

### Problem Statement 📜

Given the head of a linked list, remove the `n`th node from the end of the list and return its head.

---

### Examples 🌟

🔹 **Example 1**:

![](remove_ex1.jpg)

**Input**:

```plaintext
head = [1,2,3,4,5], n = 2
```

**Output**:

```plaintext
[1,2,3,5]
```

---

🔹 **Example 2**:

**Input**:

```plaintext
head = [1], n = 1
```

**Output**:

```plaintext
[]
```

---

🔹 **Example 3**:

**Input**:

```plaintext
head = [1,2], n = 1
```

**Output**:

```plaintext
[1]
```

---

### Constraints ⚙️

- The number of nodes in the list is `sz`.
- `1 <= sz <= 30`
- `0 <= Node.val <= 100`
- `1 <= n <= sz`

---

### Solution 💡

We can solve this problem in one pass by using the **two-pointer technique**. The first pointer moves `n` steps ahead, and then both pointers move together until the first pointer reaches the end. This ensures the second pointer is just before the node to be removed.

---

#### Java Solution

```java
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        // Move first pointer n+1 steps ahead to maintain a gap of n nodes
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Move both pointers until first reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Remove the nth node from the end
        second.next = second.next.next;

        return dummy.next;
    }
}
```

---

### Explanation of the Solution

1. **Dummy Node**:
   - A dummy node is used to handle edge cases where the head needs to be removed.

2. **Two-Pointer Technique**:
   - The first pointer moves `n+1` steps ahead, so when it reaches the end, the second pointer is just before the node to be removed.

3. **Node Removal**:
   - Adjust the `next` pointer of the second pointer to skip the node to be removed.

---

### Time Complexity ⏳

- **O(sz)**: The list is traversed once to find and remove the node.

### Space Complexity 💾

- **O(1)**: The solution uses constant space.

---

### Follow-up 🧐

**Could you do this in one pass?**

The above solution achieves the removal in a single pass using the two-pointer approach, maintaining optimal time complexity.

You can find the full solution [here](Solution.java).