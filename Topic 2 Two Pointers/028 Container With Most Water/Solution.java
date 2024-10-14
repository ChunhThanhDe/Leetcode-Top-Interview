class Solution {
    public int maxArea(int[] height) {
        if (height.length <= 1)
        	return 0;
        int max = 0;
        int x = 0, y = height.length - 1;
        while (x < y) {
        	int sum = 0;
        	if (height[x] <= height[y]) {
        		sum = (y - x) * height[x];
        		x ++;
        	}
        	else {
        		sum = (y - x) * height[y];
        		y --;
        	}
        	if (sum > max)
        		max = sum;
        }
        return max;
    }
}