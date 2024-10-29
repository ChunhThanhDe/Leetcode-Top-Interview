## 125. Valid Palindrome 🚦

**Difficulty**: `Easy` - **Tags**: `Two Pointers`, `String`, `Palindrome`

[LeetCode Problem Link](https://leetcode.com/problems/valid-palindrome/)

### Description 📋

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string `s`, return `true` if it is a palindrome, or `false` otherwise.

### Examples 🌟

**Example 1:**

**Input:**
```python
s = "A man, a plan, a canal: Panama"
```

**Output:**
```
true
```

Explanation: After removing non-alphanumeric characters and converting to lowercase, we get "amanaplanacanalpanama", which is a palindrome.

**Example 2:**

**Input:**
```python
s = "race a car"
```

**Output:**
```
false
```

Explanation: After preprocessing, "raceacar" is not a palindrome.

**Example 3:**

**Input:**
```python
s = " "
```

**Output:**
```
true
```

Explanation: An empty string is a palindrome by definition, as it reads the same forward and backward.

### Constraints ⚙️

- `1 <= s.length <= 2 * 10^5`
- `s` consists only of printable ASCII characters.

### Solution 💡

To determine if `s` is a palindrome, we can follow these steps:

1. **Filter Non-Alphanumeric Characters**: We convert `s` to lowercase and keep only alphanumeric characters.
2. **Use Two Pointers**: Set one pointer at the beginning (`left`) and another at the end (`right`) of the filtered string.
3. **Compare Characters**: Move pointers inward, comparing characters at each position. If any pair of characters doesn’t match, return `false`.
4. **Return `true`** if all characters match as the pointers converge or pass each other.

#### Time Complexity ⏳

- **O(n)** where `n` is the length of the string. We scan the string twice (once for filtering and once for checking), which is linear.

#### Space Complexity 💾

- **O(n)** for storing the filtered string.

#### Java Implementation

```java
public class Solution {
    public boolean isPalindrome(String s) {
        // Step 1: Filter non-alphanumeric characters and convert to lowercase
        StringBuilder filteredStr = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                filteredStr.append(Character.toLowerCase(c));
            }
        }

        // Step 2: Use two-pointer technique
        int left = 0, right = filteredStr.length() - 1;
        while (left < right) {
            if (filteredStr.charAt(left) != filteredStr.charAt(right)) {
                return false; // Not a palindrome
            }
            left++;
            right--;
        }

        return true; // String is a palindrome
    }
}
```

#### Time Complexity ⏳

- **O(n)**: We go through each character once to filter and another pass to check, making it overall linear time complexity.

#### Space Complexity 💾

- **O(n)**: Additional space for storing the filtered alphanumeric characters.

You can find the full solution [here](Solution.java).

