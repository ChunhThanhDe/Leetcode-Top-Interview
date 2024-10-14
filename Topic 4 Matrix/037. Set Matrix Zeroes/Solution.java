class Solution {
    public void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        Boolean up = false;
        Boolean left = false;
        
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (matrix[i][j] == 0){
                    if (i == 0){
                        up = true;
                    }  
                    if (j == 0){
                        left = true;
                    }
                    if ( i != 0 && j != 0){
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }
        }

        for (int i = 1; i < rows; i++){
            if(matrix[i][0] == 0){
                for (int j = 0; j < cols; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < cols; j++){
            if(matrix[0][j] == 0){
                for (int i = 0; i < rows; i++){
                    matrix[i][j] = 0;
                }
            }
        }

        if (up){
            for (int i = 0; i < cols; i++){
                matrix[0][i] = 0;
            }
        }

        if (left){
            for (int i = 0; i < rows; i++){
                matrix[i][0] = 0;
            }
        }
        
    }
}