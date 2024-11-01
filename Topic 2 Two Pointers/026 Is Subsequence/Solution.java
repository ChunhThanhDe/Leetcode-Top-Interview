public class Solution {
    public boolean isSubsequence(String s, String t) {
        // initialize two pointers, i for 's' and j for 't'
        int i = 0;
        int j = 0;

        // loop until we reach the end of either string
        while (i < s.length() && j < t.length()) {
            // check if the characters at i and j are equal
            if (s.charAt(i) == t.charAt(j)) {
                i++; // move the pointer 'i' to the next character in 's'
            }
            j++; // move the pointer 'j' to the next character in 't'
        }

        // if 'i' has reach the end of 's', all character in s were found in 't' order
        // 's' is a subsequence of 't'
        return i == s.length();
    }
}