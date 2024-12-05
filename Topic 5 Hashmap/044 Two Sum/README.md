## Two Sum 🔍

**Difficulty**: `Easy` - **Tags**: `Array`, `Hash Table`

[LeetCode Problem Link](https://leetcode.com/problems/two-sum/)

---

### Problem Statement 📜

Given an array of integers `nums` and an integer `target`, return the indices of the two numbers such that they add up to `target`.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

---

### Examples 🌟

🔹 **Example 1:**

**Input:**
```plaintext
nums = [2,7,11,15], target = 9
```

**Output:**
```plaintext
[0,1]
```

**Explanation:**
`nums[0] + nums[1] == 9`, so we return `[0, 1]`.

🔹 **Example 2:**

**Input:**
```plaintext
nums = [3,2,4], target = 6
```

**Output:**
```plaintext
[1,2]
```

🔹 **Example 3:**

**Input:**
```plaintext
nums = [3,3], target = 6
```

**Output:**
```plaintext
[0,1]
```

---

### Constraints ⚙️

- `2 <= nums.length <= 10^4`
- `-10^9 <= nums[i] <= 10^9`
- `-10^9 <= target <= 10^9`
- Only one valid answer exists.

---

### Solution 💡

We can use a `HashMap` to store the difference between the `target` and each element as we iterate through the array.

---

#### Java Solution

```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
```

---

### Explanation of the Solution

1. **Initialization**:
   - Create a `HashMap` to store the value and its index as key-value pairs.

2. **Traversal**:
   - For each element in `nums`, calculate the complement (`target - nums[i]`).
   - Check if the complement exists in the `HashMap`.
   - If it does, return the current index and the stored index for the complement.
   - Otherwise, add the current element and its index to the `HashMap`.

3. **Result**:
   - Return the indices of the two numbers when the complement is found.

---

### Time Complexity ⏳

- **O(n)**:
  - Each lookup and insertion in the `HashMap` takes constant time.

### Space Complexity 💾

- **O(n)**:
  - Space used by the `HashMap` to store up to `n` elements.

You can find the full solution [here](Solution.java).