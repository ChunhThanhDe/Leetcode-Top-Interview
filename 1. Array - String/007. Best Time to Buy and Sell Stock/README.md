## 121. Best Time to Buy and Sell Stock 📈

**Difficulty**: `Easy` - **Tags**: `Array`, `Greedy`, `Dynamic Programming`

### Description 📋

You are given an array `prices` where `prices[i]` is the price of a given stock on the `ith` day. You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return `0`.

### Examples 🌟

**Example 1:**

**Input:**
```python
prices = [7,1,5,3,6,4]
```

**Output:**
```
5
```

**Explanation:**
- Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = `6 - 1 = 5`.
- Buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

**Example 2:**

**Input:**
```python
prices = [7,6,4,3,1]
```

**Output:**
```
0
```

**Explanation:**
- In this case, no transactions are done, so the maximum profit is `0`.

### Constraints ⚙️

- `1 <= prices.length <= 10^5`
- `0 <= prices[i] <= 10^4`

### Solution 💡

The time complexity is $O(n)$, and the space complexity is $O(1)$. We can solve this problem using a greedy approach by iterating through the array and keeping track of the minimum price seen so far. For each day, calculate the potential profit by selling on that day and update the maximum profit accordingly.

#### Java

```java
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // Update the minimum price if a lower price is found
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice); // Calculate and update the max profit
            }
        }

        return maxProfit;
    }
}
```

You can find the full `Solution.java` file [here](Solution.java).