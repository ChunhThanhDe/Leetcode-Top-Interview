class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int currentJumpEnd = 0;
        int maxReach = 0;
        int jumps = 0;

        for (int i = 0; i < n - 1; i++) {
            // i is the point to jump to

            // find the best jumping pair i j with the value of num[i], 
            // the best jumping pair is the pair that will cover all values of other jumping pairs
            
            // If maxReach is larger, it shows that the old jump point covers 
            // the entire jump distance including the new jump point

            // if i + nums[i] is larger, it shows a new way to jum best
            maxReach = Math.max(maxReach, i + nums[i]);

            // if maxReach out to length is the final jump
            if (maxReach >= n - 1) {
                jumps++;
                break;
            }

            // if point to jump == currentJumpEnd -> There is no better jump point than 
            // the current jump point, proceed to jump
            if (i == currentJumpEnd) {
                currentJumpEnd = maxReach;
                jumps++;
            }
        }

        return jumps;
    }
}