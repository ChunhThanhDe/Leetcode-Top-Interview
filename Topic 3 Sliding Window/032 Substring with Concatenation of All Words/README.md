## 30. Substring with Concatenation of All Words 🌐

**Difficulty**: `Hard` - **Tags**: `String`, `Hash Table`, `Sliding Window`

[LeetCode Problem Link](https://leetcode.com/problems/substring-with-concatenation-of-all-words/)

### Problem Statement 📜

You are given a string `s` and an array of strings `words`. All the strings of `words` are of the same length.

A concatenated string is a string that exactly contains all the strings of any permutation of `words` concatenated.

Return an array of the starting indices of all the concatenated substrings in `s`. You can return the answer in any order.

### Examples 🌟

🔹 **Example 1:**

**Input:**
```python
s = "barfoothefoobarman"
words = ["foo","bar"]
```

**Output:**
```
[0,9]
```

**Explanation:**
- The substring starting at 0 is "barfoo". It is the concatenation of `["bar","foo"]` which is a permutation of `words`.
- The substring starting at 9 is "foobar". It is the concatenation of `["foo","bar"]` which is a permutation of `words`.

🔹 **Example 2:**

**Input:**
```python
s = "wordgoodgoodgoodbestword"
words = ["word","good","best","word"]
```

**Output:**
```
[]
```

**Explanation:**
There is no concatenated substring.

🔹 **Example 3:**

**Input:**
```python
s = "barfoofoobarthefoobarman"
words = ["bar","foo","the"]
```

**Output:**
```
[6,9,12]
```

**Explanation:**
- The substring starting at 6 is "foobarthe". It is the concatenation of `["foo","bar","the"]`.
- The substring starting at 9 is "barthefoo". It is the concatenation of `["bar","the","foo"]`.
- The substring starting at 12 is "thefoobar". It is the concatenation of `["the","foo","bar"]`.

### Constraints ⚙️

- `1 <= s.length <= 10^4`
- `1 <= words.length <= 5000`
- `1 <= words[i].length <= 30`
- `s` and `words[i]` consist of lowercase English letters.

### Solution 💡

To solve this problem, we can use a **Sliding Window** approach with a **Hash Table** to keep track of the count of each word in `words`.

1. **Calculate Word Lengths**:
   - Since all words in `words` are the same length, we can calculate the total length of concatenated words and use it to limit our sliding window.

2. **Create a Dictionary for Words**:
   - Create a `wordCount` dictionary to count occurrences of each word in `words`.

3. **Slide Over Substrings**:
   - Use a sliding window approach across `s`, iterating for each possible starting position to cover all possible concatenations.
   - For each substring in the current window, check if it matches the count in `wordCount`.

4. **Verify and Store Results**:
   - If the substring contains all words with matching frequencies, store the starting index.

#### Java Solution

```java
import java.util.*;

class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        // Map to store the frequency of each word in `words`
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.merge(word, 1, Integer::sum);
        }

        int strLength = s.length();
        int wordsCount = words.length;
        int wordLength = words[0].length();
        List<Integer> indices = new ArrayList<>();

        // Iterate over possible start indices within a word length
        for (int i = 0; i < wordLength; i++) {

            Map<String, Integer> currentCount = new HashMap<>();
            int left = i, right = i;
            int totalWords = 0;

            // Slide the window through the string
            while (right + wordLength <= strLength) {
                // Extract the current word from the string
                String sub = s.substring(right, right + wordLength);
                right += wordLength;
                // If the word is not in `wordCount`, reset the window
                if (!wordCount.containsKey(sub)) {
                    currentCount.clear();
                    left = right;
                    totalWords = 0;
                    continue;
                }

                // Increment the count of the current word in `currentCount`
                currentCount.merge(sub, 1, Integer::sum);
                ++totalWords;

                // If a word's count exceeds the allowed frequency, shrink the window
                while (currentCount.get(sub) > wordCount.get(sub)) {
                    String removed = s.substring(left, left + wordLength);
                    left += wordLength;
                    currentCount.merge(removed, -1, Integer::sum);
                    --totalWords;
                }

                // If the window contains all words exactly once, record the starting index
                if (totalWords == wordsCount) {
                    indices.add(left);
                }
            }
        }
        return indices; // Return the list of starting indices
    }
}

```

### Time Complexity ⏳

- **O(N * M)**: Where `N` is the length of `s` and `M` is the total length of the words in `words`. We check each possible substring of length `totalLength` in `s`.

### Space Complexity 💾

- **O(W)**: Where `W` is the number of unique words in `words`, for storing them in `wordCount` and `seenWords` hash maps.

You can find the full solution [here](Solution.java) and another solution [here](BadSolution.java) but it Time Limit Exceeded 😢.