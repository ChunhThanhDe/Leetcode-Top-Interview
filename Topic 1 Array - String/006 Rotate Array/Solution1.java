/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-09-16 09:37:48
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

class Solution {
    public void rotate(int[] nums, int k) {

        // step 0: Ensure k is within the array bounds. In case k is larger nums.length take modulo
        // For example, if k = 3 and nums.length = 7, k = 3 % 7 = 3 (no change)
        k = k % nums.length;

        // step 1: reverse all element - reverse the entre array
        // before reverse [1, 2, 3, 4, 5, 6, 7]
        reverse(nums, 0, nums.length - 1);
        // after reverse [7, 6, 5, 4, 3, 2, 1]

        // step 2: reverse first k element
        // Before reverse: first 3 element are [7, 6, 5]
        reverse(nums, 0, k - 1);
        // After reverse: [5, 6, 7, 4 ,3 ,2 ,1]

        // step 3: reverse the remaining elements in the array
        // Remaining elements are [4, 3, 2, 1], reverse this part
        reverse (nums, k, nums.length - 1);
        // After reverse: [5, 6 ,7 , 1, 2, 3, 4]


    }

    // Function to reverse element in the array nums beetween 'start' and 'end' indexs
    private void reverse (int[] nums, int start, int end){
        while (start < end){
            // swap element at 'start' and 'end' position
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;

            // Move the 'start' pointer forward and 'end' pointer backward
            start++;
            end--;
        }
    }
}
