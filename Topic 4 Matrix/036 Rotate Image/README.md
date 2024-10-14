## 🔄 Rotate Image 🔄

### 📋 Problem Description

You are given an `n x n` 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image _in-place_, which means you have to modify the input 2D matrix directly. **DO NOT** allocate another 2D matrix and do the rotation.

### 🌟 Examples

**Example 1:**

![](spiral1.jpg)

```
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
```

**Example 2:**

![](spiral2.jpg)

```
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
```

### 🔍 Explanation

To rotate the image by 90 degrees clockwise, we can follow these steps:

1. Transpose the matrix (swap the elements along the main diagonal).
2. Reverse each row of the transposed matrix.

This process effectively rotates the matrix by 90 degrees clockwise.

### 💡 Tips

- Transpose the matrix by swapping the elements `matrix[i][j]` and `matrix[j][i]`.
- Reverse each row of the transposed matrix using a two-pointer approach.
- Perform these operations in-place to avoid using additional memory.

### 🚀 Let's Solve It!

If you have any questions or need further assistance, feel free to ask! 💬 I'm here to help. 😊