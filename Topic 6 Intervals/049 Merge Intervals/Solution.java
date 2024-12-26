/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-12-13 08:17:46
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

// input: 2D array of intervals
// output: 2D array of merge non-overlapping intervals

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] merge ( int [][] intervals){
        // Handle edge case
        if (intervals.length <= 1) return intervals;

        // step 1: sort intervals by their start times
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        // step 2: create a list to store merged intervals
        List<int[]> merged = new ArrayList<>();

        // initialize the first interval as the current interval
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        // iterate each interval
        for (int[] interval : intervals){
            int currentEnd = currentInterval[1]; // end of the current interval
            int nextStart = interval[0]; // start of the next interval
            int nextEnd = interval[1]; // end of the next interval

            if (nextStart <= currentEnd){
                // if overlap, merge
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // if no overlap
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        // convert the list ò intervals back to a 2D array
        return merged.toArray(new int[merged.size()][]);
    }

    // Testcase
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Testcase 1
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("Merged intervals 1: " + Arrays.deepToString(solution.merge(intervals1)));

        // Testcase 2
        int[][] intervals2 = {{1, 4}, {4, 5}};
        System.out.println("Merged intervals 2: " + Arrays.deepToString(solution.merge(intervals2)));
	}

}