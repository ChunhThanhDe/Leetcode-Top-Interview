
## 452. Minimum Number of Arrows to Burst Balloons 🎈

**Difficulty**: `Medium` - **Tags**: `Greedy`, `Intervals`, `Sorting`

[LeetCode Problem Link](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/)

---

### Problem Statement 📜

There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array `points`, where `points[i] = [xstart, xend]` denotes a balloon whose horizontal diameter stretches between `xstart` and `xend`.

Arrows can be shot up vertically along the x-axis. A balloon with `xstart` and `xend` is burst by an arrow shot at `x` if `xstart <= x <= xend`.

**Task**: Return the minimum number of arrows required to burst all balloons.

---

### Examples 🌟

🔹 **Example 1:**

**Input:**
```plaintext
points = [[10,16],[2,8],[1,6],[7,12]]
```

**Output:**
```plaintext
2
```

**Explanation:**
- Shoot an arrow at `x = 6`, bursting the balloons `[2,8]` and `[1,6]`.
- Shoot another arrow at `x = 11`, bursting the balloons `[10,16]` and `[7,12]`.

---

🔹 **Example 2:**

**Input:**
```plaintext
points = [[1,2],[3,4],[5,6],[7,8]]
```

**Output:**
```plaintext
4
```

**Explanation:**
Each balloon requires a separate arrow.

---

🔹 **Example 3:**

**Input:**
```plaintext
points = [[1,2],[2,3],[3,4],[4,5]]
```

**Output:**
```plaintext
2
```

**Explanation:**
- Shoot an arrow at `x = 2`, bursting the balloons `[1,2]` and `[2,3]`.
- Shoot another arrow at `x = 4`, bursting the balloons `[3,4]` and `[4,5]`.

---

### Constraints ⚙️

- `1 <= points.length <= 10^5`
- `points[i].length == 2`
- `-2^31 <= xstart < xend <= 2^31 - 1`

---

### Solution 💡

To solve the problem, follow these steps:
1. Sort the `points` array by the ending position of each interval.
2. Use a greedy approach to minimize the number of arrows:
   - Start with one arrow to burst the first interval.
   - For each subsequent interval, check if it overlaps with the previous interval:
     - If it does, continue with the current arrow.
     - Otherwise, shoot a new arrow.

---

#### Java Solution

```java
import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // Step 1: Sort intervals by their end points
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1; // At least one arrow is needed
        int currentEnd = points[0][1]; // End point of the first balloon

        // Step 2: Iterate through the intervals
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > currentEnd) {
                // A new arrow is needed
                arrows++;
                currentEnd = points[i][1];
            }
        }

        return arrows;
    }
}
```

---

### Explanation of the Solution

1. **Sorting by End Points**:
   - Sorting ensures that we process balloons in order of their earliest end point.
   - This allows us to maximize the coverage of a single arrow.

2. **Tracking Overlaps**:
   - Start with one arrow at the end of the first balloon.
   - If the next balloon starts after the current arrow's range (`points[i][0] > currentEnd`), shoot a new arrow.
   - Otherwise, the current arrow is sufficient to burst overlapping balloons.

---

### Time Complexity ⏳

- **O(n log n)**: Sorting the balloons array dominates the time complexity.
- **O(n)**: Linear traversal of the sorted intervals.

### Space Complexity 💾

- **O(1)**: Sorting is in-place, and no additional space is used.

---

You can find the full solution [here](Solution.java).