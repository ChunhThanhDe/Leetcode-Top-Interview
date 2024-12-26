/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-12-11 07:54:43
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

// input: unsorted array integer `nums`
// output: integer of longest consecutive elements sequence

import java.util.HashSet;
import java.util.Set;

public class Solution{
    public int longestConsecutive(int[] nums) {

        // check if nums empty
        if (nums.length == 0) return  0;

        // Use HashSet to store al element of nums for lockup
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums){
            numsSet.add(num);
        }

        // initialize variable to store the maximum of steak length
        int longestSteak = 0;

        // iterate through each element in the set
        for (int num : numsSet){
            // check if num is a first element of steak
            if (!numsSet.contains(num - 1)){
                int currentNum = num; // Start of the Sequence
                int currentStreak = 1; // Length of the current steak


                // count the current steak
                while (numsSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                // Update the longestSteak if found so far
                longestSteak = Math.max(longestSteak, currentStreak);
            }
        }

        return longestSteak;

    }

    // Testcase
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] test1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Test 1: " + solution.longestConsecutive(test1)); // Output: 4

        // Test case 2
        int[] test2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Test 2: " + solution.longestConsecutive(test2)); // Output: 9

    }
}
