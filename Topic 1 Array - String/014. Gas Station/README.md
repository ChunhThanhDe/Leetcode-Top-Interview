## 134. Gas Station ⛽

**Difficulty**: `Medium` - **Tags**: `Greedy`, `Array`

### Description
There are `n` gas stations along a circular route, where the amount of gas at the `ith` station is `gas[i]`.

You have a car with an unlimited gas tank and it costs `cost[i]` of gas to travel from the `ith` station to its next `(i + 1)th` station. You begin the journey with an empty tank at one of the gas stations.

Given two integer arrays `gas` and `cost`, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique.

### Examples

**Example 1:**

Input:
```python
gas = [1,2,3,4,5]
cost = [3,4,5,1,2]
```

Output:
```
3
```

Explanation:
Start at station 3 (index 3) and fill up with 4 units of gas. Your tank = 0 + 4 = 4.  
- Travel to station 4. Your tank = 4 - 1 + 5 = 8.  
- Travel to station 0. Your tank = 8 - 2 + 1 = 7.  
- Travel to station 1. Your tank = 7 - 3 + 2 = 6.  
- Travel to station 2. Your tank = 6 - 4 + 3 = 5.  
- Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.  
Therefore, return 3 as the starting index.

**Example 2:**

Input:
```python
gas = [2,3,4]
cost = [3,4,3]
```

Output:
```
-1
```

Explanation:
You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
Let's start at station 2 and fill up with 4 units of gas. Your tank = 0 + 4 = 4.  
- Travel to station 0. Your tank = 4 - 3 + 2 = 3.  
- Travel to station 1. Your tank = 3 - 3 + 3 = 3.  
You cannot travel back to station 2, as it requires 4 units of gas but you only have 3.  
Therefore, you can't travel around the circuit once no matter where you start.

---

### Solution 💡

The solution uses a greedy approach. The key idea is:
- If the total gas is less than the total cost, it's impossible to complete the circuit.
- If you can't reach station `i+1` from station `i`, it means that starting from any station between `0` and `i` will not work either. Therefore, start fresh from station `i+1`.

#### Java

```java
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0, currentTank = 0, startStation = 0;
        for (int i = 0; i < gas.length; i++) {
            totalTank += gas[i] - cost[i];
            currentTank += gas[i] - cost[i];
            if (currentTank < 0) {
                // If we can't reach station i+1, start from i+1
                startStation = i + 1;
                currentTank = 0;
            }
        }
        return totalTank >= 0 ? startStation : -1;
    }
}
```

**With Example 1 an this solution**

| Station | Gas | Cost | Gas - Cost | Current Tank | Total Tank | Explanation |
|---------|-----|------|------------|--------------|------------|-------------|
| 0       | 1   | 3    | -2         | -> 0         | -2         | Not enough gas to continue, move to next station |
| 1       | 2   | 4    | -2         | -> 0         | -4         | Not enough gas to continue, move to next station |
| 2       | 3   | 5    | -2         | -> 0         | -6         | Not enough gas to continue, move to next station |
| 3       | 4   | 1    | 3          | 3            | -3         | Enough gas to continue, check if the circuit can be completed |
| 4       | 5   | 2    | 3          | 6            | 0          | Continue with sufficient gas, travel to next station |
| 0       | 1   | 3    | -2         | 4            | -2         | Continue with sufficient gas, move to next station |
| 1       | 2   | 4    | -2         | 2            | -2         | Continue with sufficient gas, move to next station |
| 2       | 3   | 5    | -2         | 0            | -2         | Continue with sufficient gas, move to next station |
| 3       | 4   | 1    | 3          | 3            | 1          | Completed the circuit with enough gas |

##### Explanation of the Columns:

- **Station**: The index of the gas station.
- **Gas**: The amount of gas available at the station.
- **Cost**: The cost to travel to the next station.
- **Gas - Cost**: The difference between the gas available and the cost to travel.
- **Current Tank**: The running total of gas after filling up and traveling to next gas, which is reset to 0 when moving to next station is impossible.
- **Total Tank**: The overall surplus or deficit of gas after each station, updated cumulatively.

#### Time Complexity ⏳
- We traverse the array once, making the time complexity **O(n)**, where `n` is the number of stations.

#### Space Complexity 💾
- The space complexity is **O(1)** since no extra space is used, just a few variables to store sums and indices.

You can find the full `Solution.java` file [here](Solution.java).