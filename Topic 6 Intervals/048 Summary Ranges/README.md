## 228. Summary Ranges 📊

**Difficulty**: `Easy` - **Tags**: `Array`

[LeetCode Problem Link](https://leetcode.com/problems/summary-ranges/)

---

### Problem Statement 📜

You are given a sorted unique integer array `nums`.

A range `[a,b]` is the set of all integers from `a` to `b` (inclusive).

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of `nums` is covered by exactly one of the ranges, and there is no integer `x` such that `x` is in one of the ranges but not in `nums`.

Each range `[a,b]` in the list should be output as:
- `"a->b"` if `a != b`
- `"a"` if `a == b`

---

### Examples 🌟

🔹 **Example 1:**

**Input:**
```plaintext
nums = [0,1,2,4,5,7]
```

**Output:**
```plaintext
["0->2","4->5","7"]
```

**Explanation:**
- `[0,2]` --> `"0->2"`
- `[4,5]` --> `"4->5"`
- `[7,7]` --> `"7"`

---

🔹 **Example 2:**

**Input:**
```plaintext
nums = [0,2,3,4,6,8,9]
```

**Output:**
```plaintext
["0","2->4","6","8->9"]
```

**Explanation:**
- `[0,0]` --> `"0"`
- `[2,4]` --> `"2->4"`
- `[6,6]` --> `"6"`
- `[8,9]` --> `"8->9"`

---

### Constraints ⚙️

- `0 <= nums.length <= 20`
- `-2^31 <= nums[i] <= 2^31 - 1`
- All the values of `nums` are unique.
- `nums` is sorted in ascending order.

---

### Solution 💡

The goal is to identify consecutive ranges in the sorted array and format them as described.

---

#### Java Solution

```java
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }

        int start = nums[0];

        for (int i = 1; i <= nums.length; i++) {
            // Check for end of range or end of array
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    result.add(String.valueOf(start)); // Single number
                } else {
                    result.add(start + "->" + nums[i - 1]); // Range
                }
                if (i < nums.length) {
                    start = nums[i];
                }
            }
        }

        return result;
    }
}
```

---

### Explanation of the Solution

1. **Initialize Start Point**:
   - Use a `start` variable to track the beginning of the current range.

2. **Iterate Over the Array**:
   - Compare the current number with the previous one to detect the end of a range.
   - When a range ends or the array ends:
     - If the `start` is equal to the last number, it's a single element range.
     - Otherwise, format it as `"start->end"`.

3. **Update for the Next Range**:
   - Reset `start` to the next number in the array.

---

### Time Complexity ⏳

- **O(n)**: Each element is processed once.

### Space Complexity 💾

- **O(1)**: No additional space is used other than the result list.

You can find the full solution [here](Solution.java).
