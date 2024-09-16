Here's the README for the "Rotate Array" problem:

---

## 189. Rotate Array 🔄

**Difficulty**: `Medium` - **Tags**: `Array`, `Two Pointers`, `Mathematics`

### Description 📋

Given an integer array `nums`, rotate the array to the right by `k` steps, where `k` is non-negative.

### Examples 🌟

**Example 1:**

**Input:**
```python
nums = [1,2,3,4,5,6,7]
k = 3
```

**Output:**
```python
[5,6,7,1,2,3,4]
```

**Explanation:**
- Rotate 1 step to the right: `[7,1,2,3,4,5,6]`
- Rotate 2 steps to the right: `[6,7,1,2,3,4,5]`
- Rotate 3 steps to the right: `[5,6,7,1,2,3,4]`

**Example 2:**

**Input:**
```python
nums = [-1,-100,3,99]
k = 2
```

**Output:**
```python
[3,99,-1,-100]
```

**Explanation:**
- Rotate 1 step to the right: `[99,-1,-100,3]`
- Rotate 2 steps to the right: `[3,99,-1,-100]`

### Constraints ⚙️

- `1 <= nums.length <= 10^5`
- `-2^31 <= nums[i] <= 2^31 - 1`
- `0 <= k <= 10^5`

### Solution 💡

The time complexity is $O(n)$, and the space complexity is $O(1)$ (in-place rotation). The approach uses three array reversals:
1. Reverse the entire array.
2. Reverse the first `k` elements.
3. Reverse the remaining `n - k` elements.

#### Java

```java
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length; // In case k > nums.length
        reverse(nums, 0, nums.length - 1);   // Step 1: Reverse the entire array
        reverse(nums, 0, k - 1);             // Step 2: Reverse the first k elements
        reverse(nums, k, nums.length - 1);   // Step 3: Reverse the rest of the array
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
```

You can find the full `Solution1.java` file [here](Solution1.java) and `Solution2.java` file [here](Solution2.java).
Bad solution need to avoid [here](SolutionBad.java) 

