/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-05-24 16:20:41
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

class Solution {
    // function to reverse the words in a given string
    public String reverseWords(String s){
        // remove spaces that appear at the beginning and end of the string
        String trimmedString = s.trim();

        // convert the trimmed string into an array of words,
        // splitting by one of more whitespace characters.
        String[] words = trimmedString.split("\\s+");

        // initialize a StringBuilder to construct the reversed string.
        StringBuilder reversedString = new StringBuilder();

        // loop through the array of words in the reverse order
        for (int i = words.length - 1; i >= 0; i --){
            reversedString.append(words[i]);

            // if we are not at the first word, add a space after the word.
            if (i > 0){
                reversedString.append(" ");
            }
        }

        // return the final reversed string as a regular String.
        return reversedString.toString();

    }
}