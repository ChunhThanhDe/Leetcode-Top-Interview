class Solution {
    public int maxProfit(int[] prices) {

        // Because maxProfit will not change if minBuy has a new value that is not satisfied,
        // causing maxProfit to increase. If min Buy has a value that increases profit, 
        // then maxProfit will change.
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
        
    }
}