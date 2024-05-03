## Rotate Array

### Description
Given an integer array `nums`, rotate the array to the right by `k` steps, where `k` is non-negative.

### Examples

**Example 1:**

Input:
```python
nums = [1,2,3,4,5,6,7]
k = 3
```

Output:
```
[5,6,7,1,2,3,4]
```

Explanation:
- Rotate 1 step to the right: [7,1,2,3,4,5,6]
- Rotate 2 steps to the right: [6,7,1,2,3,4,5]
- Rotate 3 steps to the right: [5,6,7,1,2,3,4]

**Example 2:**

Input:
```python
nums = [-1,-100,3,99]
k = 2
```

Output:
```
[3,99,-1,-100]
```

Explanation:
- Rotate 1 step to the right: [99,-1,-100,3]
- Rotate 2 steps to the right: [3,99,-1,-100]