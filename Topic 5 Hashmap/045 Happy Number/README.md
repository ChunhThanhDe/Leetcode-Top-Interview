## 202. Happy Number 🤩

**Difficulty**: `Easy` - **Tags**: `Math`, `Hash Table`, `Two Pointers`

[LeetCode Problem Link](https://leetcode.com/problems/happy-number/)

---

### Problem Statement 📜

Write an algorithm to determine if a number `n` is a **happy number**.

A happy number is a number defined by the following process:

1. Start with any positive integer.
2. Replace the number with the sum of the squares of its digits.
3. Repeat the process until the number equals `1` (where it will stay), or it loops endlessly in a cycle that does not include `1`.
4. If the process ends in `1`, the number is considered **happy**.

Return `true` if `n` is a happy number, otherwise return `false`.

---

### Examples 🌟

🔹 **Example 1:**

**Input:**
```plaintext
n = 19
```

**Output:**
```plaintext
true
```

**Explanation:**
```
1² + 9² = 82
8² + 2² = 68
6² + 8² = 100
1² + 0² + 0² = 1
```

🔹 **Example 2:**

**Input:**
```plaintext
n = 2
```

**Output:**
```plaintext
false
```

---

### Constraints ⚙️

- `1 <= n <= 2^31 - 1`

---

### Solution 💡

We can use a `HashSet` to detect cycles. Alternatively, the two-pointer technique (Floyd’s Cycle Detection) can help identify loops.

---

#### Java Solution (Using HashSet)

```java
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }

        return n == 1;
    }

    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int digit = n % 10;
            totalSum += digit * digit;
            n /= 10;
        }
        return totalSum;
    }
}
```

---

### Explanation of the Solution

1. **HashSet for Cycle Detection**:
   - Use a `HashSet` to store numbers already seen during the process.
   - If a number repeats, a cycle is detected, and the process won't reach `1`.

2. **Helper Method (`getNext`)**:
   - Calculate the sum of the squares of the digits of the current number.

3. **Termination**:
   - Return `true` if `n` becomes `1`.
   - Return `false` if a cycle is detected.

---

### Time Complexity ⏳

- **O(log(n))** per step to calculate the sum of the squares of digits.
- In total, the number of steps depends on the cycle length or reaching `1`.

### Space Complexity 💾

- **O(log(n))**:
  - For the storage of seen numbers in the `HashSet`.

You can find the full solution [here](Solution.java).