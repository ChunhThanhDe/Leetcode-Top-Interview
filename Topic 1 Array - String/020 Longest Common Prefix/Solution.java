/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-05-24 16:20:41
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

class Solution{
    public String longestCommonPrefix(String[] strs){
        // Check if the input array is empty; if so, return an empty string.
        if (strs.length == 0){
            return "";
        }

        // initialize variable to keep prefix as the first string in the array.
        String prefix = strs[0];

        // loop through the remaining strings in the array
        // start from second string
        for (int i = 1; i < strs.length; i++){
            // while the current string does not start with the prefix
            // we need to shorten the prefix
            while (!strs[i].startsWith(prefix)) {

                //reduce the prefix by remove the last character
                prefix = prefix.substring(0, prefix.length() - 1);

                // if the prefix becomes empty, we can exit the loop early
                if (prefix.length() == 0){
                    break;
                }
            }

            if (prefix.length() == 0){
                break;
            }
        }

        // return the longest common the prefix found
        return prefix;
    }
}