## 15. 3Sum 🌐

**Difficulty**: `Medium` - **Tags**: `Array`, `Two Pointers`, `Sorting`

[LeetCode Problem Link](https://leetcode.com/problems/3sum/)

### Problem Statement 📜

Given an integer array `nums`, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.

Notice that the solution set must not contain duplicate triplets.

### Examples 🌟

🔹 **Example 1:**

**Input:**
```python
nums = [-1,0,1,2,-1,-4]
```

**Output:**
```
[[-1,-1,2],[-1,0,1]]
```

**Explanation:**

`nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0`.

`nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0`.

`nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0`.

The distinct triplets that sum up to 0 are `[-1,0,1]` and `[-1,-1,2]`. The order of the output and the order of the triplets does not matter.


🔹 **Example 2:**

**Input:**
```python
nums = [0,1,1]
```

**Output:**
```
[]
```

**Explanation:**
The only possible triplet does not sum up to 0.

🔹 **Example 3:**

**Input:**
```python
nums = [0,0,0]
```

**Output:**
```
[[0,0,0]]
```

**Explanation:**
The only possible triplet sums up to 0.

### Constraints ⚙️

- `3 <= nums.length <= 3000`
- `-10^5 <= nums[i] <= 10^5`

### Solution 💡

To solve this problem, we can use the **Two-Pointer Technique** after sorting the array:

1. **Sort the Array**: This helps in easily skipping duplicates and using the two-pointer approach.
2. **Iterate Through the Array**: Use a loop to fix one element at a time and then use two pointers to find pairs that sum to the negative of the fixed element.
3. **Two Pointers**:
   - Set `left` pointer to the next element after the fixed element, and `right` pointer to the end of the array.
   - Calculate the sum of the three elements. If the sum is less than zero, increment the left pointer to increase the sum. If the sum is greater than zero, decrement the right pointer to decrease the sum.
   - If the sum is zero, record the triplet and skip duplicates for both the left and right pointers.
4. **Skip Duplicates**: After finding a triplet, increment `left` and decrement `right` while skipping over any duplicate values.

#### Java Solution

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the first number
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Skip duplicates for the second number
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicates for the third number
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
            }
        }

        return result;
    }
}
```

### Time Complexity ⏳

- **O(n^2)**, where `n` is the length of the array. Sorting the array takes `O(n log n)` and the two-pointer traversal takes `O(n^2)` in the worst case.

### Space Complexity 💾

- **O(1)**, as we are using a constant amount of extra space for pointers and indices. The space required for storing the output is not considered in the space complexity analysis.


You can find the full solution [here](Solution.java).