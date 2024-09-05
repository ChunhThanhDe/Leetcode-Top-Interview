public class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 1;

        // Because the number of majority elements is greater than n/2, the count of that element will always be greater than 0
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
                count = 1;
            } else if (nums[i] == majority) {
                count++;
            } else {
                count--;
            }
        }

        return majority;
    }
}