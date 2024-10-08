## 12. Integer to Roman Conversion 🔢

**Difficulty**: `Medium` - **Tags**: `Math`, `Greedy`

[LeetCode Problem Link](https://leetcode.com/problems/integer-to-roman/description/)

### Description
Roman numerals are represented by seven different symbols:

| Symbol | Value |
|--------|-------|
| I      | 1     |
| V      | 5     |
| X      | 10    |
| L      | 50    |
| C      | 100   |
| D      | 500   |
| M      | 1000  |

Given an integer, convert it to a Roman numeral by breaking the integer into its decimal components and mapping them to corresponding Roman symbols.

### Examples

**Example 1:**

Input:
```java
num = 3749
```

Output:
```
"MMMDCCXLIX"
```

Explanation:
- 3000 = MMM (M + M + M)
- 700 = DCC (D + C + C)
- 40 = XL (X less than L)
- 9 = IX (I less than X)

**Example 2:**

Input:
```java
num = 58
```

Output:
```
"LVIII"
```

Explanation:
- 50 = L
- 8 = VIII

**Example 3:**

Input:
```java
num = 1994
```

Output:
```
"MCMXCIV"
```

Explanation:
- 1000 = M
- 900 = CM
- 90 = XC
- 4 = IV

### Constraints

- The input `num` is in the range [1, 3999].

## 12. Integer to Roman Conversion 🔢

**Difficulty**: `Medium` - **Tags**: `Math`, `Greedy`

[LeetCode Problem Link](https://leetcode.com/problems/integer-to-roman/description/)

### Description
Roman numerals are represented by seven different symbols:

| Symbol | Value |
|--------|-------|
| I      | 1     |
| V      | 5     |
| X      | 10    |
| L      | 50    |
| C      | 100   |
| D      | 500   |
| M      | 1000  |

Given an integer, convert it to a Roman numeral by breaking the integer into its decimal components and mapping them to corresponding Roman symbols.

### Examples

**Example 1:**

Input:
```java
num = 3749
```

Output:
```
"MMMDCCXLIX"
```

Explanation:
- 3000 = MMM (M + M + M)
- 700 = DCC (D + C + C)
- 40 = XL (X less than L)
- 9 = IX (I less than X)

**Example 2:**

Input:
```java
num = 58
```

Output:
```
"LVIII"
```

Explanation:
- 50 = L
- 8 = VIII

**Example 3:**

Input:
```java
num = 1994
```

Output:
```
"MCMXCIV"
```

Explanation:
- 1000 = M
- 900 = CM
- 90 = XC
- 4 = IV

### Constraints

- The input `num` is in the range [1, 3999].

### Solution 💡

To convert an integer to Roman numerals, we use a list of symbols representing each Roman numeral and their corresponding values. We subtract from the input number in descending order, appending the corresponding symbol to the result string each time.

#### Java

```java
class Solution {
    public String intToRoman(int num) {
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        StringBuilder romanNumeral = new StringBuilder();
        
        int i = 0;
        while (num > 0) {
            if (num >= values[i]) {
                romanNumeral.append(symbols[i]);
                num -= values[i];
            } else {
                i++;
            }
        }
        
        return romanNumeral.toString();
    }
}
```

#### Time Complexity ⏳
- **O(1)**: The time complexity is constant since the number of Roman symbols is fixed.

#### Space Complexity 💾
- **O(1)**: The space complexity is constant as we only use a few variables and a fixed-size array.

You can find the full solution [here](Solution.java).