## 73. Set Matrix Zeroes

**Difficulty**: `Medium` - **Tags**: `Array`, `Matrix`, `Simulation`

[LeetCode Problem Link](https://leetcode.com/problems/set-matrix-zeroes/)

---

### Problem Statement 📜

Given an `m x n` integer matrix `matrix`, if an element is `0`, set its entire row and column to `0`'s.

You must perform this operation **in-place**, without using extra space.

---

### Examples 🌟

🔹 **Example 1:**

**Input:**
```java
int[][] matrix = {
    {1, 1, 1},
    {1, 0, 1},
    {1, 1, 1}
};
```

**Output:**
```
[[1, 0, 1],
 [0, 0, 0],
 [1, 0, 1]]
```

🔹 **Example 2:**

**Input:**
```java
int[][] matrix = {
    {0, 1, 2, 0},
    {3, 4, 5, 2},
    {1, 3, 1, 5}
};
```

**Output:**
```
[[0, 0, 0, 0],
 [0, 4, 5, 0],
 [0, 3, 1, 0]]
```

---

### Constraints ⚙️

- `m == matrix.length`
- `n == matrix[0].length`
- `1 <= m, n <= 200`
- `-2^31 <= matrix[i][j] <= 2^31 - 1`

---

### Follow-up 🤔

- A straightforward solution using **O(mn)** space is probably not the best approach.
- A simple improvement uses **O(m + n)** space, but can you devise a solution using **constant space**?

---

### Solution 💡

To solve this problem efficiently:

1. **Naive Approach**:
   - Use two auxiliary arrays `rows` and `cols` to store which rows and columns need to be set to `0`. This approach uses extra space.

2. **Optimized Approach**:
   - Use the matrix itself to track which rows and columns need to be zeroed.
   - Use the first row and first column of the matrix to store the state of other rows and columns.
   - If `matrix[i][j]` is `0`, mark the first row and first column to indicate that the entire row and column need to be set to zero.

---

#### Java Solution

```java
public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean rowZero = false, colZero = false;

        // Check if the first row and first column need to be zeroed
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                colZero = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                rowZero = true;
                break;
            }
        }

        // Mark the cells that should be zeroed by using the first row and column
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Zero out cells based on the marks in the first row and column
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Zero out the first row and first column if needed
        if (rowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (colZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
```

---

### Explanation of the Solution

1. **Step 1: Check the first row and first column**:
   - If any element in the first row or column is `0`, mark the `rowZero` or `colZero` flag as `true`.

2. **Step 2: Mark rows and columns to be zeroed**:
   - Traverse the matrix starting from `matrix[1][1]` and mark the first row and first column to indicate that the corresponding row and column should be set to `0`.

3. **Step 3: Zero out cells**:
   - Traverse the matrix again to set cells to `0` based on the marks in the first row and column.

4. **Step 4: Handle the first row and first column**:
   - Set the first row and first column to `0` if needed (based on the flags `rowZero` and `colZero`).

---

### Time Complexity ⏳

- **O(m * n)**:
  - We traverse the matrix multiple times, each traversal takes `O(m * n)`.

### Space Complexity 💾

- **O(1)**:
  - We do not use any extra space for storing row or column markers, making this solution constant space.

You can find the full solution [here](Solution.java).