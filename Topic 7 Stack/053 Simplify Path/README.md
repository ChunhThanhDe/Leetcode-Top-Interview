## 71. Simplify Path 🗺️

**Difficulty**: `Medium` - **Tags**: `Stack`, `String`

[LeetCode Problem Link](https://leetcode.com/problems/simplify-path/)

---

### Problem Statement 📜

Given an absolute path for a Unix-style file system, which begins with a slash `'/'`, transform this path into its simplified canonical path.

In Unix-style file systems:

- A single period `'.'` signifies the current directory.
- A double period `'..'` denotes moving up one directory level.
- Multiple slashes `'//'` are interpreted as a single slash `'/'`.

The simplified canonical path should:

1. Start with a single slash `'/'`.
2. Separate directories with a single slash `'/'`.
3. Not end with a slash `'/'` (unless it is the root directory).
4. Exclude any single or double periods.

---

### Examples 🌟

🔹 **Example 1:**

**Input:**

```plaintext
path = "/home/"
```

**Output:**

```plaintext
"/home"
```

---

🔹 **Example 2:**

**Input:**

```plaintext
path = "/home//foo/"
```

**Output:**

```plaintext
"/home/foo"
```

---

🔹 **Example 3:**

**Input:**

```plaintext
path = "/home/user/Documents/../Pictures"
```

**Output:**

```plaintext
"/home/user/Pictures"
```

---

🔹 **Example 4:**

**Input:**

```plaintext
path = "/../"
```

**Output:**

```plaintext
"/"
```

---

🔹 **Example 5:**

**Input:**

```plaintext
path = "/.../a/../b/c/../d/./"
```

**Output:**

```plaintext
"/.../b/d"
```

---

### Constraints ⚙️

- `1 <= path.length <= 3000`
- `path` consists of English letters, digits, period `'.'`, slash `'/'`, or underscore `'_'`.
- `path` is a valid absolute Unix path.

---

### Solution 💡

To solve the problem, a **stack** can be used to process directory names:

1. Split the path by `'/'` to handle each component.
2. Ignore empty strings, `'.'`, and handle `'..'` by popping the stack (if not empty).
3. Push valid directory names onto the stack.
4. Construct the canonical path by joining stack elements with `'/'`.

---

#### Java Solution

```java
import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        // Step 1: Process each component
        for (String component : components) {
            if (component.isEmpty() || component.equals(".")) {
                // Ignore empty or current directory components
                continue;
            } else if (component.equals("..")) {
                // Move up one directory level
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Push valid directory names
                stack.push(component);
            }
        }

        // Step 2: Construct the simplified path
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }

        return result.length() > 0 ? result.toString() : "/";
    }
}
```

---

### Explanation of the Solution

1. **Splitting the Path**:

   - Split the path into components by `'/'` to isolate directories, `'.'`, and `'..'`.

2. **Using a Stack**:

   - Push valid directory names onto the stack.
   - Pop the stack for `'..'` to move up a directory level.
   - Ignore `'.'` and empty components.

3. **Constructing the Canonical Path**:
   - Join stack elements with `'/'` to create the simplified path.
   - If the stack is empty, return `'/'` as the root directory.

---

### Time Complexity ⏳

- **O(n)**: Where `n` is the length of the input `path`. Each component is processed once.

### Space Complexity 💾

- **O(n)**: In the worst case, the stack contains all components of the path.

You can find the full solution [here](Solution.java).
