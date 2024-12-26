/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-05-24 16:20:41
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

// input: an integer array
// output: list of all unique triplets [num[i], num[j], num[k]] such that num[i] + num[j]+ num[k] == 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		// list to hold the resulting triplets
		List<List<Integer>> result = new ArrayList<>();

		// soft the array to facilitate finding triplets
		Arrays.sort(nums);

		// loop through the array, stopping two elements before the end
		for (int i = 0; i < nums.length - 2; i++){
			// skip duplicate for the similar number
			if (i > 0 && nums[i] == nums[i - 1]) continue;

			// set two pointer
			// one just after the current number and the other at the end of the nums
			int left = i + 1;
			int right = nums.length - 1;

			// use two pointer to find triplet
			while (left < right){
				// Calculate the sum of the triplet
				int sum = nums[i] + nums[left] + nums[right];

				// if sum is less than zero, move the left pointer to increase the sum
				if (sum < 0) {
					left ++;
				} else if (sum > 0){
					// if the sum is greater than zero, move the right pointer to decrease the sum
					right --;
				} else {
					// if sum equal 0, we found triplet
					// add the triplet to the result list
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));

					// To avoid generating duplicate triplets in the results
					// skip duplicate for the second number
					while (left < right && nums[left] == nums[left + 1]) left++;
					// ship duplicate for the third number
					while (left < right && nums[right] == nums[right - 1]) right--;

					// Move both pointers inward
					left++;
					right--;
				}
			}
		}

		// return the list of unique triplets
		return result;
	}
}