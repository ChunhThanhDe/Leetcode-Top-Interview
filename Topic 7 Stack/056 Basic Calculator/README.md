## 224. Basic Calculator 🧮

**Difficulty**: `Hard` - **Tags**: `Stack`, `Mathematical Expression`

[LeetCode Problem Link](https://leetcode.com/problems/basic-calculator/)

---

### Problem Statement 📜

Given a string `s` representing a valid expression, implement a basic calculator to evaluate it and return the result of the evaluation.

**Constraints:**

- You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as `eval()`.

### Examples 🌟

🔹 **Example 1:**

**Input:**

```plaintext
s = "1 + 1"
```

**Output:**

```plaintext
2
```

---

🔹 **Example 2:**

**Input:**

```plaintext
s = " 2-1 + 2 "
```

**Output:**

```plaintext
3
```

---

🔹 **Example 3:**

**Input:**

```plaintext
s = "(1+(4+5+2)-3)+(6+8)"
```

**Output:**

```plaintext
23
```

---

### Constraints ⚙️

- `1 <= s.length <= 3 * 10^5`
- `s` consists of digits, '+', '-', '(', ')', and spaces `' '`.
- `s` represents a valid expression.
- `'+'` is not used as a unary operation (e.g., `"+1"` and `"+(2 + 3)"` are invalid).
- `'-'` can be used as a unary operation (e.g., `"-1"` and `"- (2 + 3)"` are valid).
- There will be no two consecutive operators in the input.
- Every number and running calculation will fit in a signed 32-bit integer.

---

### Solution 💡

To solve the problem, we need to handle:

1. **Parentheses**: We need to evaluate expressions within parentheses first.
2. **Unary Minus**: Handle negative numbers or expressions that start with a minus sign.
3. **Operators**: Handle addition and subtraction between numbers.

We will use a **stack** to handle nested parentheses and the accumulation of results as we process the string.

---

#### Approach:

1. **Iterate through the string**:

   - If we encounter a number, accumulate it and push it onto the stack.
   - If we encounter an operator (`+` or `-`), record it for the next number.
   - If we encounter a parenthesis `(`, push the current result and operator onto the stack and start a new scope.
   - If we encounter a closing parenthesis `)`, calculate the result for that scope and return to the previous context.

2. **Handle each number**:

   - Consider negative numbers and numbers with multiple digits.

3. **Handle operators**:
   - For each operator, perform the addition or subtraction with the previous number or the current number if no previous number exists.

---

#### Java Solution

```java
import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0, sign = 1, num = 0; // result = accumulated result, sign = current sign (+ or -)

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0'); // Build the number digit by digit
            } else if (c == '+') {
                result += sign * num; // Add the current number to the result
                num = 0; // Reset the number for the next iteration
                sign = 1; // Set the sign to + for the next number
            } else if (c == '-') {
                result += sign * num; // Add the current number to the result
                num = 0; // Reset the number for the next iteration
                sign = -1; // Set the sign to - for the next number
            } else if (c == '(') {
                stack.push(result); // Save the current result before going into the parentheses
                stack.push(sign); // Save the current sign
                result = 0; // Reset the result for the new expression inside parentheses
                sign = 1; // Reset the sign for the new expression
            } else if (c == ')') {
                result += sign * num; // Add the current number to the result
                num = 0; // Reset the number
                result *= stack.pop(); // Apply the sign from the last '('
                result += stack.pop(); // Add the previous result from before '('
            }
        }

        if (num != 0) { // Add the last number if any
            result += sign * num;
        }

        return result;
    }
}
```

---

### Explanation of the Solution

1. **Building the Number**: As we iterate through the string, we build numbers by accumulating digits.

2. **Sign Management**: When encountering a `+` or `-`, we set the `sign` accordingly. If it's `+`, we add the current number to the result; if it's `-`, we subtract it.

3. **Parentheses Handling**:

   - When encountering a `(`, we push the current result and sign onto the stack and reset them for the new expression inside the parentheses.
   - When encountering a `)`, we complete the evaluation of the expression inside the parentheses by applying the sign and adding the result to the previous context.

4. **Final Calculation**: After the loop, we add any remaining number to the result.

---

### Time Complexity ⏳

- **O(n)**: We iterate over the string once, where `n` is the length of the string.

### Space Complexity 💾

- **O(n)**: In the worst case, we might need space for the stack that stores the results and signs of nested parentheses.

You can find the full solution [here](Solution.java).
