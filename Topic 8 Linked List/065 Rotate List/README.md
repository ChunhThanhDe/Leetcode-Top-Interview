## 61. Rotate List 🔄

**Difficulty**: `Medium` - **Tags**: `Linked List`

[LeetCode Problem Link](https://leetcode.com/problems/rotate-list/)

---

### Problem Statement 📜

Given the head of a linked list, rotate the list to the right by `k` places.

---

### Examples 🌟

🔹 **Example 1**:

![](rotate1.jpg)

**Input**:

```plaintext
head = [1,2,3,4,5], k = 2
```

**Output**:

```plaintext
[4,5,1,2,3]
```

---

🔹 **Example 2**:

![](roate2.jpg)

**Input**:

```plaintext
head = [0,1,2], k = 4
```

**Output**:

```plaintext
[2,0,1]
```

---

### Constraints ⚙️

- The number of nodes in the list is in the range `[0, 500]`.
- `-100 <= Node.val <= 100`.
- `0 <= k <= 2 * 10⁹`.

---

### Solution 💡

To solve this problem, note the following:
1. If `k` is larger than the length of the list, rotating `k` times is equivalent to rotating `k % n` times (`n` being the length of the list).
2. The rotation can be achieved by:
   - Connecting the tail to the head to form a circular linked list.
   - Breaking the circle at the new head position.

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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Calculate the length of the list
        ListNode current = head;
        int length = 1; // Start with 1 because we'll traverse the list
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Step 2: Connect tail to head to form a circle
        current.next = head;

        // Step 3: Find the new tail position
        int newTailPosition = length - (k % length);

        // Step 4: Traverse to the new tail and break the circle
        ListNode newTail = head;
        for (int i = 1; i < newTailPosition; i++) {
            newTail = newTail.next;
        }

        // Step 5: Define the new head and break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
```

---

### Explanation of the Solution

1. **Edge Cases**:
   - If the list is empty or has only one node, or if `k == 0`, return the original list.

2. **Length Calculation**:
   - Traverse the list to find its length and connect the tail to the head to form a circular list.

3. **Determine the New Head**:
   - Use modulo to find the effective rotations needed, reducing unnecessary cycles.

4. **Break the Circle**:
   - Traverse the list to the new tail and disconnect it from the rest, defining the new head.

---

### Time Complexity ⏳

- **O(n)**: The list is traversed twice (once to calculate the length and once to find the new tail).

### Space Complexity 💾

- **O(1)**: The solution uses constant extra space.

---

### Follow-up 🧐

This solution is efficient and handles edge cases well. It avoids unnecessary rotations by optimizing `k` and uses in-place manipulation to save space.

You can find the full solution [here](Solution.java).