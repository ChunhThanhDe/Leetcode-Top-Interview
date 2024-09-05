class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Initialize a set to store unique characters and a variable to keep track of the longest substring length
        Set<Character> uniqueChars = new HashSet<>();
        int maxLength = 0;
        
        // Initialize two pointers, left and right, to track the current substring
        int left = 0;
        int right = 0;
        
        // Iterate through the string
        while (right < s.length()) {
            // If the current character is not in the set, add it to the set and update the max length
            if (!uniqueChars.contains(s.charAt(right))) {
                uniqueChars.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            }
            // If the current character is in the set, remove the leftmost character from the set and move the left pointer
            else {
                uniqueChars.remove(s.charAt(left));
                left++;
            }
        }
        
        return maxLength;

    }
}