## 6. Zigzag Conversion 🔀

**Difficulty**: `Medium` - **Tags**: `String`, `Simulation`

[LeetCode Problem Link](https://leetcode.com/problems/zigzag-conversion/)

### Description

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:

```
P   A   H   N
A P L S I I G
Y   I   R
```

And then read line by line: "PAHNAPLSIIGYIR".

Write the code that will take a string and make this conversion given a number of rows.

```java
string convert(string s, int numRows);
```

### Examples

**Example 1:**

Input:
```java
s = "PAYPALISHIRING"
numRows = 3
```

Output:
```
"PAHNAPLSIIGYIR"
```

**Example 2:**

Input:
```java
s = "PAYPALISHIRING"
numRows = 4
```

Output:
```
"PINALSIGYAHRPI"
```

Explanation:
```
P     I    N
A   L S  I G
Y A   H R
P     I
```

**Example 3:**

Input:
```java
s = "A"
numRows = 1
```

Output:
```
"A"
```

### Constraints

- The input string `s` consists of printable ASCII characters.
- `numRows` is an integer in the range [1, 1000].

### Solution 💡

To solve this problem, we simulate the zigzag pattern by appending characters to each row based on their current position. We traverse the string `s` and update the direction (up or down) when reaching the first or last row. After processing all characters, we concatenate the rows to get the final result.

#### Java

```java
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[Math.min(numRows, s.length())];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
```

#### Time Complexity ⏳

- **O(n)**: The time complexity is linear, where `n` is the length of the string `s`.

#### Space Complexity 💾

- **O(n)**: The space complexity is also linear, as we are storing the zigzag pattern in a list of string builders.

You can find the full solution [here](Solution.java).