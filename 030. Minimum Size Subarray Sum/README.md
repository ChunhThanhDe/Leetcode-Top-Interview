## Minimum Size Subarray Sum

📜 **Problem Statement:**
Given an array of positive integers `nums` and a positive integer `target`, return the minimal length of a subarray whose sum is greater than or equal to `target`. If there is no such subarray, return 0 instead.

### Examples

🔹 **Example 1:**

Input:
```python
target = 7
nums = [2,3,1,2,4,3]
```

Output:
```
2
```

Explanation: The subarray `[4,3]` has the minimal length under the problem constraint.

🔹 **Example 2:**

Input:
```python
target = 4
nums = [1,4,4]
```

Output:
```
1
```

🔹 **Example 3:**

Input:
```python
target = 11
nums = [1,1,1,1,1,1,1,1]
```

Output:
```
0
```

📝 **Constraints:**

- `1 <= target <= 10^9`
- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^4`