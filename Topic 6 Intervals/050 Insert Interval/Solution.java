// Input: 2D array of non-overlapping intervals and a single `newInterval` to insert
// output: Update 2D array of intervals with new interval inserted and merged

import java.util.ArrayList;
import java.util.List;

public class Solution{
  public int[][] insert(int[][] intervals, int[] newInterval){
    // result list to store final intervals
    List<int[]> result = new ArrayList<>();

    int i = 0;
    int n = intervals.length;

    // step 1: add all intervals of Intervals not overlap with `newInterval`
    while (i < n && intervals[i][1] < newInterval[0]){
      result.add(intervals[i]);
      i ++;
    }

    // step 2: merge overlapping intervals with `newInterval`
    while (i < n && intervals[i][0] <= newInterval[1]){
      // update the start of the merged interval
      newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
      // update the end of the merged interval
      newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
      i++;
    }

    // add the merged interval
    result.add(newInterval);

    // step 3: add remaining intervals that come after new Interval
    while (i < n) {
      result.add(intervals[i]);
      i++;
    }

    // Convert result list back to 2D array
    return result.toArray(new int [result.size()][]);

  }

  // Testcases
  public static void main(String[] args) {
    Solution solution = new Solution();

    // Testcase 1
    int[][] intervals1 = {{1, 3}, {6, 9}};
    int[] newInterval1 = {2, 5};
    System.out.println("Result 1: " + java.util.Arrays.deepToString(solution.insert(intervals1, newInterval1)));

    // Testcase 2
    int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
    int[] newInterval2 = {4, 8};
    System.out.println("Result 2: " + java.util.Arrays.deepToString(solution.insert(intervals2, newInterval2)));
  }

}