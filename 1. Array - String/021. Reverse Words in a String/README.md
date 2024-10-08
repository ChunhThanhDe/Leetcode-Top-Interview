## 151. Reverse Words in a String 🔄

**Difficulty**: `Medium` - **Tags**: `String`, `Two Pointers`

[LeetCode Problem Link](https://leetcode.com/problems/reverse-words-in-a-string/description/)

### Description

Given an input string `s`, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in `s` will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that `s` may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

### Examples

**Example 1:**

Input:
```java
s = "the sky is blue"
```

Output:
```
"blue is sky the"
```

**Example 2:**

Input:
```java
s = "  hello world  "
```

Output:
```
"world hello"
```

Explanation:
Your reversed string should not contain leading or trailing spaces.

**Example 3:**

Input:
```java
s = "a good   example"
```

Output:
```
"example good a"
```

Explanation:
You need to reduce multiple spaces between two words to a single space in the reversed string.

### Constraints

- The input string `s` contains only printable ASCII characters.
- `s` does not contain any leading or trailing spaces.
- The words in `s` will be separated by a single space.

### Solution 💡

To solve this problem, we can split the string into words, remove any extra spaces, and reverse the list of words. Finally, we join them back into a string with a single space separating the words.

#### Java

```java
class Solution {
    public String reverseWords(String s) {
        // Trim the string and split by spaces
        String[] words = s.trim().split("\\s+");
        // Initialize a StringBuilder to store the reversed words
        StringBuilder reversed = new StringBuilder();
        
        // Traverse the words array in reverse order and append them to the StringBuilder
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) {
                reversed.append(" ");
            }
        }
        
        // Convert StringBuilder back to String
        return reversed.toString();
    }
}
```

#### Time Complexity ⏳

- **O(n)**: The time complexity is linear, where `n` is the length of the input string.

#### Space Complexity 💾

- **O(n)**: The space complexity is also linear, as we are storing the reversed words in a new string.

You can find the full solution [here](Solution.java).