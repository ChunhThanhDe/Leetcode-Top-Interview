/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-06-12 17:19:26
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

// input: two String s and t
// output: true if s can be replaced to get t, false otherwise
// note:
//  - Each character in s can be mapped to a unique character in t with the same order.

import java.util.HashMap;
import java.util.Map;

public class Solution{
    public boolean isIsomorphic(String s, String t){
        // check length of both
        // if not the same, they cannot be isomorphic
        if(s.length() != t.length()) return false;

        // Map to store the character mapping from s to t and t to s
        Map<Character, Character> sToMapping = new HashMap<>();
        Map<Character, Character> tToMapping = new HashMap<>();

        // iterate over each character in both string
        for (int i = 0; i < s.length(); i ++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            // check if there is already a mapping from sChar to tChar
            if (sToMapping.containsKey(sChar)){
                if (sToMapping.get(sChar) != tChar) return false; // if exits mapping but doesn't match. return false
            } else {
                // if no mapping, create new
                sToMapping.put(sChar, tChar);
            }

            // check if there is already a mapping from tchar to sChar
            if (tToMapping.containsKey(tChar)){
                if (tToMapping.get(tChar) != sChar) return false; // if exits mapping but doesn't match. return false
            } else {
                // if no mapping, create new
                tToMapping.put(tChar, sChar);
            }
        }

        // return true if all character mapping valid
        return true;

    }
}