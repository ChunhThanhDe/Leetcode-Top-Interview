class Solution {
    public int maxProfit(int[] prices) {

        // initialize minPrice to the highest possible value to find the smallest price
        // Because i an unsure whether the array 'prices' alway have at least one element.
        // This is useful to avoid causing an ArrayIndexOutOfBoundsException if the array is empty.
        int minPrice = Integer.MAX_VALUE;

        // second way:
        //          // Ensure the array is not empty
        //          if (prices.length == 0) {
        //              return 0; // No profit can be made
        //          }
        //
        //          // Initialize minPrice to the first price in the array
        //          int minPrice = prices[0];

        // Initialize minPrice to the first price in the array
        int minPrice = prices[0];

        // Initialize maxProfit to ), as the profit cannot be negative
        int maxProfit = 0;

        // Iterate through each price in the prices array
        for (int price : prices){
            // If the current price is less than the current minPrice, update minPrice
            if (price < minPrice){
                minPrice = price;
            } else {
                // if the current price is higher than minPrice, calculate the profit
                // Calculate the profit when if selling at the current price after buying at the minPrice 
                // Then, update maxProfit if the current profit is greater than previous maxProfit
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        } 
        
        return maxProfit;
    }
}