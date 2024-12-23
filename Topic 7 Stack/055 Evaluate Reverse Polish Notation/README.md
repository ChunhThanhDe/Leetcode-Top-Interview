## 150. Evaluate Reverse Polish Notation 🧠💻

**Difficulty**: `Medium` - **Tags**: `Stack`, `Math`

[LeetCode Problem Link](https://leetcode.com/problems/evaluate-reverse-polish-notation/)

---

### Problem Statement 📜

Given an array of strings `tokens` representing an arithmetic expression in Reverse Polish Notation (RPN), evaluate the expression and return the result as an integer.

**Rules:**

1. Valid operators: `'+'`, `'-'`, `'*'`, and `'/'`.
2. Each operand is either an integer or another RPN expression.
3. Division between two integers truncates towards zero.
4. No division by zero occurs.
5. The input always represents a valid RPN expression.
6. Results and intermediate calculations fit in a 32-bit integer.

---

### Examples 🌟

🔹 **Example 1:**

**Input:**

```plaintext
tokens = ["2","1","+","3","*"]
```

**Output:**

```plaintext
9
```

**Explanation:**
`((2 + 1) * 3) = 9`

---

🔹 **Example 2:**

**Input:**

```plaintext
tokens = ["4","13","5","/","+"]
```

**Output:**

```plaintext
6
```

**Explanation:**
`(4 + (13 / 5)) = 6`

---

🔹 **Example 3:**

**Input:**

```plaintext
tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
```

**Output:**

```plaintext
22
```

**Explanation:**

```plaintext
((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
```

---

### Constraints ⚙️

- `1 <= tokens.length <= 10^4`
- Each `tokens[i]` is:
  - An operator: `'+'`, `'-'`, `'*'`, `'/''`, or
  - An integer in the range `[-200, 200]`.

---

### Solution 💡

To evaluate an RPN expression efficiently, we use a **stack**:

1. Traverse the tokens one by one:

   - If the token is a number, push it onto the stack.
   - If the token is an operator, pop the top two numbers from the stack, perform the operation, and push the result back onto the stack.

2. At the end, the stack will contain a single number, which is the result.

---

#### Java Solution

```java
import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop(); // Second operand
                int a = stack.pop(); // First operand
                stack.push(performOperation(a, b, token));
            } else {
                stack.push(Integer.parseInt(token)); // Push number onto stack
            }
        }

        return stack.pop(); // The result is the last element in the stack
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private int performOperation(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b; // Integer division
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}
```

---

### Explanation of the Solution

1. **Stack Usage**:

   - Push operands onto the stack.
   - For operators, pop the top two elements, compute the result, and push the result back onto the stack.

2. **Operator Handling**:

   - Each operator performs its operation (`+`, `-`, `*`, `/`) on the last two numbers popped from the stack.

3. **Edge Cases**:
   - Division truncates towards zero (handled by Java’s `/` operator for integers).

---

### Time Complexity ⏳

- **O(n)**: We process each token once.

### Space Complexity 💾

- **O(n)**: Stack space for storing numbers during computation.

You can find the full solution [here](Solution.java).
