/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-06-13 11:17:24
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

// input: a pattern and a string s
// output: boolean if full match of s follows the same pattern

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean wordPattern(String pattern, String s){
        // split the input string s
        String[] words = s.split("\\s+");

        // check length of pattern character and number of words in s
        // if not same -> return false
        if (words.length != pattern.length()) return false;

        // create map character from pattern to words of s and vice versa
        Map<Character, String> patternToWord = new HashMap<>();
        Map<String, Character> wordToPattern = new HashMap<>();

        // iterate through each character of pattern and word in s
        for (int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            String word = words[i];

            // check if the current c is already mapping
            if (patternToWord.containsKey(c)){
                if (!patternToWord.get(c).equals(word)) return false;
            } else {
                patternToWord.put(c, word);
            }

            // check if the current word is already mapping
            if (wordToPattern.containsKey(word)){
                if (wordToPattern.get(word) != c) return false;
            } else {
                wordToPattern.put(word, c);
            }
        }

        // if every character in pattern mapping valid with word in String s
        return true;
    }
}