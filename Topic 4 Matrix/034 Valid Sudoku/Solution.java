// input: a 9 x 9 Sudoku broad as a 2D character array (char[][])
// output: return the true if the broad is valid. false otherwise
// key points: Validate rows, columns, and 3x3 sub-boxed for duplicates.

import java.util.HashSet;

public class Solution {
  public boolean isValidSudoku(char[][] broad){

    // Use a hashSet to store the numbers in rows, columns and 3x3 box
    HashSet<String> seen = new HashSet<>();

    // Iterate through each cell of the 9x9  broad
    for (int i = 0; i < 9; i++){ // loop over rows
      for (int j = 0; j < 9; j++){ // loop over columns
        char current = broad[i][j];

        // if the cell is not empty. validate it
        if (current != '.'){
          // create unique keys for row, columns and box checks
          String row = "row" + i + current; // row key
          String col = "col" + j + current; // Column key
          String box = "box" + (i/3) + (j/3) + current; // box key

          // check if the current number already exits in row, columns, or box
          // if any key is already in the set, the broad is invalid
          if (!seen.add(row) || !seen.add(col) || !seen.add(box)){
            // return false if duplicate is found
            return false;
          }
        }
      }
    }

    // if no duplicates are found, the broad is valid
    return true;
  }
}