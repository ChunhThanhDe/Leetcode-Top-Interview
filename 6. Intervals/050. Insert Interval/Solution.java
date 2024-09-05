class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    int n = intervals.length;
    List<int[]> ans = new ArrayList<>();
    int i = 0;
    // Before we find overlapping, add non-overlapping intervals into result
    for (; i < n && intervals[i][1] < newInterval[0]; ++i) {
      ans.add(intervals[i]);
    }
    // Merge the overlapping intervals and add it to result. We don't need an extra
    // array, and instead we can update newInterval.
    if (i < n) {
      newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
    }
    for (; i < n && intervals[i][0] <= newInterval[1]; ++i) {
      newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
    }
    ans.add(newInterval);
    // Add the remaining non-overlapping intervals
    for (; i < n; ++i) {
      ans.add(intervals[i]);
    }
    return ans.toArray(new int[ans.size()][]);
  }
}