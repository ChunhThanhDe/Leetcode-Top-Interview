/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-05-24 16:20:41
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

public class Solution {
    public boolean canJump(int[] nums) {

        // Tracks the farthest index
        int maxReach = 0;

        // loop through each index in the nums
        for (int i = 0; i < nums.length; i++){

            // if the maxReach higher or equal nums.length,
            // it mean we can reach the last index,
            if (maxReach >= nums.length - 1) return true;

            // if the current index is higher than current maxReach,
            // we can not move forward
            if (i > maxReach) return false;

            // update maxReach if the current position + jump value is farther
            maxReach = Math.max(maxReach, i + nums[i]);
        }

        // return false if can find way to reach the last index
        return false;
    }
}