class AnotherSolution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;

        // Shift: use 2nd bit to store previous condition
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] << 1;
            }
        }

        // Count and calculate
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int countNeighbor = count(board, i , j);

                // Access 2nd bit for previous value
                if ((board[i][j] >> 1) == 1) {
                    board[i][j] = (countNeighbor >= 2 && countNeighbor <= 3) ? board[i][j] | 1 : board[i][j];
                } else { // board[i][j] == 0
                    board[i][j] = count(board, i, j) == 3 ? board[i][j] | 1 : board[i][j];
                }
            }
        }

        // Filter out 2nd bit and only 1st bit as result
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] & 1; // remove 2nd bit, which stores previous value
            }
        }
    }

    int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
    int[] dy = {1, -1, 0, 0, -1, 1, -1, 1};

    // optimize: no need to count all.
    private int count(int[][] board, int x, int y) {
        int count = 0;
        for (int i = 0; i < dx.length; i++) {
            int mX = x + dx[i];
            int mY = y + dy[i];
            if (mX >= 0 && mX < board.length && mY >= 0 && mY < board[0].length) {
                count += (board[mX][mY] >> 1);
            }
        }
        return count;
    }
}
