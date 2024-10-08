## 58. Length of Last Word 🔠

**Difficulty**: `Easy` - **Tags**: `String`

[LeetCode Problem Link](https://leetcode.com/problems/length-of-last-word/description/)

### Description

Given a string `s` consisting of words and spaces, return the length of the last word in the string.

A word is defined as a maximal substring consisting of non-space characters only.

### Examples

**Example 1:**

Input:
```java
s = "Hello World"
```

Output:
```
5
```

Explanation:
The last word is "World" which has a length of 5.

**Example 2:**

Input:
```java
s = "   fly me   to   the moon  "
```

Output:
```
4
```

Explanation:
The last word is "moon" with a length of 4.

**Example 3:**

Input:
```java
s = "luffy is still joyboy"
```

Output:
```
6
```

Explanation:
The last word is "joyboy" which has a length of 6.

### Constraints

- The input string `s` consists of only printable ASCII characters.
- The string may contain leading or trailing spaces, but it will not contain multiple consecutive spaces.

### Solution 💡

To solve this problem, we trim the string to remove any leading or trailing spaces, then count the characters of the last word by iterating from the end of the string until we encounter a space.

#### Java

```java
class Solution {
    public int lengthOfLastWord(String s) {
        String trimmedString = s.trim();
        int length = 0;
        
        for (int i = trimmedString.length() - 1; i >= 0; i--) {
            if (trimmedString.charAt(i) == ' ') {
                break;
            }
            length++;
        }
        
        return length;
    }
}
```

#### Time Complexity ⏳

- **O(n)**: The time complexity is linear, where `n` is the length of the trimmed input string.

#### Space Complexity 💾

- **O(1)**: The space complexity is constant as we only use a few variables.

You can find the full solution [here](Solution.java).