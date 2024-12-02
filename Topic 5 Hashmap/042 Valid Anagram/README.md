## 242. Valid Anagram 🎢

**Difficulty**: `Easy` - **Tags**: `Hash Table`, `String`, `Sorting`

[LeetCode Problem Link](https://leetcode.com/problems/valid-anagram/)

---

### Problem Statement 📜

Given two strings `s` and `t`, determine if `t` is an anagram of `s`. An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, using all the original letters exactly once.

---

### Examples 🌟

🔹 **Example 1:**

**Input:**
```plaintext
s = "anagram", t = "nagaram"
```

**Output:**
```plaintext
true
```

🔹 **Example 2:**

**Input:**
```plaintext
s = "rat", t = "car"
```

**Output:**
```plaintext
false
```

---

### Constraints ⚙️

- `1 <= s.length, t.length <= 5 * 10^4`
- `s` and `t` consist of lowercase English letters.

---

### Solution 💡

The simplest way to check if two strings are anagrams is to compare their sorted versions. Alternatively, we can use a frequency count for more efficiency.

---

#### Java Solution (Sorting Approach)

```java
import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);
    }
}
```

---

#### Java Solution (HashMap Approach)

```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!charCount.containsKey(c) || charCount.get(c) == 0) {
                return false;
            }
            charCount.put(c, charCount.get(c) - 1);
        }

        return true;
    }
}
```

---

### Explanation of the Solution

1. **Sorting Approach**:
   - Convert both strings to character arrays.
   - Sort the arrays.
   - Compare the sorted arrays for equality.

2. **HashMap Approach**:
   - Count the frequency of each character in `s` using a `HashMap`.
   - For each character in `t`, decrement its count in the map.
   - If a character in `t` is missing or its count goes below zero, return `false`.

---

### Time Complexity ⏳

- **Sorting Approach**:
  - **O(n log n)** for sorting, where `n` is the length of the strings.

- **HashMap Approach**:
  - **O(n)** for iterating through the strings.

### Space Complexity 💾

- **Sorting Approach**:
  - **O(n)** for storing the sorted arrays.

- **HashMap Approach**:
  - **O(1)** space for the map (since there are only 26 lowercase English letters).

You can find the full solution [here](Solution.java).