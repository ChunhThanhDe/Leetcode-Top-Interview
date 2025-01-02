## 86. Partition List 🔗

**Difficulty**: `Medium` - **Tags**: `Linked List`

[LeetCode Problem Link](https://leetcode.com/problems/partition-list/)

---

### Problem Statement 📜

Given the head of a linked list and a value `x`, partition it such that:
1. All nodes with values less than `x` come before nodes with values greater than or equal to `x`.
2. The relative order of the nodes in each partition should be preserved.

---

### Examples 🌟

🔹 **Example 1**:

![](partition.jpg)

**Input**:

```plaintext
head = [1,4,3,2,5,2], x = 3
```

**Output**:

```plaintext
[1,2,2,4,3,5]
```

---

🔹 **Example 2**:

**Input**:

```plaintext
head = [2,1], x = 2
```

**Output**:

```plaintext
[1,2]
```

---

### Constraints ⚙️

- The number of nodes in the list is in the range `[0, 200]`.
- `-100 <= Node.val <= 100`.
- `-200 <= x <= 200`.

---

### Solution 💡

To partition the list:
1. Use two pointers (`less` and `greater`) to track nodes:
   - `less` collects nodes with values less than `x`.
   - `greater` collects nodes with values greater than or equal to `x`.
2. Reconnect the two partitions at the end.

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
    public ListNode partition(ListNode head, int x) {
        // Dummy nodes for the two partitions
        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);

        // Pointers for building partitions
        ListNode less = lessHead;
        ListNode greater = greaterHead;

        // Traverse the list
        while (head != null) {
            if (head.val < x) {
                less.next = head; // Add to the less partition
                less = less.next;
            } else {
                greater.next = head; // Add to the greater partition
                greater = greater.next;
            }
            head = head.next;
        }

        // End the greater partition to avoid cycles
        greater.next = null;

        // Connect the two partitions
        less.next = greaterHead.next;

        return lessHead.next;
    }
}
```

---

### Explanation of the Solution

1. **Dummy Nodes**:
   - Use dummy nodes to simplify handling the head of each partition.

2. **Partitioning**:
   - Traverse the original list, adding nodes with values `< x` to the `less` partition and others to the `greater` partition.

3. **Reconnecting**:
   - End the `greater` partition to prevent cycles.
   - Connect the `less` partition to the start of the `greater` partition.

---

### Time Complexity ⏳

- **O(n)**: Each node is visited once.

### Space Complexity 💾

- **O(1)**: Uses constant extra space.

---

### Follow-up 🧐

This solution maintains the relative order of nodes in both partitions while achieving optimal time and space complexity. It is robust against edge cases like empty lists or when all nodes belong to one partition.

You can find the full solution [here](Solution.java).