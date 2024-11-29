## 383. Ransom Note 🔍

**Difficulty**: `Easy` - **Tags**: `Hash Table`, `String`

[LeetCode Problem Link](https://leetcode.com/problems/ransom-note/)

---

### Problem Statement 📜

Given two strings `ransomNote` and `magazine`, return `true` if `ransomNote` can be constructed by using the letters from `magazine` and `false` otherwise.

Each letter in `magazine` can only be used once in `ransomNote`.

---

### Examples 🌟

🔹 **Example 1:**

**Input:**
```plaintext
ransomNote = "a", magazine = "b"
```

**Output:**
```plaintext
false
```

🔹 **Example 2:**

**Input:**
```plaintext
ransomNote = "aa", magazine = "ab"
```

**Output:**
```plaintext
false
```

🔹 **Example 3:**

**Input:**
```plaintext
ransomNote = "aa", magazine = "aab"
```

**Output:**
```plaintext
true
```

---

### Constraints ⚙️

- `1 <= ransomNote.length, magazine.length <= 10^5`
- `ransomNote` and `magazine` consist of lowercase English letters.

---

### Solution 💡

To solve this problem, we can use a hash map to count the occurrences of each character in `magazine`. Then, we check if each character in `ransomNote` can be satisfied using the character counts.

---

#### Java Solution

```java
import java.util.HashMap;
import java.util.Map;

class Solution1 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        // Count characters in magazine
        for (char c : magazine.toCharArray()) {
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }

        // Check if ransomNote can be formed
        for (char c : ransomNote.toCharArray()) {
            if (charCountMap.containsKey(c) && charCountMap.get(c) > 0) {
                charCountMap.put(c, charCountMap.get(c) - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
```

---

### Explanation of the Solution

1. **Count Characters in Magazine**:
   - Use a `HashMap` to store the frequency of each character in `magazine`.

2. **Validate Ransom Note**:
   - Iterate through `ransomNote` and check if the required character is available in the `HashMap` with a count greater than 0.
   - If available, decrement the count. If not, return `false`.

3. **Result**:
   - If all characters in `ransomNote` are satisfied, return `true`.

---

### Time Complexity ⏳

- **O(m + n)**:
  - `m` is the length of `ransomNote`.
  - `n` is the length of `magazine`.
  - Both strings are traversed once.

### Space Complexity 💾

- **O(k)**:
  - `k` is the number of unique characters in `magazine`.
  - Space used by the `HashMap`.


You can find the full solution [here](Solution.java).
