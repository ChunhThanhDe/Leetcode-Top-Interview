public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>(); // Initialize a list to store the result
        if (matrix.length == 0) return result; // If the matrix is empty, return an empty list

        // Call the spiralOrder function with the initial parameters
        spiralOrder(result, matrix, 0, matrix.length - 1, 0, matrix[0].length - 1);
        return result;
    }

    void spiralOrder(ArrayList<Integer> result, int[][] matrix, int upBound, int lowBound, int leftBound, int rightBound) {
        // Traverse the edges of the matrix in the order: top, right, bottom, left
        for (int i = leftBound; i <= rightBound; i++) {
            result.add(matrix[upBound][i]); // Add the elements in the top row to the result
        }
        upBound++; // Increment the top row index by 1
        if (upBound > lowBound) return; // If the top row index exceeds the bottom row index, return

        for (int i = upBound; i <= lowBound; i++) {
            result.add(matrix[i][rightBound]); // Add the elements in the rightmost column to the result
        }
        rightBound--; // Decrement the rightmost column index by 1
        if (rightBound < leftBound) return; // If the rightmost column index is less than the leftmost column index, return

        for (int i = rightBound; i >= leftBound; i--) {
            result.add(matrix[lowBound][i]); // Add the elements in the bottom row to the result
        }
        lowBound--; // Decrement the bottom row index by 1
        if (lowBound < upBound) return; // If the bottom row index is less than the top row index, return

        for (int i = lowBound; i >= upBound; i--) {
            result.add(matrix[i][leftBound]); // Add the elements in the leftmost column to the result
        }
        leftBound++; // Increment the leftmost column index by 1
        if (leftBound > rightBound) return; // If the leftmost column index exceeds the rightmost column index, return

        spiralOrder(result, matrix, upBound, lowBound, leftBound, rightBound); // Recursively call the spiralOrder function with the new parameters
    }
}