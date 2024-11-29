## 205. Isomorphic Strings 🔍

**Difficulty**: `Easy` - **Tags**: `Hash Table`, `String`

[LeetCode Problem Link](https://leetcode.com/problems/isomorphic-strings/)

---

### Problem Statement 📜

Given two strings `s` and `t`, determine if they are isomorphic.

Two strings `s` and `t` are isomorphic if the characters in `s` can be replaced to get `t`.

- All occurrences of a character must be replaced with another character while preserving the order of characters.
- No two characters may map to the same character, but a character may map to itself.

---

### Examples 🌟

🔹 **Example 1:**

**Input:**
```plaintext
s = "egg", t = "add"
```

**Output:**
```plaintext
true
```

🔹 **Example 2:**

**Input:**
```plaintext
s = "foo", t = "bar"
```

**Output:**
```plaintext
false
```

🔹 **Example 3:**

**Input:**
```plaintext
s = "paper", t = "title"
```

**Output:**
```plaintext
true
```

---

### Constraints ⚙️

- `1 <= s.length <= 5 * 10^4`
- `t.length == s.length`
- `s` and `t` consist of any valid ASCII character.

---

### Solution 💡

To determine if two strings are isomorphic, we need to map characters from `s` to `t` while ensuring no two characters from `s` map to the same character in `t` (and vice versa).

---

#### Java Solution

```java
import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (sToT.containsKey(sChar)) {
                if (sToT.get(sChar) != tChar) return false;
            } else {
                sToT.put(sChar, tChar);
            }

            if (tToS.containsKey(tChar)) {
                if (tToS.get(tChar) != sChar) return false;
            } else {
                tToS.put(tChar, sChar);
            }
        }

        return true;
    }
}
```

---

### Explanation of the Solution

1. **Create Two Maps**:
   - `sToT` to map characters from `s` to `t`.
   - `tToS` to map characters from `t` to `s`.

2. **Iterate Through Both Strings**:
   - For each character in `s` and `t`:
     - Check if the mappings are consistent in both directions.
     - If not, return `false`.

3. **Result**:
   - If all character mappings are consistent, return `true`.

---

### Time Complexity ⏳

- **O(n)**:
  - `n` is the length of the strings.
  - Each character is visited once.

### Space Complexity 💾

- **O(1)**:
  - Fixed space for the hash maps since the character set is limited (ASCII).


You can find the full solution [here](Solution.java).