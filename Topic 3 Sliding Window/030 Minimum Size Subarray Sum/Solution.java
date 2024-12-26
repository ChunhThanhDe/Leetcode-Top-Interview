/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-05-24 16:38:59
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

// input: an array of positive integers 'nums' and a positive integer 'target'
// output: minimal length of a subarray with sum >= 'target', or 0 if none exists

public class Solution {
    public int minSubArrayLen(int target, int[] nums){

        // Initialize pointer for the sliding window
        // and variables to track the sum and minimal length
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        // loop through the array with the right pointer
        for (int right = 0; right < nums.length; right++){
            // add the current number to the sum
            sum += nums[right];

            // check if the current window sum is greater than or equal to target
            while(sum >= target) {
                // Update the minimum length if the current window is smaller
                minLength = Math.min(minLength, right + 1 - left);
                //  the window from the left by subtracting the leftmost element
                sum -= nums[left++];
            }
        }

        // if the minlength was not update, return 0, otherwise return minlength
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}