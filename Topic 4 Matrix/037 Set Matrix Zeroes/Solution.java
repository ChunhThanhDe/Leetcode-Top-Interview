/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-06-07 16:36:54
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

// input: an m x n integer matrix matrix
// output: if an element is 0, set its entire row and column to 0's.

public class Solution {
    public void setZeroes(int[][] matrix){

        // Get the size of the matrix
        int m = matrix.length; // number of rows
        int n = matrix[0].length; // number of column
        boolean rowZero = false;
        boolean colZero = false;

        // Check if the first column contains any zeroes
        // if the first column has a zero, set colZero to two
        for (int i = 0; i < m; i++){
            if (matrix[i][0] == 0){
                colZero = true;
                break; // No need to continue checking once we find a zero
            }
        }

        // Check if the first row contains any zeroes
        // if the first row has a zero, set rowZero to true
        for (int j = 0; j < n; j ++){
            if (matrix[0][j] == 0){
                rowZero = true;
                break; // no need to continue checking once we find a zero
            }
        }

        // Mark the first row and first column for cells that need to be zeroed
        // Use matrix [i][0] and matrix [0][j] to mark rows and column that need to be zero
        for (int i = 1; i < m; i ++){
            for (int j = 1; j < n; j ++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0; // mark the first column
                    matrix[0][j] = 0; // ,ark the fist row
                }
            }
        }

        // Set the zeros for the matrix (excluding the first row and column)
        // if the cell in the first column or first row is marked as zero
        // set that cell to zero
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        // zero out the first row if needed
        if (rowZero){
            for (int j = 0; j < n; j ++){
                matrix[0][j] = 0;
            }
        }

        // zero out the first Column if needed
        if (colZero){
            for (int i = 0; i < m; i ++){
                matrix[i][0] = 0;
            }
        }

    }
}