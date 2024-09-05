public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int i = 0;
        int index = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[j - 1]) {
                index = 0;
                i++;
                nums[i] = nums[j];
            } else {
                index++;
                if (index == 1){
                    i++;
                    nums[i] = nums[j];
                }
        }
    }
        return i + 1;
    }
    
}