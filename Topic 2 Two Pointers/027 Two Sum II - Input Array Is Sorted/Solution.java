/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-05-24 16:20:41
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

public class Solution {
    public int[] twoSum(int[] numbers, int target){

        // initialize two pointer, left at the start and right at the end
        int left = 0;
        int right = numbers.length - 1;

        // loop until the two pointer meet
        while (left < right){
            // calculate the sum of values at left and right pointers
            int sum = numbers[left] + numbers[right];

            // check if the sum match the target
            if (sum < target){
                // move the left pointer fight if the sum is too small
                left ++;
            } else if (sum == target){
                // return the +1 indices if sum equals target
                return new int[]{left + 1, right + 1};
            } else {
                // move the right pointer if the sum is two large
                right --;
            }
        }

        return new int[0];
    }

}