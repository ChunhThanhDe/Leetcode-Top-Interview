## 48. Rotate Image 🔄

**Difficulty**: `Medium` - **Tags**: `Matrix`, `Simulation`

[LeetCode Problem Link](https://leetcode.com/problems/rotate-image/)

---

### Problem Statement 📜

You are given an `n x n` 2D matrix representing an image. Rotate the image by 90 degrees clockwise.

**Constraints**:
- The rotation must be performed **in-place**, modifying the input 2D matrix directly.
- **Do not allocate another 2D matrix** for the rotation.

---

### Examples 🌟

🔹 **Example 1:**

![](rotate1.jpg)

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
[[7, 4, 1],
 [8, 5, 2],
 [9, 6, 3]]
```

🔹 **Example 2:**

![](rotate2.jpg)

**Input:**
```java
int[][] matrix = {
    {5, 1, 9, 11},
    {2, 4, 8, 10},
    {13, 3, 6, 7},
    {15, 14, 12, 16}
};
```

**Output:**
```
[[15, 13, 2, 5],
 [14, 3, 4, 1],
 [12, 6, 8, 9],
 [16, 7, 10, 11]]
```

---

### Constraints ⚙️

- `n == matrix.length == matrix[i].length`
- `1 <= n <= 20`
- `-1000 <= matrix[i][j] <= 1000`

---

### Solution 💡

To rotate the image by 90 degrees clockwise, we follow these steps:

1. **Transpose the Matrix**:
   - Swap the elements `matrix[i][j]` with `matrix[j][i]` for all `i < j`.
2. **Reverse Each Row**:
   - Reverse the order of elements in each row of the transposed matrix.

This in-place transformation achieves the required rotation.

---

#### Java Solution

```java
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Swap elements along the diagonal
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                // Swap elements to reverse the row
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}
```

---

### Explanation of the Solution

1. **Transpose the Matrix**:
   - Swap `matrix[i][j]` and `matrix[j][i]` to flip the rows and columns along the main diagonal.

2. **Reverse Each Row**:
   - Use two pointers to swap the first and last elements of each row, moving inward.

3. **Result**:
   - The combination of transposing and reversing each row results in a 90-degree clockwise rotation.

---

### Time Complexity ⏳

- **O(n²)**:
  - Transposing the matrix takes `O(n²)`.
  - Reversing the rows also takes `O(n²)`.

### Space Complexity 💾

- **O(1)**:
  - The rotation is performed in-place, so no extra memory is used.

You can find the full solution [here](Solution.java).