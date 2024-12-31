## 82. Remove Duplicates from Sorted List II ❌🔢

**Difficulty**: `Medium` - **Tags**: `Linked List`

[LeetCode Problem Link](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/)

---

### Problem Statement 📜

Given the head of a **sorted linked list**, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

---

### Examples 🌟

🔹 **Example 1**:

![](linkedlist1.jpg)

**Input**:

```plaintext
head = [1,2,3,3,4,4,5]
```

**Output**:

```plaintext
[1,2,5]
```

---

🔹 **Example 2**:

![](linkedlist2.jpg)

**Input**:

```plaintext
head = [1,1,1,2,3]
```

**Output**:

```plaintext
[2,3]
```

---

### Constraints ⚙️

- The number of nodes in the list is in the range `[0, 300]`.
- `-100 <= Node.val <= 100`.
- The list is guaranteed to be sorted in ascending order.

---

### Solution 💡

To solve this problem, we need to identify and remove all nodes with duplicate values. Using a **dummy node** simplifies edge cases, especially when duplicates appear at the start of the list.

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
    public ListNode deleteDuplicates(ListNode head) {
        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy; // Points to the last node in the result list

        while (head != null) {
            // If current node has duplicates
            if (head.next != null && head.val == head.next.val) {
                // Skip all nodes with the same value
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // Remove duplicates
                prev.next = head.next;
            } else {
                // Move prev forward if no duplicates
                prev = prev.next;
            }
            // Move head forward
            head = head.next;
        }

        return dummy.next;
    }
}
```

---

### Explanation of the Solution

1. **Dummy Node**:
   - A dummy node is added at the beginning of the list to handle edge cases where the first few nodes are duplicates.

2. **Traversing the List**:
   - If a node and its `next` node have the same value, skip all nodes with that value.

3. **Handling Duplicates**:
   - Once duplicates are skipped, the `prev` pointer connects to the first non-duplicate node.

4. **Returning the Result**:
   - The new list starts from `dummy.next`.

---

### Time Complexity ⏳

- **O(n)**: The entire list is traversed once.

### Space Complexity 💾

- **O(1)**: The solution uses constant extra space.

---

### Follow-up 🧐

This approach works efficiently without requiring additional data structures, maintaining the sorted property of the linked list.

You can find the full solution [here](Solution.java).