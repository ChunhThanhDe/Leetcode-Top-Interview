## 169. Majority Element 👑

**Difficulty**: `Easy` - **Tags**: `Array`, `Hash Map`, `Sorting`, `Divide and Conquer`

### Description 📋

Given an array `nums` of size `n`, return the **majority element**.

The majority element is the element that appears **more than** ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

### Examples 🌟

**Example 1:**

**Input:**
```python
nums = [3,2,3]
```

**Output:**
```python
3
```

**Example 2:**

**Input:**
```python
nums = [2,2,1,1,1,2,2]
```

**Output:**
```python
2
```

### Constraints ⚙️

- `n == nums.length`
- `1 <= n <= 5 * 10^4`
- `-10^9 <= nums[i] <= 10^9`

The majority element always exists in the array.

### Solution 💡

The time complexity is $O(n)$, and the space complexity is $O(1)$. This approach uses **Boyer-Moore Voting Algorithm**, which efficiently finds the majority element.

#### Java

```java
public class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 1;

        // Because the number of majority elements is greater than n/2, the count of that element will always be greater than 0
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
                count = 1;
            } else if (nums[i] == majority) {
                count++;
            } else {
                count--;
            }
        }

        return majority;
    }
}
```

You can find the full `Solution.java` file [here](Solution.java).
