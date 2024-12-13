## 57. Insert Interval 🆕

**Difficulty**: `Medium` - **Tags**: `Array`, `Intervals`

[LeetCode Problem Link](https://leetcode.com/problems/insert-interval/)

---

### Problem Statement 📜

You are given an array of non-overlapping intervals `intervals` where `intervals[i] = [start_i, end_i]` represent the start and end of the `i`th interval, and `intervals` is sorted in ascending order by `start_i`.

You are also given an interval `newInterval = [start, end]` that represents the start and end of another interval.

**Task**: Insert `newInterval` into `intervals` such that:
1. The resulting intervals are sorted in ascending order by `start_i`.
2. Merge overlapping intervals if necessary.

Return the updated list of intervals.

---

### Examples 🌟

🔹 **Example 1:**

**Input:**
```plaintext
intervals = [[1,3],[6,9]], newInterval = [2,5]
```

**Output:**
```plaintext
[[1,5],[6,9]]
```

---

🔹 **Example 2:**

**Input:**
```plaintext
intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
```

**Output:**
```plaintext
[[1,2],[3,10],[12,16]]
```

**Explanation:**
The new interval `[4,8]` overlaps with `[3,5]`, `[6,7]`, and `[8,10]`.

---

### Constraints ⚙️

- `0 <= intervals.length <= 10^4`
- `intervals[i].length == 2`
- `0 <= start_i <= end_i <= 10^5`
- `intervals` is sorted by `start_i` in ascending order.
- `newInterval.length == 2`
- `0 <= start <= end <= 10^5`

---

### Solution 💡

To solve this, we can iterate through the `intervals` array and:
1. Add intervals that come before `newInterval` without overlap.
2. Merge `newInterval` with overlapping intervals.
3. Add intervals that come after `newInterval` without overlap.

---

#### Java Solution

```java
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        // Step 1: Add all intervals that come before the new interval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Step 2: Merge overlapping intervals with the new interval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // Step 3: Add all intervals that come after the new interval
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
```

---

### Explanation of the Solution

1. **Before the Overlap**:
   - Add all intervals that end before the `newInterval` starts.

2. **Merging Overlapping Intervals**:
   - For overlapping intervals, merge them by updating the start and end of `newInterval`.

3. **After the Overlap**:
   - Add all remaining intervals after `newInterval` is inserted.

---

### Time Complexity ⏳

- **O(n)**: We iterate through the `intervals` array once.

### Space Complexity 💾

- **O(n)**: The result array can contain up to `n + 1` intervals.

You can find the full solution [here](Solution.java).