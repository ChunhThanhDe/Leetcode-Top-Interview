## 55. Jump Game 🏃‍♂️

**Difficulty**: `Medium` - **Tags**: `Array`, `Greedy`, `Dynamic Programming`

### Description
You are given an integer array `nums`. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return `true` if you can reach the last index, or `false` otherwise.

### Examples

**Example 1:**

Input:
```python
nums = [2,3,1,1,4]
```

Output:
```
true
```

Explanation:
Jump 1 step from index 0 to 1, then 3 steps to the last index.

**Example 2:**

Input:
```python
nums = [3,2,1,0,4]
```

Output:
```
false
```

Explanation:
You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

---

### Solution 💡

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the number of elements in the array.

#### Java

```java
class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }
}
```
You can find the full `Solution.java` file [here](Solution.java).
