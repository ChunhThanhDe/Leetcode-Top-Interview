## Product of Array Except Self

### Description
Given an integer array `nums`, return an array `answer` such that `answer[i]` is equal to the product of all the elements of `nums` except `nums[i]`.

The product of any prefix or suffix of `nums` is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

### Examples

**Example 1:**

Input:
```python
nums = [1,2,3,4]
```

Output:
```python
[24,12,8,6]
```

**Example 2:**

Input:
```python
nums = [-1,1,0,-3,3]
```

Output:
```python
[0,0,9,0,0]
```