## 49. Group Anagrams 🤹‍♂️

**Difficulty**: `Medium` - **Tags**: `Hash Table`, `String`, `Sorting`

[LeetCode Problem Link](https://leetcode.com/problems/group-anagrams/)

---

### Problem Statement 📜

Given an array of strings `strs`, group the anagrams together. An anagram is a word or phrase formed by rearranging the letters of another, using all the original letters exactly once.

The answer can be returned in any order.

---

### Examples 🌟

🔹 **Example 1:**

**Input:**
```plaintext
strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
```

**Output:**
```plaintext
[["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]
```

🔹 **Example 2:**

**Input:**
```plaintext
strs = [""]
```

**Output:**
```plaintext
[[""]]
```

🔹 **Example 3:**

**Input:**
```plaintext
strs = ["a"]
```

**Output:**
```plaintext
[["a"]]
```

---

### Constraints ⚙️

- `1 <= strs.length <= 10^4`
- `0 <= strs[i].length <= 100`
- `strs[i]` consists of lowercase English letters.

---

### Solution 💡

To group anagrams, we can use a `HashMap` where:
- The key is a representation of the sorted characters of a word.
- The value is a list of words that share the same sorted characters.

---

#### Java Solution

```java
import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            anagramMap.putIfAbsent(sortedStr, new ArrayList<>());
            anagramMap.get(sortedStr).add(str);
        }

        return new ArrayList<>(anagramMap.values());
    }
}
```

---

### Explanation of the Solution

1. **Sorting and Grouping**:
   - Convert each string to a character array, sort it, and convert it back to a string.
   - Use this sorted string as the key in a `HashMap`.
   - Add the original string to the list corresponding to this key.

2. **Result**:
   - The `HashMap` values contain grouped anagrams.
   - Return all the values as a list of lists.

---

### Time Complexity ⏳

- **O(n * k log k)**:
  - Sorting each string (`k log k`, where `k` is the max length of a string).
  - Iterating through `n` strings.

### Space Complexity 💾

- **O(n * k)**:
  - Space for the `HashMap` to store `n` strings of length `k`.

You can find the full solution [here](Solution.java).