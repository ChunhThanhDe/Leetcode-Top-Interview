/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-05-24 16:20:41
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

public class Solution {
    public boolean isPalindrome(String s) {
        // step 1: filter out non-alphanumeric character and convert to lowercase for
        // uniform comparison
        StringBuilder filteredStr = new StringBuilder();
        for (char c : s.toCharArray()) {
            // check if character is alphanumeric (letter of digit)
            if (Character.isLetterOrDigit(c)) {
                // convert to lowercase and append
                filteredStr.append(Character.toLowerCase(c));
            }
        }

        // step 2: Apply the two-pointer technique to check if the filtered string is a
        // palindrome
        // initialize two pointers at the start and end
        int left = 0;
        int right = filteredStr.length() - 1;

        while (left < right) {
            // if the characters at left and right pointer don't match. it not a palindrome
            if (filteredStr.charAt(left) != filteredStr.charAt(right)) {
                return false;
            }
            // move left and right pointer
            left++;
            right--;
        }

        // if all characters match, filtered Sting is a palindrome
        return true;
    }
}