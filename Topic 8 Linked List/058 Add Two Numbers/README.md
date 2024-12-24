## 2. Add Two Numbers 🔢

**Difficulty**: `Medium` - **Tags**: `Linked List`, `Math`

[LeetCode Problem Link](https://leetcode.com/problems/add-two-numbers/)

---

### Problem Statement 📜

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

---

### Examples 🔍

🔹 **Example 1**:

![](addtwonumber1.jpg)

**Input:**

```plaintext
l1 = [2,4,3], l2 = [5,6,4]
```

**Output:**

```plaintext
[7,0,8]
```

**Explanation**: 342 + 465 = 807.

---

🔹 **Example 2**:

**Input:**

```plaintext
l1 = [0], l2 = [0]
```

**Output:**

```plaintext
[0]
```

---

🔹 **Example 3**:

**Input:**

```plaintext
l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
```

**Output:**

```plaintext
[8,9,9,9,0,0,0,1]
```

---

### Constraints ⚙️

- The number of nodes in each linked list is in the range `[1, 100]`.
- `0 <= Node.val <= 9`
- It is guaranteed that the list represents a number that does not have leading zeros.

---

### Solution 💡

To solve this problem, we can simulate the addition of the two numbers digit by digit, starting from the least significant digit (the head of each linked list):

1. Traverse both linked lists simultaneously, adding corresponding digits along with any carry.
2. If the sum of two digits is 10 or more, store the unit digit of the sum in the result and carry the tens digit to the next iteration.
3. Once all nodes are processed, if there is any carry left, append it to the result.

---

#### Java Solution

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, current = dummyHead;
        int carry = 0;

        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next;
    }
}
```

---

### Explanation of the Solution

1. **Simulate Addition**:

   - We add corresponding digits from both linked lists and handle the carry from the previous step.

2. **Handling Carry**:

   - If the sum of two digits is greater than or equal to 10, we store the unit digit in the result and carry the tens digit over.

3. **Edge Cases**:
   - If one linked list is longer than the other, we treat the missing digits as zero.
   - If there is a remaining carry after the last node, we append it to the result.

---

### Time Complexity ⏳

- **O(n)**: We traverse both linked lists once, where `n` is the length of the longer list.

### Space Complexity 💾

- **O(n)**: The space complexity is O(n) because we are constructing a new linked list of size `n`.

You can find the full solution [here](Solution.java).
