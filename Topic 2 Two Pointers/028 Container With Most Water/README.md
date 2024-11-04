## 11. Container With Most Water 🏞️

**Difficulty**: `Medium` - **Tags**: `Array`, `Two Pointers`, `Greedy`

[LeetCode Problem Link](https://leetcode.com/problems/container-with-most-water/)

### Problem Statement 📜

You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the two endpoints of the `i`th line are `(i, 0)` and `(i, height[i])`.

Find two lines that, together with the x-axis, form a container that holds the most water.

Return the maximum amount of water a container can store.

### Examples 🌟

🔹 **Example 1:**

![Example 1](question_11.jpg)

**Input:**
```python
height = [1,8,6,2,5,4,8,3,7]
```

**Output:**
```
49
```

Explanation:
The maximum area is formed between lines at index 1 and index 8, with height 8 and 7, respectively. This gives an area of `min(8,7) * (8 - 1) = 7 * 7 = 49`.

🔹 **Example 2:**

**Input:**
```python
height = [1,1]
```

**Output:**
```
1
```

Explanation:
The only container possible is formed by the two lines, giving an area of `min(1,1) * (1 - 0) = 1`.

### Constraints ⚙️

- `n == height.length`
- `2 <= n <= 10^5`
- `0 <= height[i] <= 10^4`

### Solution 💡

To solve this problem, we can use the **Two-Pointer Technique**:

1. **Initialize Two Pointers**: Start with `left` pointer at the beginning (0) and `right` pointer at the end (n - 1) of the array.
2. **Calculate Area**: For each pair of lines, calculate the area formed by the lines at `left` and `right`, which is given by `min(height[left], height[right]) * (right - left)`.
3. **Move the Pointer**:
   - Move the pointer pointing to the shorter line inward (either increment `left` or decrement `right`).
   - By moving the shorter line, we maximize the chance of finding a taller line to potentially increase the container area.
4. **Track the Maximum Area**: Keep updating the maximum area found during each iteration.
5. **Repeat** until the two pointers meet.

#### Java Solution

```java
public class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);

            // Move the pointer for the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
```

#### Time Complexity ⏳

- **O(n)**, where `n` is the length of the array. We scan the array once using two pointers.

#### Space Complexity 💾

- **O(1)**, since we only use a constant amount of extra space.

You can find the full solution [here](Solution.java).