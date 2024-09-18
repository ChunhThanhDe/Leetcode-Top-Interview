## 45. Jump Game II 🏃‍♂️

**Difficulty**: `Hard` - **Tags**: `Array`, `Greedy`, `Dynamic Programming`, `Breadth-First Search`

### Description
You are given a 0-indexed array of integers `nums` of length `n`. You are initially positioned at `nums[0]`.

Each element `nums[i]` represents the maximum length of a forward jump from index `i`. In other words, if you are at `nums[i]`, you can jump to any `nums[i + j]` where:
- `0 <= j <= nums[i]` and
- `i + j < n`

Return the minimum number of jumps to reach `nums[n - 1]`. The test cases are generated such that you can reach `nums[n - 1]`.

### Examples

**Example 1:**

Input:
```python
nums = [2,3,1,1,4]
```

Output:
```
2
```

Explanation:
The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

**Example 2:**

Input:
```python
nums = [2,3,0,1,4]
```

Output:
```
2
```

Explanation:
The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

---

### Solution 💡

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array.

#### Java

```java
class Solution {
    public int jump(int[] nums) {
        int jumps = 0, currentEnd = 0, maxReach = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = maxReach;
            }
        }
        return jumps;
    }
}
```

