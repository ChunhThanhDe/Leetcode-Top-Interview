class Solution {
  public boolean isValidSudoku(char[][] board) {
    int N = 9;
    int[][] rows = new int[N][N];
    int[][] cols = new int[N][N];
    int[][] boxes = new int[N][N];
    for (int r = 0; r < N; r++) {
      for (int c = 0; c < N; c++) {
        // If the current cell is empty, skip it
        if (board[r][c] == '.') {
          continue;
        }
        // Convert the character to its corresponding index (0-8)
        int pos = board[r][c] - '1';
        // Check if the current number has already appeared in the same row
        if (rows[r][pos] == 1) {
          return false;
        }
        // Mark the current number as appeared in the row
        rows[r][pos] = 1;
        // Check if the current number has already appeared in the same column
        if (cols[c][pos] == 1) {
          return false;
        }
        // Mark the current number as appeared in the column
        cols[c][pos] = 1;
        // Calculate the index of the 3x3 box containing the current cell
        int idx = (r / 3) * 3 + c / 3;
        // Check if the current number has already appeared in the same 3x3 box
        if (boxes[idx][pos] == 1) {
          return false;
        }
        // Mark the current number as appeared in the 3x3 box
        boxes[idx][pos] = 1;
      }
    }
    // If we made it through the entire board without returning false, the Sudoku is valid
    return true;
  }
}