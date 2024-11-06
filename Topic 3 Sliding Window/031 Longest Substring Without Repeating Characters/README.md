## 3. Longest Substring Without Repeating Characters 🌐

**Difficulty**: `Medium` - **Tags**: `Hash Table`, `String`, `Sliding Window`

[LeetCode Problem Link](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

### Problem Statement 📜

Given a string `s`, find the length of the longest substring without repeating characters.

### Examples 🌟

🔹 **Example 1:**

**Input:**
```python
s = "abcabcbb"
```

**Output:**
```
3
```

**Explanation:**
The answer is "abc", with the length of 3.

🔹 **Example 2:**

**Input:**
```python
s = "bbbbb"
```

**Output:**
```
1
```

**Explanation:**
The answer is "b", with the length of 1.

🔹 **Example 3:**

**Input:**
```python
s = "pwwkew"
```

**Output:**
```
3
```

**Explanation:**
The answer is "wke", with the length of 3. Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

### Constraints ⚙️

- `0 <= s.length <= 5 * 10^4`
- `s` consists of English letters, digits, symbols, and spaces.

### Solution 💡

To solve this problem, we can use the **Sliding Window** approach:

1. **Use a Set**: Utilize a `HashSet` to track characters in the current window.
2. **Expand and Shrink the Window**:
   - Expand the `right` pointer to include characters in the window.
   - If a duplicate character is found, shrink the window from the left until the window contains no duplicate characters.
3. **Update the Result**:
   - Keep track of the maximum length of valid substrings.

#### Java Solution

```java
import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> charSet = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
```

### Time Complexity ⏳

- **O(n)**: Each character is processed at most twice (once added, once removed).

### Space Complexity 💾

- **O(min(n, m))**: Space used by the `HashSet`, bounded by the size of the input `n` and the size of the character set `m`.

You can find the full solution [here](Solution.java).
