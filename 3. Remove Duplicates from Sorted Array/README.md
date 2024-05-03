## Remove Duplicates from Sorted Array

### Description
Given an integer array `nums` sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in `nums`.

Consider the number of unique elements in `nums` to be `k`. To get accepted, you need to do the following things:

1. Change the array `nums` such that the first `k` elements of `nums` contain the unique elements in the order they were present in `nums` initially. The remaining elements of `nums` are not important, as well as the size of `nums`.
2. Return `k`.

### Custom Judge

The judge will test your solution with the following code:

```python
int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
```

If all assertions pass, then your solution will be accepted.

### Examples

**Example 1:**

Input:
```python
nums = [1,1,2]
```

Output:
```
2
```

Explanation:
Your function should return `k = 2`, with the first two elements of `nums` being 1 and 2 respectively.
It does not matter what you leave beyond the returned `k` (hence they are underscores).

**Example 2:**

Input:
```python
nums = [0,0,1,1,1,2,2,3,3,4]
```

Output:
```
5
```

Explanation:
Your function should return `k = 5`, with the first five elements of `nums` being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned `k` (hence they are underscores).