/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-06-21 11:21:40
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

//input: two String s and t
//output: boolean, true if t is re-generate of s

import java.util.HashMap;
import java.util.Map;

public class Solution{
    public boolean isAnagram (String s, String t){

        // check if the length of t not equal of s, return false
        if (s.length() != t.length()) return false;

        // Create a Hashmap to store the count of each character in s
        Map<Character, Integer> charCount = new HashMap<>();

        // iterate over each char of s
        for (char c: s.toCharArray()){
             // increment the count of the character in the map
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);

        }

        // iterate over each char of t
        for (char c : t.toCharArray()){
            if (charCount.containsKey(c) && charCount.get(c) > 0){
                // decrease the count of the character in the map
                charCount.put(c, charCount.get(c) - 1);
            } else {
                // return false if character not exit of not enough value
                return false;
            }
        }

        // return true if all check pass
        return true;
    }
}