// input: integer array 'height' of length 'n'. representing heights of vertical lines
// output: Maximum amount of water a container can store between two lines.

public class Solution{
	public int maxArea(int[] height){

		// initialize two pointer, left at the start and right at the end of the array
		int left = 0;
		int right = height.length - 1;

		// variable to keep track the maximum amount of water found
		int maxArea = 0;

		// loop until the two pointer meet
		while (left < right){
			// calculate the area based on the shorter height and the distance between two pointer
			int area = Math.min(height[left], height[right]) * (right - left);

			// update maxArea if the new area is large
			maxArea = Math.max(area, maxArea);

			// Move the pinter at the shorter line to potentially find a larger area
			if (height[left] > height[right]){
				right --; // Move the right pointer to left if height[right] is shorter
			} else {
				left ++; // Move the left pointer to left if height[left] is shorter
			}
		}

		// return the maximum area found
		return maxArea;
	}
}