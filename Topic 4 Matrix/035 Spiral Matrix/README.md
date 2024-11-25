## 54. Spiral Matrix 🌐

**Difficulty**: `Medium` - **Tags**: `Matrix`, `Simulation`

[LeetCode Problem Link](https://leetcode.com/problems/spiral-matrix/)

---

### Problem Statement 📜

Given an `m x n` matrix, return all elements of the matrix in spiral order.

---

### Examples 🌟

🔹 **Example 1:**

![](spiral1.jpg)

**Input:**
```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
```

**Output:**
```
[1, 2, 3, 6, 9, 8, 7, 4, 5]
```

🔹 **Example 2:**

![](spiral2.jpg)

**Input:**
```java
int[][] matrix = {
    {1, 2, 3, 4},
    {5, 6, 7, 8},
    {9, 10, 11, 12}
};
```

**Output:**
```
[1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
```

---

### Constraints ⚙️

- `m == matrix.length`
- `n == matrix[i].length`
- `1 <= m, n <= 10`
- `-100 <= matrix[i][j] <= 100`

---

### Solution 💡

To traverse the matrix in spiral order, we use boundary pointers for rows and columns and move in the order: left-to-right, top-to-bottom, right-to-left, and bottom-to-top.

---

#### Java Solution

```java
import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0) return result;

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse top row
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Traverse right column
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // Traverse bottom row (if still within bounds)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Traverse left column (if still within bounds)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}
```

---

### Explanation of the Solution

1. **Initialization**:
   - Define four boundary variables: `top`, `bottom`, `left`, and `right`.

2. **Traversal**:
   - **Left to Right**: Traverse the current top row and increment `top`.
   - **Top to Bottom**: Traverse the current right column and decrement `right`.
   - **Right to Left**: Traverse the current bottom row (if valid) and decrement `bottom`.
   - **Bottom to Top**: Traverse the current left column (if valid) and increment `left`.

3. **Result**:
   - Stop traversal when `top > bottom` or `left > right`.

---

### Time Complexity ⏳

- **O(m * n)**:
  - Each element of the matrix is visited exactly once.

### Space Complexity 💾

- **O(1)**:
  - No additional space is used apart from the result list (output space not counted).

You can find the full solution [here](Solution.java).
