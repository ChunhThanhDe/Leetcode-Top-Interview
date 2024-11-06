## 209. Minimum Size Subarray Sum 🌐

**Difficulty**: `Medium` - **Tags**: `Array`, `Two Pointers`, `Sliding Window`

[LeetCode Problem Link](https://leetcode.com/problems/minimum-size-subarray-sum/)

### Problem Statement 📜

Given an array of positive integers `nums` and a positive integer `target`, return the minimal length of a subarray whose sum is greater than or equal to `target`. If there is no such subarray, return `0` instead.

### Examples 🌟

🔹 **Example 1:**

**Input:**
```python
target = 7
nums = [2,3,1,2,4,3]
```

**Output:**
```
2
```

**Explanation:**
The subarray `[4,3]` has the minimal length under the problem constraint.

🔹 **Example 2:**

**Input:**
```python
target = 4
nums = [1,4,4]
```

**Output:**
```
1
```

🔹 **Example 3:**

**Input:**
```python
target = 11
nums = [1,1,1,1,1,1,1,1]
```

**Output:**
```
0
```

**Explanation:**
No subarray sums up to or exceeds 11.

### Constraints ⚙️

- `1 <= target <= 10^9`
- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^4`

### Solution 💡

To solve this problem, we can use the **Sliding Window** approach:

1. **Initialize Pointers**: Use two pointers `left` and `right` to represent the current window, and initialize `sum` to keep track of the current sum of the window.
2. **Expand and Shrink the Window**:
   - Expand the `right` pointer to include elements in the window.
   - When the `sum` of the window is greater than or equal to `target`, try to shrink the window from the left by moving the `left` pointer to minimize the subarray length.
3. **Update the Result**:
   - Keep track of the minimal length of such subarrays.
   - Return the minimal length found, or `0` if no valid subarray is found.

#### Java Solution

```java
public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left++];
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
```

### Time Complexity ⏳

- **O(n)**: Each element is added to the sum and removed from the sum at most once.

### Space Complexity 💾

- **O(1)**: No additional space is used except for the variables to store the current sum, pointers, and the result.

You can find the full solution [here](Solution.java).