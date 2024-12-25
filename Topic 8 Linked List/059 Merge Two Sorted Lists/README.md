## 21. Merge Two Sorted Lists 🔗

**Difficulty**: `Easy` - **Tags**: `Linked List`, `Sorting`

[LeetCode Problem Link](https://leetcode.com/problems/merge-two-sorted-lists/)

---

### Problem Statement 📜

You are given the heads of two sorted linked lists `list1` and `list2`.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

---

### Examples 🌟

🔹 **Example 1**:

![](merge_ex1.jpg)

**Input:**

```plaintext
list1 = [1,2,4], list2 = [1,3,4]
```

**Output:**

```plaintext
[1,1,2,3,4,4]
```

---

🔹 **Example 2**:

**Input:**

```plaintext
list1 = [], list2 = []
```

**Output:**

```plaintext
[]
```

---

🔹 **Example 3**:

**Input:**

```plaintext
list1 = [], list2 = [0]
```

**Output:**

```plaintext
[0]
```

---

### Constraints ⚙️

- The number of nodes in both lists is in the range `[0, 50]`.
- `-100 <= Node.val <= 100`
- Both `list1` and `list2` are sorted in non-decreasing order.

---

### Solution 💡

To merge the two sorted lists, we can use the following approach:

1. Create a dummy node to simplify edge cases, and use a pointer to track the current position.
2. Compare the values of nodes from both lists and attach the smaller node to the merged list.
3. Move the pointer in the respective list after attaching its node.
4. When one of the lists is exhausted, attach the remaining nodes from the other list.
5. Return the merged list starting from the node after the dummy.

---

#### Java Solution

```java
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to serve as the head of the merged list
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Compare nodes from both lists and merge them
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Attach the remaining nodes from list1 or list2
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next;
    }
}
```

---

### Explanation of the Solution

1. **Dummy Node**:

   - A dummy node simplifies handling the head of the merged list by avoiding edge-case checks for the first node.

2. **Comparison**:

   - Compare the current nodes of `list1` and `list2`, and append the smaller node to the merged list.

3. **Exhaustion of Lists**:
   - If one of the lists is completely traversed, attach the remaining nodes of the other list.

---

### Time Complexity ⏳

- **O(n + m)**: We iterate through all nodes in both `list1` (of size `n`) and `list2` (of size `m`).

### Space Complexity 💾

- **O(1)**: The solution is done in place with no additional data structures.

You can find the full solution [here](Solution.java).
