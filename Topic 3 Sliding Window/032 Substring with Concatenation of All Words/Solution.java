// Input: String `s` and array `words` (all words have the same length)
// Output: List of starting indices of all concatenated substrings in `s`
//         if s == null or s.length() == 0 -> return []

import java.util.*;

class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        // Map to store the frequency of each word in `words`
        Map<String, Integer> wordsCountMap = new HashMap<>();

        // Populate the `wordsCountMap` map with word frequencies
        for (String word : words) {
            wordsCountMap.merge(word, 1, Integer::sum); // Increment count of each word
        }

        int strLength = s.length(); // Length of the input string
        int wordsCount = words.length; // Total number of words
        int wordLength = words[0].length(); // Length of each word
        List<Integer> indices = new ArrayList<>(); // List to store valid starting indices - result

        // Iterate over possible start indices within a word length
        for (int i = 0; i < wordLength; i++) {
            // Map to track current word counts in the sliding window
            Map<String, Integer> currentCount = new HashMap<>();
            int left = i, right = i; // Initialize sliding window pointers
            int totalWords = 0; // Number of valid words in the current window

            // Slide the window through the string
            while (right + wordLength <= strLength) {
                // Extract the current word from the string
                String sub = s.substring(right, right + wordLength);
                right += wordLength; // Move the right pointer

                // If the word is not in `wordsCountMap`, reset the window
                if (!wordsCountMap.containsKey(sub)) {
                    currentCount.clear(); // Clear the current window count
                    left = right; // Move left pointer to the new starting position
                    totalWords = 0; // Reset total valid words count
                    continue;
                }

                // Increment the count of the current word in `currentCount`
                currentCount.merge(sub, 1, Integer::sum);
                totalWords++; // Increment the total words count in the window

                // If a word's count exceeds the allowed frequency, shrink the window
                while (currentCount.get(sub) > wordsCountMap.get(sub)) {
                    String removed = s.substring(left, left + wordLength); // Word to remove
                    left += wordLength; // Move the left pointer forward
                    currentCount.merge(removed, -1, Integer::sum); // Decrease count of the removed word
                    totalWords--; // Decrease total valid words count
                }

                // If the window contains all words exactly once, record the starting index
                if (totalWords == wordsCount) {
                    indices.add(left); // Add the left pointer to the result
                }
            }
        }
        return indices; // Return the list of starting indices
    }
}
