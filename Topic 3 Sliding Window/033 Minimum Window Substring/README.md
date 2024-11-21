## 76. Minimum Window Substring 🌐

**Difficulty**: `Hard` - **Tags**: `String`, `Sliding Window`, `Hash Table`

[LeetCode Problem Link](https://leetcode.com/problems/minimum-window-substring/)

### Problem Statement 📜

Given two strings `s` and `t`, return the minimum window substring of `s` such that every character in `t` (including duplicates) is included in the window. If no such substring exists, return the empty string `""`.

### Examples 🌟

🔹 **Example 1:**

**Input:**
```python
s = "ADOBECODEBANC"
t = "ABC"
```

**Output:**
```
"BANC"
```

**Explanation:**
The substring "BANC" is the smallest window in `s` that contains all the characters of `t`.

🔹 **Example 2:**

**Input:**
```python
s = "a"
t = "a"
```

**Output:**
```
"a"
```

**Explanation:**
The entire string `s` is the minimum window.

🔹 **Example 3:**

**Input:**
```python
s = "a"
t = "aa"
```

**Output:**
```
""
```

**Explanation:**
Both 'a's from `t` must be included in the window. Since `s` only has one 'a', there is no valid substring.

### Constraints ⚙️

- `1 <= m, n <= 10^5` where `m` is the length of `s` and `n` is the length of `t`.
- `s` and `t` consist of uppercase and lowercase English letters.

🤔 **Follow-up:** Could you solve the problem in `O(m + n)` time?

---

### Solution 💡

To solve this problem efficiently, we use the **Sliding Window** technique with two pointers and a frequency counter:

1. **Count Frequencies**:
   - Use a hash map to count the frequency of characters in `t`.

2. **Sliding Window**:
   - Expand the window by moving the right pointer until all characters in `t` are included in the current window.
   - Shrink the window from the left while maintaining the validity of the window, and update the result if the current window is smaller.

3. **Track Validity**:
   - Use a counter to track how many unique characters from `t` have been fully matched in the current window.

4. **Return Result**:
   - If no valid window is found, return `""`. Otherwise, return the smallest valid window.

#### Java Solution

```java
import java.util.*;

public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int required = tMap.size();
        int left = 0, right = 0;
        int formed = 0;
        Map<Character, Integer> windowCounts = new HashMap<>();

        int[] ans = {-1, 0, 0}; // Length, Left, Right

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (tMap.containsKey(c) && windowCounts.get(c).intValue() == tMap.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                c = s.charAt(left);

                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (tMap.containsKey(c) && windowCounts.get(c).intValue() < tMap.get(c).intValue()) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
```

---

### Time Complexity ⏳

- **O(m + n)**:
  - Traversing the string `s` takes `O(m)`.
  - Updating the frequency hash maps and shrinking the window is linear relative to the size of `s` and `t`.

### Space Complexity 💾

- **O(n)**:
  - Hash maps are used to store the frequencies of characters in `t` and the sliding window.

You can find the full solution [here](Solution.java).