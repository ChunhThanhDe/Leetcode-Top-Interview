public class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            // If maxReach < i, it will not be possible to jump over i, so break
            if (i > maxReach) {
                break;
            }

            // This algorithm is to find the farthest point that can be jumped
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) return true;
        }

        return maxReach >= nums.length - 1;
    }
}