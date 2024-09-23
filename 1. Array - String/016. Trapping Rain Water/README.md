## 42. Trapping Rain Water 🌧️

**Difficulty**: `Medium` - **Tags**: `Stack`, `Array`, `Two Pointers`, `Dynamic Programming`, `Monotonic Stack`

### Description
Given `n` non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

![](rainwatertrap.png)

### Examples

**Example 1:**

Input:
```python
height = [0,1,0,2,1,0,1,3,2,1,2,1]
```

Output:
```
6
```

Explanation:
The above elevation map (black section) is represented by the array `[0,1,0,2,1,0,1,3,2,1,2,1]`. In this case, 6 units of rainwater (blue section) are being trapped.

**Example 2:**

Input:
```python
height = [4,2,0,3,2,5]
```

Output:
```
9
```

### Constraints

- The length of `height` is in the range `[0, 2 * 10^4]`.
- Each element in `height` is a non-negative integer in the range `[0, 10^5]`.

### Solution 💡

To solve this problem, we can visualize the elevation map as a mountain with a highest peak. By calculating the amount of water that can be trapped from both edges towards the peak, we can determine the total trapped water:
1. Initialize two pointers (`left` and `right`) at both ends of the array and two variables to track the maximum height seen from both ends.
2. Move the pointers towards each other, calculating the trapped water based on the minimum of the two maximum heights.

#### Java

```java
class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int waterTrapped = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    waterTrapped += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    waterTrapped += rightMax - height[right];
                }
                right--;
            }
        }

        return waterTrapped;
    }
}
```

#### Time Complexity ⏳
- The time complexity is **O(n)**, where `n` is the number of elements in `height`.

#### Space Complexity 💾
- The space complexity is **O(1)**, as we only use a few variables for tracking.

You can find the full solution [here](Solution.java).