/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-05-24 16:20:41
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

public class Solution {
    public int majorityElement(int[] nums) {

        // initialize the first element as the majority candidate
        int majority = nums[0];
        // start the count for the majority candidate as 1
        int count = 1;

        // Because the number of majority elements is greater than n/2, the count of that element will always be greater than 0
        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {

            // if the count = 0 so we choose the current element as the new majority candidate
            if (count == 0) {
                majority = nums[i];
                count = 1;
            }
            // if the current element is the same with the majority candidate, increment the count with 1
            else if (nums[i] == majority) {
                count++;
            }
            // If the current element is different from the majority candidate, decrement the count
            else {
                count--;
            }
        }

        // After the loop, `majority` will hold the majority element
        return majority;
    }
}