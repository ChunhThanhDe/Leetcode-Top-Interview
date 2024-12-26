/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-05-24 16:20:41
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0; // the number of jumps made so far
        int currentJumpEnd = 0; // the farthest point that can be reached with current jump
        int maxReach = 0; // the farthest point of jumps that can be reached overall

        // loop through the array but stop at the second-the-last element
        // since we donn't need to jump from the last element
        for (int i = 0; i < n - 1; i++) {

            // update the maxReach to be farthest point that can be reached from index i
            maxReach = Math.max(maxReach, i + nums[i]);

            // if maxReach is already beyond or at the last element, we can stop here
            if (maxReach >= n - 1) {
                jumps++; // make the final jump
                break; // Exit loop
            }

            // if we have reached the farthest point we can go with the jump with current maxReach
            if (i == currentJumpEnd) {
                currentJumpEnd = maxReach; // setup the next jump range
                jumps++; // increment the jumps count
            }
        }

        return jumps; // return the minimum number of jumps to reach `nums[n - 1]`
    }
}