import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {

        int n = ratings.length;
        int totalCandies = 0;

        // Initialize an array to store the candies given to each child
        int[] candies = new int[n];

        // step 1: Give each child 1 candy because Each child must have at least one
        // piece of candy.
        Arrays.fill(candies, 1);

        // step 2: loop through left to right to ensure children with higher ratings
        // (larger rating values) will receive more candy than their neighbors with
        // lower ratings in the left
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                // if the current child has a rating value higher than the neighbor child on
                // the left, so give them 1 more candy than the neighbor child on the left
                candies[i] = candies[i - 1] + 1;
            }
        }

        // step 3: loop through right to left to ensure children with higher ratings
        // will receive more candy than their neighbors with lower rating on the right
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                // if the current child has a rating value higher than the neighbor child on
                // the right, so give them maximum of the current candy or 1 more candy than the
                // neighbor child on the right
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // step 4: sum up the total number of candies
        for (int i = 0; i < n; i++) {
            totalCandies += candies[i];
        }

        return totalCandies;
    }
}