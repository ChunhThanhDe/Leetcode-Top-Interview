## 128. Longest Consecutive Sequence 🔍

**Difficulty**: `Medium` - **Tags**: `Array`, `Hash Table`, `Union Find`

[LeetCode Problem Link](https://leetcode.com/problems/longest-consecutive-sequence/)

---

### Problem Statement 📜

Given an unsorted array of integers `nums`, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in `O(n)` time.

---

### Examples 🌟

🔹 **Example 1:**

**Input:**
```plaintext
nums = [100, 4, 200, 1, 3, 2]
```

**Output:**
```plaintext
4
```

**Explanation:**
The longest consecutive elements sequence is `[1, 2, 3, 4]`. Therefore, its length is `4`.

🔹 **Example 2:**

**Input:**
```plaintext
nums = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
```

**Output:**
```plaintext
9
```

---

### Constraints ⚙️

- `0 <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`

---

### Solution 💡

To achieve an `O(n)` time complexity, a `HashSet` can be used to store all elements of the array. This allows us to quickly check the existence of consecutive elements.

---

#### Java Solution (Using HashSet)

```java
import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            // Only start a sequence if num is the beginning of the sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
```

---

### Explanation of the Solution

1. **Use HashSet for Fast Lookup**:
   - Insert all elements into a `HashSet` for `O(1)` average-time checks.

2. **Start from Sequence Beginning**:
   - Iterate through the `HashSet`.
   - Start counting the streak only if the current number is the start of a sequence (`num - 1` is not in the set).

3. **Count Consecutive Numbers**:
   - Increment the count while consecutive numbers exist.

4. **Track the Longest Streak**:
   - Update the longest streak as needed.

---

### Time Complexity ⏳

- **O(n)**:
  Each element is processed at most twice.

### Space Complexity 💾

- **O(n)**:
  Space required for the `HashSet`.

You can find the full solution [here](Solution.java).