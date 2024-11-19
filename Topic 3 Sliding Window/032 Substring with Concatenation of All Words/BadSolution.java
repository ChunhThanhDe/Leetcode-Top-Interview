// input: String `s` and array strings `words` with same length in all the string (may be empty)
// output: array index of all concatenated in `s`

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BadSolution {
    public List<Integer> findSubstring (String s, String [] words){
        List<Integer> result = new ArrayList<>();

        //  check for edge cases: empty input or empty words array
        if (s == null || s.length() == 0 || words.length == 0 || words[0].length() == 0){
            return result;
        }

        // calculate word length, number of words, and total length
        // of all concatenated words
        int wordLength = words[0].length();
        int wordsCount = words.length;
        int totalLength = wordLength * wordsCount;

        // Map to store the frequency of each word in the array
        Map<String, Integer> wordsCountMap = new HashMap<>();
        for (String word : words){
            wordsCountMap.put(word, wordsCountMap.getOrDefault(word, 0) + 1);
        }

        // iterate through the String to check each possible index
        // for a valid concatenated substring
        for (int i = 0; i <= s.length() - totalLength; i ++){
            //map to track word counts within the current substring
            Map<String, Integer> seenWords = new HashMap<>();
            int j = 0;

            // try to match each word in `words` to a part of the string starting at index
            while (j < wordsCount){
                // calculate the staring index of the next word in the substring
                int startIndex = i + j * wordLength;

                // Extract the substring that matches the length of one word
                String part = s.substring(startIndex,startIndex + wordLength);

                // if the part does not exist in `wordCountMap`, it is not a valid word
                if (!wordsCountMap.containsKey(part)) break;

                // update the count of the current word in the `seenWords` map
                seenWords.put(part, seenWords.getOrDefault(part, 0) + 1);

                // if a word appears more times than expected, break the loop
                if (seenWords.get(part) > wordsCountMap.get(part)) break;

                // Move to the next word
                j++;

            }

            // if `j` equals `wordCount`, a valid substring is found, so add `i` to the result
            if (j == wordsCount) result.add(i);

        }

        // return the list of starting indices of valid substrings
        return result;
    }
}