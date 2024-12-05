// input: array of integer `nums` and an Integer `target`
// output: array of two numbers such that they add up to `target`.

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum (int[] nums, int target){

        Map<Integer, Integer> map = new HashMap<>();

        // iterate the element of nums
        for (int i = 0; i < nums.length; i++){
            // check if has element + nums[i] == target
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }

            // add nums[i] value and index to map
            map.put(nums[i], i);
        }

        return new int[]{};

    }
}