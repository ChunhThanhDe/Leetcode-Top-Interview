## Candy

### Description
There are `n` children standing in a row. Each child is assigned a rating value given in the `ratings` integer array.

You are giving candy to the children under the following conditions:

- Each child must have at least one piece of candy.
- Children with higher ratings (larger rating values) will receive more candy than their neighbors with lower ratings.

Return the minimum amount of candy you need to distribute candy to children.

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
You can allocate to the first, second, and third child with 2, 1, 2 candies respectively.

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
You can allocate to the first, second, and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.

### Constraints

- `n == ratings.length`
- `1 <= n <= 2 * 10^4`
- `0 <= ratings[i] <= 2 * 10^4`