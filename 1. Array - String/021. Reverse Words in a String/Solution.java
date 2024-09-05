class Solution {
    public String reverseWords(String s) {

        // Removes spaces that appear at the beginning and end of the string.
        String trimmedString = s.trim();

        // Convert String to list of String separated by spaces
        String[] words = trimmedString.split("\\s+");
        
        StringBuilder reversedString = new StringBuilder();
        
        for (int i = words.length - 1; i >= 0; i--) {
            reversedString.append(words[i]);
            if (i > 0) {
                reversedString.append(" ");
            }
        }
        
        return reversedString.toString();
    }
}