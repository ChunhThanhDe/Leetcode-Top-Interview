// input: 2D array of point representing balloon ranges
// output: Integer, minimum of arrows required to burst all balloons.

import java.util.Arrays;

class Solution{
    public int findMinArrowShots(int[][] points){
        // handle edge case: no balloon
        if (points.length == 0) return 0;

        // step 1: sort balloon by their end point
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int currentEnd = points[0][1]; // end point for first balloon

        // step2: iterate each the sorted ballo0n
        for (int i = 1; i < points.length; i++){
            // check if the current balloon starts
            // after the last arrow's range
            if (points[i][0] > currentEnd){
                arrows ++;
                currentEnd = points[i][1]; // update the end of last arrows
            }
            // else. the current balloon is already burst by the previous arrow
        }

        // re turn the total number of arrow needed
        return arrows;

    }


    public static void main(String[] args){
        Solution solution = new Solution();

        // Testcase 1
        int[][] points1 = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println("Testcase 1: Minimum arrows = " + solution.findMinArrowShots(points1));

        // Testcase 2
        int[][] points2 = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        System.out.println("Testcase 2: Minimum arrows = " + solution.findMinArrowShots(points2));

        // Testcase 3
        int[][] points3 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        System.out.println("Testcase 3: Minimum arrows = " + solution.findMinArrowShots(points3));
    }
}