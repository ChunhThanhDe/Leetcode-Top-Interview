## ZigZag Conversion

📜 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:

```
P   A   H   N
A P L S I I G
Y   I   R
```

💫 And then read line by line: "PAHNAPLSIIGYIR"

🔡 Write the code that will take a string and make this conversion given a number of rows.

```python
string convert(string s, int numRows);
```

### Examples

🔹 **Example 1:**

Input:
```python
s = "PAYPALISHIRING"
numRows = 3
```

Output:
```
"PAHNAPLSIIGYIR"
```

🔹 **Example 2:**

Input:
```python
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

🔹 **Example 3:**

Input:
```python
s = "A"
numRows = 1
```

Output:
```
"A"
```

### Constraints

🔸 The input string `s` consists of printable ASCII characters.
🔸 `numRows` is an integer in the range [1, 1000].