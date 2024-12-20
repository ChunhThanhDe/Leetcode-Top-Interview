## 155. Min Stack 🗃️

**Difficulty**: `Medium` - **Tags**: `Stack`, `Design`

[LeetCode Problem Link](https://leetcode.com/problems/min-stack/)

---

### Problem Statement 📜

Design a stack that supports the following operations in constant time `O(1)`:

1. `void push(int val)`: Push the element `val` onto the stack.
2. `void pop()`: Remove the element on the top of the stack.
3. `int top()`: Retrieve the top element of the stack.
4. `int getMin()`: Retrieve the minimum element in the stack.

You must implement all these methods in constant time.

---

### Examples 🌟

🔹 **Example 1:**

**Input:**

```plaintext
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]
```

**Output:**

```plaintext
[null,null,null,null,-3,null,0,-2]
```

**Explanation:**

```plaintext
MinStack minStack = new MinStack();
minStack.push(-2);    // Stack: [-2]
minStack.push(0);     // Stack: [-2, 0]
minStack.push(-3);    // Stack: [-2, 0, -3]
minStack.getMin();    // return -3
minStack.pop();       // Stack: [-2, 0]
minStack.top();       // return 0
minStack.getMin();    // return -2
```

---

### Constraints ⚙️

- `-2^31 <= val <= 2^31 - 1`
- Methods `pop`, `top`, and `getMin` will always be called on non-empty stacks.
- At most `3 * 10^4` calls will be made to `push`, `pop`, `top`, and `getMin`.

---

### Solution 💡

To achieve `O(1)` time complexity for all operations, we can use **two stacks**:

1. **Primary stack** to store all elements.
2. **Min stack** to keep track of the minimum value at each level of the stack.

For every `push`, we add the value to the primary stack, and update the min stack with the current minimum value. For `pop`, we remove from both stacks.

---

#### Java Solution

```java
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        // Push the current minimum to the minStack
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
```

---

### Explanation of the Solution

1. **Two Stacks**:

   - The main stack holds all the elements.
   - The min stack maintains the current minimum at every point.

2. **Push Operation**:

   - Push the element onto the main stack.
   - Update the min stack with the smaller of the new element and the current minimum.

3. **Pop Operation**:

   - Remove the top element from both stacks.

4. **Top Operation**:

   - Return the top element of the main stack.

5. **GetMin Operation**:
   - Retrieve the top element of the min stack, which represents the minimum.

---

### Time Complexity ⏳

- **Push**: `O(1)`
- **Pop**: `O(1)`
- **Top**: `O(1)`
- **GetMin**: `O(1)`

### Space Complexity 💾

- **O(n)**: We use two stacks, each storing up to `n` elements.

You can find the full solution [here](Solution.java).
