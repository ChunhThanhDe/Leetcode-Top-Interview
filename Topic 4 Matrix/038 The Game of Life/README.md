## 289. Game of Life 🖼️

**Difficulty**: `Medium` - **Tags**: `Array`, `Matrix`, `Simulation`

[LeetCode Problem Link](https://leetcode.com/problems/game-of-life/)

---

### Problem Description 📜

According to Wikipedia's article: **"The Game of Life"**, also known simply as **Life**, is a cellular automaton devised by the British mathematician **John Horton Conway** in 1970.

The board is made up of an `m x n` grid of cells, where each cell has an initial state: **live** (represented by `1`) or **dead** (represented by `0`).

Each cell interacts with its eight neighbors (horizontal, vertical, and diagonal) according to the following rules:

---

### Game Rules 🔍

1. **💀 Under-population**:
   Any live cell with fewer than **two** live neighbors dies.

2. **🌱 Survival**:
   Any live cell with **two or three** live neighbors lives on to the next generation.

3. **🔥 Over-population**:
   Any live cell with more than **three** live neighbors dies.

4. **🌳 Reproduction**:
   Any dead cell with exactly **three** live neighbors becomes a live cell.

---

### Examples 🌟

🔹 **Example 1:**

![](grid1.jpg)

**Input:**
```java
int[][] board = {
    {0, 1, 0},
    {0, 0, 1},
    {1, 1, 1},
    {0, 0, 0}
};
```

**Output:**
```
[[0, 0, 0],
 [1, 0, 1],
 [0, 1, 1],
 [0, 1, 0]]
```

🔹 **Example 2:**

![](grid2.jpg)

**Input:**
```java
int[][] board = {
    {1, 1},
    {1, 0}
};
```

**Output:**
```
[[1, 1],
 [1, 1]]
```

---

### Constraints ⚙️

- `m == board.length`
- `n == board[i].length`
- `1 <= m, n <= 25`
- `board[i][j]` is `0` or `1`.

---

### Follow-up 🤔

1. **In-Place Solution**:
   Can you solve the problem **in-place**?
   Remember that the board must be updated simultaneously, meaning you can't use updated values to affect other cells in the same iteration.

2. **Infinite Grid**:
   The board is technically **infinite**. How would you handle cases where live cells reach the border of the array?

---

### Solution 💡

To solve this problem in-place:

- Use intermediate states to represent transitions:
  - `2`: Represents a cell that was alive but will become dead.
  - `-1`: Represents a cell that was dead but will become alive.
- Traverse the board, calculate the next state of each cell based on its neighbors, and update it using the intermediate states.
- Finally, convert the intermediate states to their final values.

---

#### Java Solution

```java
public class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;

        // Directions for the 8 neighbors
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},          {0, 1},
            {1, -1}, {1, 0},  {1, 1}
        };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;

                // Count live neighbors
                for (int[] dir : directions) {
                    int r = i + dir[0], c = j + dir[1];
                    if (r >= 0 && r < m && c >= 0 && c < n && Math.abs(board[r][c]) == 1) {
                        liveNeighbors++;
                    }
                }

                // Apply the rules
                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = 2; // Alive to Dead
                }
                if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 3; // Dead to Alive
                }
            }
        }

        // Finalize the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) board[i][j] = 0;  // Alive -> Dead
                if (board[i][j] == 3) board[i][j] = 1; // Dead -> Alive
            }
        }
    }
}
```

---

### Explanation of the Solution

1. **Use Intermediate States**:
   - Transition states (`2` for alive to dead, `-1` for dead to alive) help avoid overwriting neighbor data prematurely.

2. **Final Pass**:
   - Replace intermediate states with the final state after completing the first pass.

---

### Time Complexity ⏳

- **O(m * n)**:
  Each cell is visited once to calculate its next state.

### Space Complexity 💾

- **O(1)**:
  The board is updated in-place without additional space.

You can find the full solution [here](Solution.java).