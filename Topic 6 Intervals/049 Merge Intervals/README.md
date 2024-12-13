## 56. Merge Intervals 🔀

**Difficulty**: `Medium` - **Tags**: `Array`, `Sorting`, `Intervals`

[LeetCode Problem Link](https://leetcode.com/problems/merge-intervals/)

---

### Problem Statement 📜

Given an array of intervals where `intervals[i] = [start_i, end_i]`, merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

---

### Examples 🌟

🔹 **Example 1:**

**Input:**
```plaintext
intervals = [[1,3],[2,6],[8,10],[15,18]]
```

**Output:**
```plaintext
[[1,6],[8,10],[15,18]]
```

**Explanation:**
Since intervals `[1,3]` and `[2,6]` overlap, merge them into `[1,6]`.

---

🔹 **Example 2:**

**Input:**
```plaintext
intervals = [[1,4],[4,5]]
```

**Output:**
```plaintext
[[1,5]]
```

**Explanation:**
Intervals `[1,4]` and `[4,5]` are considered overlapping.

---

### Constraints ⚙️

- `1 <= intervals.length <= 10^4`
- `intervals[i].length == 2`
- `0 <= start_i <= end_i <= 10^4`

---

### Solution 💡

The task is to merge overlapping intervals. Sorting the intervals by their start times and iterating through the list makes it easier to merge overlapping intervals.

---

#### Java Solution

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        // Step 2: Merge intervals
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (nextStart <= currentEnd) {
                // Overlapping intervals, merge them
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap, add the next interval
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
```

---

### Explanation of the Solution

1. **Sort the Intervals**:
   - Sorting ensures that intervals are ordered by their start time, making it easier to detect overlaps.

2. **Iterate and Merge**:
   - Compare the `end` of the current interval with the `start` of the next interval.
   - If overlapping, update the `end` of the current interval to the maximum of both intervals.
   - If not overlapping, add the current interval to the result list and move to the next interval.

3. **Convert the Result**:
   - Convert the list of merged intervals back to a 2D array.

---

### Time Complexity ⏳

- **O(n log n)**: Sorting the intervals takes `O(n log n)`, and the merging step takes `O(n)`.

### Space Complexity 💾

- **O(n)**: The output list may contain all intervals in the worst case.

You can find the full solution [here](Solution.java).
