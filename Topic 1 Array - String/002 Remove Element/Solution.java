/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-05-24 16:20:41
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0; // `k` is the index for the position of the next valid element in the array

        // Iterate through each element in the 'nums' array
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val){

                // assign the value of 'nums[1] to nums[k]'
                // this effectively moves valid elements to the beginning of the array
                nums[k++] = nums[i];
            }
        }

        // return the number of valid element in the array (excluding elements equal to 'val')
        return k;
    }
}
