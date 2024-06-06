class Solution {
    public void rotate(int[][] matrix) {
        int cols = matrix.length;
        int row = matrix[0].length;

        int k = 0;

        for (int i = 0; i < cols ; i++){
            for (int j = k; j < row; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
            k++;
        }

        for (int i = 0; i < cols ; i++){
            for (int j = 0; j < row/2; j++){
                int temp = matrix[i][j];
                int sw = row - j - 1;
                matrix[i][j] = matrix[i][sw];
                matrix[i][sw] = temp;
            }
        }

        
    }
}