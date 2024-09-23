## 135. Candy 🍬

**Difficulty**: `Hard` - **Tags**: `Greedy`, `Array`

### Description
There are `n` children standing in a row. Each child is assigned a rating value given in the `ratings` integer array.

You are giving candy to the children under the following conditions:

- Each child must have at least one piece of candy.
- Children with higher ratings (larger rating values) will receive more candy than their neighbors with lower ratings.

Return the minimum amount of candy you need to distribute to children.

### Examples

**Example 1:**

Input:
```python
ratings = [1,0,2]
```

Output:
```
5
```

Explanation:
You can allocate candies to the first, second, and third child as follows:
- First child: 2 candies
- Second child: 1 candy
- Third child: 2 candies

**Example 2:**

Input:
```python
ratings = [1,2,2]
```

Output:
```
4
```

Explanation:
You can allocate candies to the first, second, and third child as follows:
- First child: 1 candy
- Second child: 2 candies
- Third child: 1 candy

The third child gets 1 candy because it satisfies the conditions.

---

### Solution 💡

We can solve this problem using a **two-pass greedy approach**:

1. First pass: Traverse from left to right. For each child, if the current child has a higher rating than the previous child, give more candy.
2. Second pass: Traverse from right to left. For each child, if the current child has a higher rating than the next child, adjust the candy count to satisfy the condition.

#### Java

```java
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        
        // Step 1: Give each child 1 candy initially
        Arrays.fill(candies, 1);

        // Step 2: Traverse left to right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Step 3: Traverse right to left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Sum up the total number of candies
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }
}

```

### Time Complexity ⏳
- The time complexity is **O(n)** because we are traversing the array twice (left-to-right and right-to-left), where `n` is the length of the `ratings` array.

### Space Complexity 💾
- The space complexity is **O(n)** because we are using an extra array to store the number of candies for each child.