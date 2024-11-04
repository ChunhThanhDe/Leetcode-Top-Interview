## 167. Two Sum II - Input Array Is Sorted 🔍

**Difficulty**: `Medium` - **Tags**: `Array`, `Two Pointers`, `Binary Search`

[LeetCode Problem Link](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)

### Problem Statement 📜

Given a 1-indexed array of integers `numbers` that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be `numbers[index1]` and `numbers[index2]` where `1 <= index1 < index2 <= numbers.length`.

Return the indices of the two numbers, `index1` and `index2`, added by one as an integer array `[index1, index2]` of length 2.

Your solution must use only constant extra space.

### Examples 🌟

🔹 **Example 1:**

**Input:**
```python
numbers = [2,7,11,15]
target = 9
```

**Output:**
```
[1,2]
```

🔹 **Example 2:**

**Input:**
```python
numbers = [2,3,4]
target = 6
```

**Output:**
```
[1,3]
```

🔹 **Example 3:**

**Input:**
```python
numbers = [-1,0]
target = -1
```

**Output:**
```
[1,2]
```

### Constraints ⚙️

- `2 <= numbers.length <= 3 * 10^4`
- `-1000 <= numbers[i] <= 1000`
- `numbers` is sorted in non-decreasing order.
- `-1000 <= target <= 1000`
- The tests are generated such that there is exactly one solution.

### Solution 💡

Given that `numbers` is sorted, we can use the **Two-Pointer Technique**:

1. **Initialize Two Pointers**: Place one pointer at the start (`left = 0`) and the other at the end (`right = numbers.length - 1`) of the array.
2. **Sum and Compare**: Calculate the sum of the elements at `left` and `right`.
   - If the sum equals `target`, return `[left + 1, right + 1]`.
   - If the sum is less than `target`, increment `left` to increase the sum.
   - If the sum is greater than `target`, decrement `right` to decrease the sum.
3. **Repeat** until the target is found.

#### Java Solution

```java
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[0]; // This should never be reached due to problem constraints.
    }
}
```

#### Time Complexity ⏳

- **O(n)**, where `n` is the length of `numbers`. We scan the array once with two pointers.

#### Space Complexity 💾

- **O(1)**, since we only use two pointers and no additional data structures.

You can find the full solution [here](Solution.java).