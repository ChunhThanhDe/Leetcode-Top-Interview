## 88. Merge Sorted Arrays 🧩

**Difficulty**: **Easy**  
**Tags**: **Array**, **Two Pointers**, **Sorting**

[[Vietnamese version here]](1. Array - String\001. Merge Sorted Array\README_VI.md)

---

### Description 📋

You are given two integer arrays `nums1` and `nums2`, sorted in non-decreasing order, and two integers `m` and `n`, representing the number of elements in `nums1` and `nums2` respectively.

Merge `nums1` and `nums2` into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array `nums1`. To accommodate this, `nums1` has a length of `m + n`, where the first `m` elements denote the elements that should be merged, and the last `n` elements are set to 0 and should be ignored. `nums2` has a length of `n`.

### Examples 🌟

**Example 1:**

**Input:**
```python
nums1 = [1,2,3,0,0,0]
m = 3
nums2 = [2,5,6]
n = 3
```

**Output:**
```python
[1,2,2,3,5,6]
```

**Explanation:**
The arrays we are merging are `[1,2,3]` and `[2,5,6]`. The result of the merge is `[1,2,2,3,5,6]` with the underlined elements coming from `nums1`. ✨

**Example 2:**

**Input:**
```python
nums1 = [1]
m = 1
nums2 = []
n = 0
```

**Output:**
```python
[1]
```

**Explanation:**
The arrays we are merging are `[1]` and `[]`. The result of the merge is `[1]`. 🎯

**Example 3:**

**Input:**
```python
nums1 = [0]
m = 0
nums2 = [1]
n = 1
```

**Output:**
```python
[1]
```

**Explanation:**
The arrays we are merging are `[]` and `[1]`. The result of the merge is `[1]`. Note that because `m = 0`, there are no elements in `nums1`. The 0 is only there to ensure the merge result can fit in `nums1`. 🛠️

### Constraints ⚙️

- `nums1.length == m + n`
- `nums2.length == n`
- `0 <= m, n <= 200`
- `1 <= m + n <= 200`
- `-10^9 <= nums1[i], nums2[j] <= 10^9`

### Solution 💡

#### Java

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n){
        int i = m - 1; // index of the last element in the sorted of nums1
        int j = n - 1; // index of the last element in nums2
        int k = m + n -1; // index of the last position in nums1 affter merging

        // loop until all elements from nums2 are merged into nums1
        while (j >= 0){
            // if nums1 has element left and the current element in nums1 is larger
            if (i >= 0 && nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--]; // place nums1's element at position k
            } else {
                nums1[k--] = nums2[j--] // Otherwise, place nums2's element at position k
            }
        }
    }
}
```

You can find the full `Solution.java` file [here](1. Array - String\001. Merge Sorted Array\Solution.java).