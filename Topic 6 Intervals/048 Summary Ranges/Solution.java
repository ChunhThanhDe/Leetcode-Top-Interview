/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-07-25 16:58:19
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

// input:  a sorted unique integer array nums.
// output: a list of String that representing ranges in the array

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<String> summaryRanges(int[] nums){
		List<String> result = new ArrayList<>();

		// check if nums is empty
		if (nums.length == 0) return result;

		// initialize the point to mark the start of range
		int start = nums[0];

		// iterate through each number in the array
		for (int i = 1; i <= nums.length; i++){
			// Check if the range ends
			if (i == nums.length || nums[i] != nums[i - 1] + 1){
				if (start == nums[i - 1]){
					// add single number
					result.add(String.valueOf(start));
				} else {
					// add range as "start->end"
					result.add(start + "->" + String.valueOf(nums[i - 1]));
				}

				// Update the start for the next range
				if (i < nums.length) start = nums[i];
			}
		}
		return result; // Return the list of ranges
	}

	// Testcase
	public static void main(String[] args) {
		Solution solution = new Solution();

		// Testcase 1
		int[] nums1 = {0,1,2,4,5,7};
		System.out.println(solution.summaryRanges(nums1));

		// Testcase 2
		int[] nums2 = {0,2,3,4,6,8,9};
		System.out.println(solution.summaryRanges(nums2));
	}
}