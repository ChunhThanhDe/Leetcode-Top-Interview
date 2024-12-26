## 92. Reverse Linked List II 🔄

**Difficulty**: `Medium` - **Tags**: `Linked List`

[LeetCode Problem Link](https://leetcode.com/problems/reverse-linked-list-ii/)

---

### Problem Statement 📜

Given the head of a singly linked list and two integers `left` and `right` where `1 <= left <= right <= n`, reverse the nodes of the list from position `left` to position `right`, and return the reversed list.

---

### Examples 🌟

🔹 **Example 1**:

![](rev2ex2.jpg)

**Input:**

```plaintext
head = [1,2,3,4,5], left = 2, right = 4
```

**Output:**

```plaintext
[1,4,3,2,5]
```

---

🔹 **Example 2**:

**Input:**

```plaintext
head = [5], left = 1, right = 1
```

**Output:**

```plaintext
[5]
```

---

### Constraints ⚙️

- The number of nodes in the list is `n`.
- `1 <= n <= 500`
- `-500 <= Node.val <= 500`
- `1 <= left <= right <= n`

---

### Solution 💡

The problem can be solved by first locating the range `[left, right]` in the linked list, reversing the sublist within that range, and reconnecting it to the rest of the list.

[explain step by step for example 1](Explain.md)

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Move `prev` to the node before the reversal starts
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // `start` points to the first node to be reversed
        ListNode start = prev.next;
        // `then` is the node after `start` to be reversed
        ListNode then = start.next;

        // Reverse the sublist
        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }

        return dummy.next;
    }
}
```

---

### Explanation of the Solution

1. **Initialize a Dummy Node**:

   - Use a dummy node to handle cases where `left = 1`, simplifying edge cases.

2. **Traverse to the Start of the Sublist**:

   - Move a pointer (`prev`) to the node just before the `left` position.

3. **Reverse the Sublist**:

   - Reverse the nodes between `left` and `right` using a temporary pointer (`then`).

4. **Reconnect the Reversed Sublist**:

   - Ensure the reversed sublist is properly connected to the nodes before and after the range.

5. **Return the New Head**:
   - Return `dummy.next` as the new head of the list.

---

### Time Complexity ⏳

- **O(n)**: The linked list is traversed once to locate the range and reverse it.

### Space Complexity 💾

- **O(1)**: The reversal is done in-place without using additional space.

You can find the full solution [here](Solution.java).
