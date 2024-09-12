## 80. Remove Duplicates from Sorted Array II 🚫🚫

**Difficulty**: `Medium` - **Tags**: `Array`, `Two Pointers`

### Description 📋

Given an integer array `nums` sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array `nums`. More formally, if there are `k` elements after removing the duplicates, then the first `k` elements of `nums` should hold the final result. It does not matter what you leave beyond the first `k` elements.

Return `k` after placing the final result in the first `k` slots of `nums`.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

### Custom Judge 🧪

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

### Examples 🌟

**Example 1:**

**Input:**
```python
nums = [1,1,1,2,2,3]
```

**Output:**
```python
5
```

**Explanation:**
Your function should return `k = 5`, with the first five elements of `nums` being 1, 1, 2, 2, and 3 respectively. It does not matter what you leave beyond the returned `k` (hence they are underscores).

**Example 2:**

**Input:**
```python
nums = [0,0,1,1,1,1,2,3,3]
```

**Output:**
```python
7
```

**Explanation:**
Your function should return `k = 7`, with the first seven elements of `nums` being 0, 0, 1, 1, 2, 3, and 3 respectively. It does not matter what you leave beyond the returned `k` (hence they are underscores).

### Constraints ⚙️

- `1 <= nums.length <= 3 * 10^4`
- `-10^4 <= nums[i] <= 10^4`
- `nums` is sorted in non-decreasing order.

### Solution 💡

The time complexity is $O(n)$, and the space complexity is $O(1)$. Here, $n$ is the length of the array.

#### Java

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        
        int k = 2; // Allow the first two elements to be present

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k++] = nums[i];
            }
        }

        return k;
    }
}
```

You can find the full `Solution.java` file [here](Solution.java).