## 274. H-Index 📊

**Difficulty**: `Medium` - **Tags**: `Array`, `Sorting`

### Description
Given an array of integers `citations` where `citations[i]` is the number of citations a researcher received for their `ith` paper, return the researcher's `h-index`.

The **h-index** is defined as the maximum value of `h` such that the researcher has published at least `h` papers that have each been cited at least `h` times.

### Examples

**Example 1:**

Input:
```python
citations = [3,0,6,1,5]
```

Output:
```
3
```

Explanation:
The researcher has 5 papers in total, with citation counts of `[3,0,6,1,5]`. 
- The h-index is 3 because there are 3 papers with at least 3 citations each, and the remaining 2 papers have fewer than 3 citations.

**Example 2:**

Input:
```python
citations = [1,3,1]
```

Output:
```
1
```

Explanation:
The researcher has 3 papers with citation counts `[1,3,1]`.
- The h-index is 1 because there is 1 paper with at least 1 citation, and the remaining papers have fewer than 1 citation.

---

### Solution 💡

Sort the citations array in descending order. The h-index is the maximum value of `h` such that there are at least `h` papers with `h` or more citations.

#### Java

```java
import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n - i) {
                return n - i;
            }
        }
        return 0;
    }
}
```

#### Time Complexity ⏳
- Sorting the array takes `O(n log n)`, where `n` is the number of citations.
- The for loop iterates through the sorted array, taking `O(n)` time.

Thus, the overall time complexity is **O(n log n)**.

#### Space Complexity 💾
- The space complexity is **O(1)** since the sorting is done in-place and we are using only a few extra variables.

You can find the full `Solution.java` file [here](Solution2.java) and the best Solution is [here](Solution.java).