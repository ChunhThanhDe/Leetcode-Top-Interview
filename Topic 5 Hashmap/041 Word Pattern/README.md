## 205. Isomorphic Strings 🧩

**Difficulty**: `Easy` - **Tags**: `Hash Table`, `String`

[LeetCode Problem Link](https://leetcode.com/problems/isomorphich-strings/)

---

### Problem Statement 📜

Given a `pattern` and a string `s`, find if `s` follows the same `pattern`.

Here "follow" means a full match, such that there is a bijection between a letter in `pattern` and a non-empty word in `s`.

---

### Examples 🌟

🔹 **Example 1:**

**Input:**
```plaintext
pattern = "abba", s = "dog cat cat dog"
```

**Output:**
```plaintext
true
```

🔹 **Example 2:**

**Input:**
```plaintext
pattern = "abba", s = "dog cat cat fish"
```

**Output:**
```plaintext
false
```

🔹 **Example 3:**

**Input:**
```plaintext
pattern = "aaaa", s = "dog cat cat dog"
```

**Output:**
```plaintext
false
```

---

### Constraints ⚙️

- `1 <= pattern.length <= 300`
- `pattern` contains only lower-case English letters.
- `1 <= s.length <= 3000`
- `s` contains only lowercase English letters and spaces `' '`.
- `s` does not contain any leading or trailing spaces.
- All the words in `s` are separated by a single space.

---

### Solution 💡

To determine if `s` follows the same pattern, we need to ensure that there is a one-to-one correspondence between the characters of `pattern` and the words in `s`. We can use two hash maps for this purpose:

1. One map to store the pattern's character to word mapping.
2. Another map to store the word to pattern's character mapping.

---

#### Java Solution

```java
import java.util.HashMap;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) return false;

        Map<Character, String> patternToWord = new HashMap<>();
        Map<String, Character> wordToPattern = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (patternToWord.containsKey(c)) {
                if (!patternToWord.get(c).equals(word)) {
                    return false;
                }
            } else {
                patternToWord.put(c, word);
            }

            if (wordToPattern.containsKey(word)) {
                if (wordToPattern.get(word) != c) {
                    return false;
                }
            } else {
                wordToPattern.put(word, c);
            }
        }

        return true;
    }
}
```

---

### Explanation of the Solution

1. **Splitting the Input String**:
   - We split `s` by spaces to get an array of words.

2. **Checking Lengths**:
   - If the length of `pattern` doesn't match the number of words in `s`, return `false`.

3. **Mapping Characters to Words**:
   - We use two hash maps:
     - `patternToWord` to map characters in `pattern` to words in `s`.
     - `wordToPattern` to map words in `s` to characters in `pattern`.

4. **Validation**:
   - For each character and corresponding word, we check if the current mapping exists.
   - If it exists and doesn't match the expected value, return `false`.
   - If a valid mapping exists, continue checking until all characters and words are validated.

5. **Return True**:
   - If all the mappings are consistent, return `true`.

---

### Time Complexity ⏳

- **O(n)**:
  - `n` is the length of the pattern (or the number of words in `s`).
  - Each character and word is processed once.

### Space Complexity 💾

- **O(n)**:
  - Space is used for two hash maps, each storing up to `n` entries.


You can find the full solution [here](Solution.java).