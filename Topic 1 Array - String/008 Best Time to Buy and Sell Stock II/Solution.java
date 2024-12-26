/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-05-24 16:20:41
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

class Solution {
    public int maxProfit(int[] prices) {

        // initialize profit = 0
        int profit = 0;

        // loop through the prices starting from second day
        for (int i = 1; i < prices.length; i++){

            // if today's price is higher than yesterday's price.
            // there is an opportunity to make a profit
            if(prices[i] > prices[i - 1]){
                // Calculator the profit from buying yesterday and selling to day,
                // and add it to the total profit
                profit += prices[i] - prices[i - 1];
            }
        }

        // return the maximum profit
        return profit;
    }
}