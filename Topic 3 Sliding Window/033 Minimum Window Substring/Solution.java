// Input: Two strings `s` and `t`
// output: Minium window substring in `s` containing all characters of `t`
// if no valid window exit, return an empty string

import java.util.*;

public class Solution{

    public String minWindow(String s, String t){
        // if input String is valid or `s` is shorter than `t`, return empty string
        if (s == null || t == null || s.length() < t.length()) return "";

        // map to store th frequency of each character in `t`
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        // `required` stores the m=number of unique characters in `t` to be matched
        int required = tMap.size();

        // Initialize pointers for the sliding window and the count of formed characters
        int left = 0, right = 0;
        int formed = 0;

        // Map to store the frequency of characters in the current window.
        Map<Character, Integer> windowCounts = new HashMap<>();

        // Map to store the result: length, start index, end index of the minimum window
        int[] ans = {-1, 0, 0};

        // Expand the window by moving the `right` pointer
        while (right < s.length()){
            char c = s.charAt(right);

            // update the count of the current character in the window.
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            // if the current character's count matches its count in `t`
            // increment `formed`
            if (tMap.containsKey(c) && windowCounts.get(c).intValue() ==
                    tMap.get(c).intValue()){
                formed ++;
            }

            // Contract the window by moving the `left` pointer when all required character
            // are matched
            while (left <= right && formed == required) {
                c = s.charAt(left);

                // update the result if the current window is smaller than the previously
                if (ans[0] == -1 || right - left + 1 < ans[0]){
                    ans[0] = right - left + 1; // update window length
                    ans[1] = left;             // update start index
                    ans[2] = right;            // update end index
                }

                // remove the character at the left pointer from the window
                windowCounts.put(c, windowCounts.get(c) - 1);

                // if the count of the character becomes less than its required count,
                // decrement `formed`
                if (tMap.containsKey(c) && windowCounts.get(c).intValue() < tMap.get(c).intValue()){
                    formed --;
                }

                // Move the `left` pointer to shrink the window
                left++;
            }

            // Move the `right pointer to expand the window
            right++;

        }

        // if no valid window is found, return an empty string.
        // Otherwise, return the substring
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);

    }
}