/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-07-22 08:04:11
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

// input: an array `nums` and an integer `k`
// output: boolean, true if indies `i`, `j`
// nums[i] == nums[j]
// abs(i - j) <= k

import java.util.HashMap;
import java.util.Map;

public class  Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k){

    // Hashmap to store value and index of element in nums
    Map<Integer, Integer> map = new HashMap<>();

    // Iterate each element in nums
    for (int i = 0; i < nums.length; i ++){
      // check if has element duplicate in map
      if (map.containsKey(nums[i])){
        // if abs of duplicate elements <= k return true
        if (i - map.get(nums[i]) <= k) {
          return true;
        }
      }

      // add element in map if not exist or update value element
      map.put(nums[i], i);
    }

    // return false if no two duplicate value satisfied
    return false;
  }
}