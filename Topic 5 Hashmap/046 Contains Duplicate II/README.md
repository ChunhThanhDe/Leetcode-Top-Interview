## 219. Contains Duplicate II 🔍

**Difficulty**: `Easy` - **Tags**: `Array`, `Hash Table`, `Sliding Window`

[LeetCode Problem Link](https://leetcode.com/problems/contains-duplicate-ii/)

---

### Problem Statement 📜

Given an integer array `nums` and an integer `k`, return `true` if there are two distinct indices `i` and `j` in the array such that:

- `nums[i] == nums[j]`
- `abs(i - j) <= k`

Return `false` otherwise.

---

### Examples 🌟

🔹 **Example 1:**

**Input:**
```plaintext
nums = [1,2,3,1], k = 3
```

**Output:**
```plaintext
true
```

🔹 **Example 2:**

**Input:**
```plaintext
nums = [1,0,1,1], k = 1
```

**Output:**
```plaintext
true
```

🔹 **Example 3:**

**Input:**
```plaintext
nums = [1,2,3,1,2,3], k = 2
```

**Output:**
```plaintext
false
```

---

### Constraints ⚙️

- `1 <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`
- `0 <= k <= 10^5`

---

### Solution 💡

To solve this problem efficiently, a `HashMap` can be used to store the last index of each number as we iterate through the array. This allows us to quickly check if the difference between the current index and the stored index is less than or equal to `k`.

---

#### Java Solution (Using HashMap)

```java
import java.util.HashMap;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }

        return false;
    }
}
```

---

### Explanation of the Solution

1. **HashMap for Index Tracking**:
   - Use a `HashMap` to store the last index where each number appears.
   - Check if the current number exists in the map, and if the index difference is less than or equal to `k`.

2. **Update the Map**:
   - Regardless of the result, update the map with the current index of the number.

3. **Early Exit**:
   - If a valid pair is found, return `true`.
   - Otherwise, continue iterating.

---

### Time Complexity ⏳

- **O(n)**:
  Each element is processed once.

### Space Complexity 💾

- **O(min(n, k))**:
  The size of the `HashMap` is limited by `k` and the number of unique elements in `nums`.

You can find the full solution [here](Solution.java).
