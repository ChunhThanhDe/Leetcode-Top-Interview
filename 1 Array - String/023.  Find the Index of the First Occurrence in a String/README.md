## 28. Find the Index of the First Occurrence in a String 🔄

**Difficulty**: `Easy` - **Tags**: `String`, `Two Pointers`

[LeetCode Problem Link](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/)

### Description

Given two strings `needle` and `haystack`, return the index of the first occurrence of `needle` in `haystack`, or `-1` if `needle` is not part of `haystack`.

### Examples

**Example 1:**

Input:
```python
haystack = "sadbutsad"
needle = "sad"
```

Output:
```
0
```

Explanation:
"sad" occurs at index 0 and 6. The first occurrence is at index 0, so we return 0.

**Example 2:**

Input:
```python
haystack = "leetcode"
needle = "leeto"
```

Output:
```
-1
```

Explanation:
"leeto" did not occur in "leetcode", so we return -1.

### Constraints

- The strings `haystack` and `needle` consist of lowercase English letters.

### Solution 💡

To solve this problem manually (without using built-in methods like `indexOf`), we can use a sliding window technique. We check each substring in `haystack` of the same length as `needle` and compare it with `needle`. If a match is found, return the starting index. If no match is found, return `-1`.

#### Java

```java
class Solution {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();

        // If needle is empty, return 0
        if (nLen == 0) {
            return 0;
        }

        // Loop through haystack and check substrings of length equal to needle
        for (int i = 0; i <= hLen - nLen; i++) {
            // Check if substring matches the needle
            if (haystack.substring(i, i + nLen).equals(needle)) {
                return i;
            }
        }

        // If no match is found, return -1
        return -1;
    }
}
```

#### Time Complexity ⏳

- **O(n * m)**: The time complexity is O(n * m), where `n` is the length of the `haystack` and `m` is the length of the `needle`. For each starting index in `haystack`, we compare up to `m` characters.

#### Space Complexity 💾

- **O(1)**: We only use constant space for variables, as no additional space is needed beyond the input strings.

You can find the full solution [here](Solution.java).