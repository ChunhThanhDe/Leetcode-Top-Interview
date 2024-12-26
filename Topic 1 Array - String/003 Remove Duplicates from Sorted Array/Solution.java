/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-05-24 16:20:41
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

public class Solution {
    public int removeDuplicates(int[] nums) {

        // check if the array is empty, return 0 as there are no element to process
        if(nums.length == 0){
            return 0;
        }

        // 'k' is the index for the next position of the next unique element
        int k = 1; // start with the first unique element (index 1)

        // Iterate through the array to start from the second element
        for (int i = 1; i < nums.length; i++){

            // if the current element if diff with the previous element
            // it mean this element is unique and should be kept
            if (nums[i] != nums[i - 1]){

                // place the unique element at index 'k' and 'increment' 'k'
                nums[k++] = nums[i];
            }
        }

        // Return the number of unique in the array
        return k;
    }
}
