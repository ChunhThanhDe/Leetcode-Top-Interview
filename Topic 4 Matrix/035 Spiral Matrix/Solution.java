/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-06-06 09:57:18
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

// input: an m x n matrix
// output: a list element in spiral order

import java.util.ArrayList;
import java.util.List;

public class Solution{
    public List<Integer> spiralOrder(int[][] matrix){
        // result list to store elements in spiral order
        List<Integer> result = new ArrayList<>();

        // return an empty list if the matrix is null or empty
        if (matrix == null || matrix.length == 0) return result;

        // define the boundaries for movement
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        // loop the matrix element while boundaries are valid
        while (top <= bottom && left <= right){
            // Move the top row from left to right
            for (int i = left; i <= right; i++){
                result.add(matrix[top][i]);
            }

            // Move the top boundary down
            top ++;

            // move the right column from top to bottom
            for (int i = top; i <= bottom; i++){
                result.add(matrix[i][right]);
            }

            //Move the right boundary left
            right --;

            // Move the bottom row from right to left (if within bounds)
            if (top <= bottom){
                for (int i = right; i >= left; i--){
                    result.add(matrix[bottom][i]);
                }

                // Move the bottom boundary up
                bottom --;
            }

            // Move the left column from the bottom to top (if within bounds)
            if (left <= right){
                for (int i = bottom; i >= top; i--){
                    result.add(matrix[i][left]);
                }

                // Move the left boundary right
                left++;
            }
        }

        // Return the final list of elements in spiral order
        return result;


    }
}