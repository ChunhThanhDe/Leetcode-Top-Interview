/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-06-06 11:24:26
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

// input: an nxn 2D matrix
// output: the matrix rotated 90 degrees clockwise

public class Solution {
    public void rotate(int[][] matrix){

        int n = matrix.length;

        // step 1: transpose the matrix
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                // Swap elements diagonally
                int tempt = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tempt;

            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n/2; j++){
                // swap elements to reverse the order of the row
                int tempt = matrix[i][j];
                matrix[i][j] = matrix [i][n - j -1];
                matrix [i][n - j -1] = tempt;

            }
        }

    }
}