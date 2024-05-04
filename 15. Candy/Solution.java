class Solution {
        public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        // Go through the array of ratings from left to right and compare each child's rating
        // with the child on the left. If the rating of the current child is greater than 
        // the child on the left, we update the number of candies of the current child with 
        // the number of candies of the child on the left plus 1.
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Go through the array of ratings from right to left and compare each child's rating 
        // with the child on the right. If the rating of the current child is greater than 
        // the child on the right and the number of candies of the current child is not greater
        // than the number of candies of the child on the right plus 1, we update 
        // the number of candies of the current child with the number of candies of the child 
        // on the right. The child on the right adds 1.
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
        }

        // Total candy
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }
}