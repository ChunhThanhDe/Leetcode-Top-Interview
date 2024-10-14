## 14. Longest Common Prefix 🌱

**Difficulty**: `Easy` - **Tags**: `String`

[LeetCode Problem Link](https://leetcode.com/problems/longest-common-prefix/description/)

### Description

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

### Examples

**Example 1:**

Input:
```java
strs = ["flower","flow","flight"]
```

Output:
```
"fl"
```

**Example 2:**

Input:
```java
strs = ["dog","racecar","car"]
```

Output:
```
""
```

Explanation:
There is no common prefix among the input strings.

### Constraints

- The array `strs` contains at least one string and at most 200 strings.
- All strings in `strs` consist of lowercase English letters only.

### Solution 💡

To solve this problem, we compare characters of each string in the array and find the longest common prefix by checking each character in the strings until a mismatch is found.

#### Java

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }
}
```

#### Time Complexity ⏳

- **O(m * n)**: The time complexity is linear, where `m` is the length of the shortest string and `n` is the number of strings in the array.

#### Space Complexity 💾

- **O(1)**: The space complexity is constant since we are using only a few variables.

You can find the full solution [here](Solution.java).