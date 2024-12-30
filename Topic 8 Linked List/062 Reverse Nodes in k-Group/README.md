## 25. Reverse Nodes in k-Group 🔄

**Difficulty**: `Hard` - **Tags**: `Linked List`, `Two Pointers`

[LeetCode Problem Link](https://leetcode.com/problems/reverse-nodes-in-k-group/)

---

### Problem Statement 📜

Given the head of a linked list, reverse the nodes of the list `k` at a time, and return the modified list.

`k` is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of `k`, then left-out nodes, in the end, should remain as they are.

You may not alter the values in the list's nodes, only the nodes themselves may be changed.

---

### Examples 🌟

🔹 **Example 1**:

![](reverse_ex1.jpg)

**Input:**

```plaintext
head = [1,2,3,4,5], k = 2
```

**Output:**

```plaintext
[2,1,4,3,5]
```

---

🔹 **Example 2**:

![](reverse_ex2.jpg)

**Input:**

```plaintext
head = [1,2,3,4,5], k = 3
```

**Output:**

```plaintext
[3,2,1,4,5]
```

---

### Constraints ⚙️

- The number of nodes in the list is `n`.
- `1 <= k <= n <= 5000`
- `0 <= Node.val <= 1000`

---

### Solution 💡

The problem can be solved by using a two-pointer technique, iterating over the list in `k`-sized groups, and reversing the nodes in each group.

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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // Create a dummy node and point it to the head of the list
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy, prev = dummy, next = dummy;

        // Count the total number of nodes in the list
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }

        // Reverse every k nodes in the list
        while (count >= k) {
            curr = prev.next;
            next = curr.next;
            // Reverse k nodes
            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
            count -= k;
        }

        return dummy.next;
    }
}
```

---

### Explanation of the Solution

1. **Dummy Node**:

   - We use a dummy node to simplify the reversal process. This helps in handling cases where the head of the list changes after the first reversal.

2. **Count the Total Nodes**:

   - First, we traverse the entire list to count the total number of nodes. This allows us to determine if there are enough nodes left to reverse in groups of `k`.

3. **Reverse in Groups of k**:

   - We then process the list in groups of `k` nodes. For each group, we reverse the nodes by adjusting their `next` pointers.
   - After reversing a group, we move the `prev` pointer to the last node in the reversed group.

4. **Edge Cases**:
   - If the number of remaining nodes is less than `k`, they are left as-is without reversal.

---

### Time Complexity ⏳

- **O(n)**: The list is traversed once to count the nodes and again to reverse the groups of `k` nodes.

### Space Complexity 💾

- **O(1)**: The reversal is done in-place without using additional memory for new nodes.

---

### Follow-up 🧐

Can you solve the problem in **O(1)** extra memory space? The above solution does not use extra space besides the `dummy` node, which is constant space. The space complexity is optimal for this problem.

You can find the full solution [here](Solution.java).
