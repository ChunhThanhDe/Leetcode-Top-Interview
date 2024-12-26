# Topic 6 Intervals

## 🛠 Overview

**Intervals** problems on LeetCode involve working with ranges of values, typically represented as pairs of numbers `[start, end]`. These problems often require operations like merging, inserting, or determining overlaps between intervals. Understanding these problems is crucial for mastering algorithmic concepts in sorting, greedy algorithms, and binary search.

---

## 🎯 Common Operations on Intervals

- **Merging Overlapping Intervals**
- **Inserting Intervals**
- **Checking Overlap**
- **Counting Non-Overlapping Intervals**

## 🧠 Tips and Tricks

1. **Sorting is Key:**

   - Many interval problems require sorting by the start (or end) of intervals. Sorting simplifies comparisons and merging.

2. **Greedy Algorithms Work Well:**

   - Problems involving overlapping intervals often use a greedy approach, focusing on choosing the "best" interval at each step.

3. **Edge Cases to Watch For:**

   - Empty interval lists.
   - Single intervals.
   - Completely overlapping intervals, e.g., `[1, 10]` and `[2, 5]`.
   - Non-overlapping intervals, e.g., `[1, 2]` and `[3, 4]`.

4. **Understand the Mathematical Overlap Condition:**
   - Two intervals overlap if `max(start1, start2) <= min(end1, end2)`.

---

## 🔥 Popular LeetCode Problems on Intervals

1. **[Summary RangesRanges](048%20Summary%20Ranges/README.md)**
2. **[Merge Intervals](049%20Merge%20Intervals/README.md)**
3. **[Insert Interval](050%20Insert%20Interval/README.md)**
4. **[Minimum Number of Arrows to Burst Balloons](051%20Minimum%20Number%20of%20Arrows%20to%20Burst%20Balloons/README.md)**

Happy Coding
