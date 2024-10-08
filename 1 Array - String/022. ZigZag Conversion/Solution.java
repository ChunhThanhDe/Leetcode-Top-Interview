class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || s.isEmpty()) return s;

        String[] rows = new String[numRows];
         for (int i = 0; i < numRows; i++) {
            rows[i] = "";
        }

        int rowIndex = 0;
        int directionNext = 1; // up to down

        for (char c : s.toCharArray()){
            rows[rowIndex] += c;

            if(rowIndex == 0){
                directionNext = 1;
            } else if (rowIndex == numRows - 1){
                directionNext = -1; // down to up
            }

            rowIndex += directionNext;
        }

        StringBuilder result = new StringBuilder();
        for (String row : rows) {
            result.append(row);
        }
        
        return result.toString();

    }
}