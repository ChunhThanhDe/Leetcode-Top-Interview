## 238. Product of Array Except Self 🔄

**Difficulty**: `Medium` - **Tags**: `Array`, `Prefix Sum`

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

---

### Solution 💡

We can solve this problem using two passes through the array:
1. First pass calculates the prefix product for each element.
2. Second pass calculates the suffix product and multiplies it with the prefix product to get the final result.

**Why not use division to calculate the product?**

A straightforward approach would be to compute the total product of all the elements and then for each index, divide the total product by `nums[i]` to get `answer[i]`. However, this solution **cannot** be used because:
- **The problem explicitly prohibits using the division operation.**
- Division does not handle cases where the array contains zero, as division by zero is undefined.

#### Java

```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Calculate prefix products
        result[0] = 1;  // no elements to the left of the first element
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: Calculate suffix products and multiply with prefix products
        int suffix = 1;  // no elements to the right of the last element
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }

        return result;
    }
}
```

#### Time Complexity ⏳
- Both passes through the array take **O(n)**, where `n` is the number of elements in `nums`.

#### Space Complexity 💾
- The space complexity is **O(1)** for the output array `result`, as the calculation is done in-place.

You can find the full `Solution.java` file [here](Solution.java).