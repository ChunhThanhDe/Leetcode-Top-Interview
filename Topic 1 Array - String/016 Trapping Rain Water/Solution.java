/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-09-24 09:28:30
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

public class Solution {

    public int trap(int[] height) {

        // initialize 2 pointers: left starting from the beginning, right from the end
        int left = 0;
        int right = height.length - 1;

        // variables to store the maximum height encountered so far from the left and
        // right
        int leftMax = 0;
        int rightMax = 0;

        // Variable to sum the total amount of trapped water
        int waterTrapped = 0;

        // process the height array until the two pointers meet
        while (left < right) {
            // Compare the height at the two pointers
            if (height[left] < height[right]) {
                // if the height at the left pointer is greater than leftMax, update leftMax
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    waterTrapped += leftMax - height[left];
                }
                // move the left pointer to the right
                left++;
            } else {
                // if the height at the right pointer is greater than the rightMax, update
                // rightMax
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    waterTrapped += rightMax - height[right];
                }
                // move the right pointer to the left
                right--;
            }
        }

        return waterTrapped;

    }
}
