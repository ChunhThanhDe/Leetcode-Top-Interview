/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-05-24 16:20:41
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

class Solution {
    // Function to find the length of the last word in the given String
    public int lengthOfLastWord(String s){
        //Trim leading and trailing whitespace from the input string
        String trimmedString =  s.trim();

        // initialize a variable to keep track of the length of the last work
        int length = 0;

        // loop through the trim string from the end to the beginning.
        // we start at the last character and move backwards
        for (int i = trimmedString.length() - 1; i >= 0; i --){
            if (trimmedString.charAt(i) == ' '){
                // if we encounter a space
                // it mean we are finished counting the last word
                break;
            }

            // if it is not a space, increment the length counter
            length ++;
        }

        // return the calculate length of the last word
        return length;

    }
}