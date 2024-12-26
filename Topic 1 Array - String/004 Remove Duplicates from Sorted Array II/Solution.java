/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-05-24 16:20:41
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

public class Solution {
    public int removeDuplicates(int[] nums) {

        // if the array has tw0 or fewer element, return its length directly
        // since it can't contain more than 2 duplicates
        if (nums.length <= 2) return nums.length;

        // 'k' is index where the next unique or allowed element will be placed
        // Initialize 'k' = 2, allowing the first two element to be present
        int k = 2;

        // start iterating from the third element (index = 2)
        for (int i = 2; i < nums.length; i++){

            // if the current element 'nums[i]' is not the same with the element two positions before 'nums[k - 2]'
            // it means this element can be keep (because allow at most two element duplicates)
            if (nums[i] != nums[k - 2]){

                // move the current element 'nums[i]' to the position 'k' and increment 'k'
                nums[k++] = nums[i];
            }
        }


        // return 'k' which represents the new length of the array with duplicates removed rule
        return k;
    }

}