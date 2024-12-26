/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-05-24 16:20:41
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

class Solution {
    // function to convert a given string to zigzag pattern with numRows and return it as a Single String.
    public String convert(String s, int numRows){
        // if the String s is empty or numRows is 1. no conversion is needed. return s.
        if (s.isEmpty() || numRows == 1) return s;

        // Create a array to hold strings for each row of the zigzag pattern
        String[] rows = new String[numRows];

        // initialize each row as a empty String
        for ( int i = 0; i < numRows; i++){
            rows[i] = "";
        }

        // create rowIndex to count row. Start at the first row (index = 0)
        int rowIndex = 0;

        // variable to control the direction of traversal, initially moving down (1)
        int directionNext = 1; // 1 means moving down. -1 means moving up

        // loop through each character in the input string
        for (char c : s.toCharArray()){
            // add the current character to the current row
            rows[rowIndex] += c;

            // if we reach the top now, we change direction to move down
            if (rowIndex == 0){
                directionNext = 1;
            }
            // if we each the bottom row, we change direction to move up
            else if (rowIndex == numRows - 1){
                directionNext = -1;
            }

            // move to the next row
            rowIndex += directionNext;

        }

        // Create String builder to combine all row into the final String result
        StringBuilder result = new StringBuilder();

        // Append each row to the result string
        for (String row : rows){
            result.append(row);
        }

        // return the final zigzag convert String
        return result.toString();
    }
}