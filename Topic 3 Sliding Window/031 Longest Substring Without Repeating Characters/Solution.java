// input: a string 's'
// output: length of the longest substring without repeating characters

import java.util.HashSet;

public class Solution{
    public int lengthOfLongestSubstring(String s){

        // Use a HashSet to store unique characters in the current substring
        HashSet<Character> charSet = new HashSet<>();
        // Initialize two pointer and a variable for the maximum length
        int left = 0;
        int right = 0;
        int maxLength = 0;

        // Iterate through the string with the right pointer
        for (right = 0; right < s.length(); right ++){
            // if the character is already in the set, remove characters from the left until it's not
            while (charSet.contains(s.charAt(right))){
                charSet.remove(s.charAt(left)); // remote the leftmost character
                left++; // Move the left pointer to the right
            }

            // Add the current character to the set
            charSet.add(s.charAt(right));
            // Update the maximum length if the current substring is longer
            maxLength = Math.max(maxLength, right - left + 1);
        }

        // Return the length of the longest substring without repeating characters
        return maxLength;

    }
}