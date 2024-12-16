## 20. Valid Parentheses 🔍

**Difficulty**: `Easy` - **Tags**: `Stack`, `String`

[LeetCode Problem Link](https://leetcode.com/problems/valid-parentheses/)

---

### Problem Statement 📜

Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['`, and `']'`, determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.

---

### Examples 🌟

🔹 **Example 1:**

**Input:**

```plaintext
s = "()"
```

**Output:**

```plaintext
true
```

---

🔹 **Example 2:**

**Input:**

```plaintext
s = "()[]{}"
```

**Output:**

```plaintext
true
```

---

🔹 **Example 3:**

**Input:**

```plaintext
s = "(]"
```

**Output:**

```plaintext
false
```

---

### Constraints ⚙️

- `1 <= s.length <= 10^4`
- `s` consists of parentheses only `'()[]{}'`.

---

### Solution 💡

The problem can be solved using a stack:

1. Push opening brackets (`(`, `{`, `[`) onto the stack.
2. When encountering a closing bracket (`)`, `}`, `]`):
   - Check if the stack is not empty and if the top of the stack matches the closing bracket. If it matches, pop the stack.
   - Otherwise, the string is invalid.
3. At the end, the stack must be empty for the string to be valid.

---

#### Java Solution

```java
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        // Step 1: Iterate through the characters of the string
        for (char c : s.toCharArray()) {
            // Step 2: Push opening brackets onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // Step 3: Check for matching closing brackets
            else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // Step 4: Ensure the stack is empty
        return stack.isEmpty();
    }
}
```

---

### Explanation of the Solution

1. **Stack Usage**:

   - A stack is used to track unmatched opening brackets.
   - Opening brackets are pushed onto the stack, and closing brackets attempt to match the top of the stack.

2. **Validation**:

   - If the stack is empty before encountering a closing bracket or the top of the stack doesn't match the closing bracket, the string is invalid.

3. **Final Check**:
   - At the end of the traversal, the stack should be empty for the string to be valid.

---

### Time Complexity ⏳

- **O(n)**: Each character is processed once, and stack operations (push/pop) are O(1).

### Space Complexity 💾

- **O(n)**: In the worst case, all characters could be pushed onto the stack (e.g., all opening brackets).

You can find the full solution [here](Solution.java).
