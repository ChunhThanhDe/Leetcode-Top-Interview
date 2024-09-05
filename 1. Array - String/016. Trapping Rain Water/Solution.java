class Solution {
    // Convert the problem to the problem of calculating area
    public int trap(int[] height) {
        int n = height.length;
        int heighestPoint = 0;
        int heighestValue = height[0];
        int nextPoint;
        int nextValue;
        int totalS = 0;
        int totalWater = 0;
        int totalHeight = 0;

        for (int i = 0; i < n; i++){
            if(height[i] > heighestValue){
                heighestValue = height[i];
                heighestPoint = i;
            }
            totalHeight+= height[i];
        }

 
        if (heighestPoint == 0){
            nextValue = height[n - 1];
            for (int i = n - 1; i > 0; i--){
                totalS += nextValue;
                if(height[i-1] > nextValue){
                    nextValue = height[i-1];
                } 
            }

            totalS += heighestValue;
        } else if (heighestPoint == n - 1){
            nextValue = height[0];
            for (int i = 0; i < n - 1; i++){
                totalS += nextValue;
                if(height[i+1] > nextValue){
                    nextValue = height[i+1];
                } 
            }

            totalS += heighestValue;
        } else {
            nextValue = height[0];
            for (int i = 0; i < heighestPoint; i++){
                totalS += nextValue;
                if(height[i+1] > nextValue){
                    nextValue = height[i+1];
                } 
            }

            nextValue = height[n - 1];
            for (int i = n - 1; i > heighestPoint; i--){
                totalS += nextValue;
                if(height[i-1] > nextValue){
                    nextValue = height[i-1];
                } 
            }

            totalS += nextValue;
        }

        return totalS - totalHeight; 

    }
}