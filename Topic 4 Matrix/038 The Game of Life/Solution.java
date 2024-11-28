public class Solution {
    // input: mxn grid board
    // output: board updated to the next state
    //
    // rule: live is `1` and dead is `0`
    // 1. any live cell with fewer than 2 live cell neighbors dies
    // 2. any live cell with 2 or 3 live cell neighbors lives
    // 3. any live cell with more than 3 live cell neighbors dies
    // 4. any dead cell with exactly 3 live cell neighbors becomes alive
    public void gameOfLife(int[][] board) {
        int m = board.length; // row length
        int n = board[0].length; // column length

        // Directions for the 8 neighbors
        int[][] direction = {
            {-1, -1}, {-1, 0}, {-1, 1}, // top-left, top, top-right
            {0, -1}, {0, 1},  // left, right
            {1, -1}, {1, 0}, {1, 1}     // bottom-left, bottom, bottom-right
        };

        // Loop through each cell on the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveCellNeighbors = 0;

                // Count live cell neighbors
                for (int[] dir : direction) {
                    int r = i + dir[0];
                    int c = j + dir[1];

                    // Check if the cell neighbor is valid and is alive or was alive
                    // use Math.abs to check because i use -1 to mark if live cell to die
                    if (r >= 0 && c >= 0 && r < m && c < n && Math.abs(board[r][c]) == 1) {
                        liveCellNeighbors++;
                    }
                }

                // Apply the rules
                if (board[i][j] == 1 && (liveCellNeighbors < 2 || liveCellNeighbors > 3)) {
                    board[i][j] = -1; // Mark cell to die (alive to dead)
                }
                if (board[i][j] == 0 && liveCellNeighbors == 3) {
                    board[i][j] = 2; // Mark cell to live (dead to alive)
                }
            }
        }

        // Finalize the board by applying the changes
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) board[i][j] = 0; // Alive to dead
                if (board[i][j] == 2) board[i][j] = 1; // Dead to alive
            }
        }
    }
}
