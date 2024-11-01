## 392. Is Subsequence 📏

**Difficulty**: `Easy` - **Tags**: `Two Pointers`, `String`

[LeetCode Problem Link](https://leetcode.com/problems/is-subsequence/)

### Problem Statement 📜

Given two strings `s` and `t`, return `true` if `s` is a subsequence of `t`, or `false` otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. For example, "ace" is a subsequence of "abcde" while "aec" is not.

### Examples 🌟

🔹 **Example 1:**

**Input:**
```python
s = "abc"
t = "ahbgdc"
```

**Output:**
```
true
```

🔹 **Example 2:**

**Input:**
```python
s = "axc"
t = "ahbgdc"
```

**Output:**
```
false
```

### Constraints ⚙️

- `0 <= s.length <= 100`
- `0 <= t.length <= 10^4`
- `s` and `t` consist only of lowercase English letters.

### Solution 💡

#### Approach 1: Two-Pointer Technique

1. **Initialize Two Pointers**: Use one pointer for each string (`i` for `s` and `j` for `t`).
2. **Traverse through `t`**: Move through the characters of `t`. If a character in `t` matches the current character in `s`, move the pointer in `s` to the next position.
3. **End Condition**: If the pointer for `s` reaches the end of `s`, all characters in `s` have been matched in order, so return `true`. Otherwise, return `false`.

#### Java Solution

```java
public class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
```

#### Time Complexity ⏳

- **O(n + m)**, where `n` is the length of `s` and `m` is the length of `t`. We traverse both strings once.

#### Space Complexity 💾

- **O(1)**, as no additional space is used.

### Follow-up: Efficient Solution for Multiple Queries

If there are multiple `s` strings (e.g., `s1, s2, ..., sk`), consider **Binary Search with Preprocessing**:

1. **Preprocess `t`**: Create a map where each character points to a list of indices in `t`.
2. **Binary Search for Subsequences**: For each `s`, use binary search to find each character’s position in `t` that comes after the previously matched character’s index.

You can find the full solution [here](Solution.java).
