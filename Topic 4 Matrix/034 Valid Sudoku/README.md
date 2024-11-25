## 36. Valid Sudoku 🌐

**Difficulty**: `Medium` - **Tags**: `Hash Table`, `Matrix`

[LeetCode Problem Link](https://leetcode.com/problems/valid-sudoku/)

---

### Problem Statement 📜

Determine if a 9 x 9 Sudoku board is valid. A board is valid if:

1. Each row contains the digits `1-9` without repetition.
2. Each column contains the digits `1-9` without repetition.
3. Each of the nine 3 x 3 sub-boxes contains the digits `1-9` without repetition.

📝 **Notes**:
- Only the filled cells need to be validated.
- A valid board does not necessarily need to be solvable.

---

### Examples 🌟

🔹 **Example 1:**

<img src="Sudoku.webp" alt="Sudoku" width="300" />

**Input:**
```python
board = [
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
```

**Output:**
```
true
```

---

🔹 **Example 2:**

**Input:**
```python
board = [
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
```

**Output:**
```
false
```

Explanation:
The same as Example 1, except there are two `8`s in the top left 3 x 3 sub-box.

---

### Constraints ⚙️

- `board.length == 9`
- `board[i].length == 9`
- `board[i][j]` is a digit `1-9` or `'.'`.

---

### Solution 💡

To solve the problem, we need to validate:

1. Each row.
2. Each column.
3. Each 3x3 sub-box.

We can use sets to track numbers in each row, column, and sub-box while iterating through the board.

---

#### Java Solution

```java
import java.util.HashSet;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Use sets to track seen numbers in rows, columns, and boxes
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];
                if (current != '.') {
                    String row = "row" + i + current;
                    String col = "col" + j + current;
                    String box = "box" + (i / 3) + (j / 3) + current;

                    // Check if any number is repeated
                    if (!seen.add(row) || !seen.add(col) || !seen.add(box)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
```

---

### Explanation of the Solution

1. **Tracking Validity**:
   - Use a set to store unique strings for each row, column, and 3x3 box.
   - For example:
     - `"row0-5"` means '5' exists in row 0.
     - `"col1-3"` means '3' exists in column 1.
     - `"box0-0-7"` means '7' exists in the top-left box.

2. **Validation**:
   - Traverse the entire board.
   - Skip empty cells (denoted by `.`).
   - Check if adding the current number to the set violates any rule.

3. **Result**:
   - If all checks pass, return `true`.
   - Otherwise, return `false`.

---

### Time Complexity ⏳

- **O(81)**:
  - We traverse each cell in the 9x9 board once.
  - Checking or inserting into a set takes **O(1)** on average.

### Space Complexity 💾

- **O(81)**:
  - The set can store up to 81 entries in the worst case.

You can find the full solution [here](Solution.java).