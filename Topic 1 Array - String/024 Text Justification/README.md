## 68. Text Justification 🔄

**Difficulty**: `Hard` - **Tags**: `String`, `Greedy`

[LeetCode Problem Link](https://leetcode.com/problems/text-justification/)

### Description

Given an array of strings `words` and a width `maxWidth`, format the text such that each line has exactly `maxWidth` characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces `' '` when necessary so that each line has exactly `maxWidth` characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left-justified, and no extra space is inserted between words.

### Examples

**Example 1:**

Input:
```python
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
```

Output:
```
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
```

**Example 2:**

Input:
```python
words = ["What","must","be","acknowledgment","shall","be"]
maxWidth = 16
```

Output:
```
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
```

Explanation:  
Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.

**Example 3:**

Input:
```python
words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"]
maxWidth = 20
```

Output:
```
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]
```

### Constraints

- The input array `words` contains at least one word.
- Each word's length is guaranteed to be greater than 0 and not exceed `maxWidth`.

---

### Solution 💡

In this solution, we use a greedy approach to pack words into each line, ensuring that the line length does not exceed `maxWidth`. When the line is full, we justify the text by adding extra spaces between words. If the line contains only one word, we pad the remaining space with spaces.

#### Java

```java
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        int i = 0; // Index to track current word position

        List<String> result = new ArrayList<>();

        // Process the words in groups that can fit on one line
        while (i < n) {
            int lineLength = words[i].length();
            int last = i + 1; // Track the position of the next word

            while (last < n && lineLength + 1 + words[last].length() <= maxWidth) {
                lineLength += 1 + words[last].length(); 
                last++;
            }

            StringBuilder sb = new StringBuilder(); 
            int wordCount = last - i;

            if (last == n || wordCount == 1) {
                for (int j = i; j < last; j++) {
                    sb.append(words[j]); // Append each word to the line
                    if (j < last - 1) sb.append(" "); // Add a single space between words
                }
                sb.append(" ".repeat(maxWidth - sb.length()));
            } else {
    
                int totalSpaces = maxWidth - lineLength + wordCount - 1; // Extra space to fill
                int spaceBetween = totalSpaces / (wordCount - 1); // Base number of spaces between words
                int extraSpaces = totalSpaces % (wordCount - 1); // Extra spaces to distribute evenly

                for (int j = i; j < last - 1; j++) {
                    sb.append(words[j]); // Append each word
                    // Add spaces: some words get an extra if extraSpaces > 0
                    sb.append(" ".repeat(spaceBetween + (extraSpaces-- > 0 ? 1 : 0)));
                }
                sb.append(words[last - 1]); // Add the last word in the line without extra space after it
            }

            result.add(sb.toString()); // Add the fully justified line to the result
            i = last; // Move to the next set of words
        }

        return result; // Return the list of justified lines
    }
}
```

#### Time Complexity ⏳

- **O(n)**: We iterate through the list of words once, processing each word in constant time to fit it into a line.

#### Space Complexity 💾

- **O(n)**: The space complexity is linear, where `n` is the total number of characters in the input list of words and in the result.

You can find the full solution [here](Solution.java).
