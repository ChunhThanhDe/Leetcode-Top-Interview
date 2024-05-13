class Solution {
    public static boolean isPalindrome(String s) {
        // Convert to lowercase and remove non-alphanumeric characters
        String cleanString = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        // Check if the clean string is a palindrome
        int left = 0;
        int right = cleanString.length() - 1;
        
        while (left < right) {
            if (cleanString.charAt(left) != cleanString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}