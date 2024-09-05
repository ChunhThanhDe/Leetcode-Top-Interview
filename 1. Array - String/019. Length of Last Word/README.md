## Length of Last Word

📜 Given a string `s` consisting of words and spaces, return the length of the last word in the string.

🔡 A word is a maximal substring consisting of non-space characters only.

### Examples

🔹 **Example 1:**

Input:
```python
s = "Hello World"
```

Output:
```
5
```

Explanation:
The last word is "World" with length 5.

🔹 **Example 2:**

Input:
```python
s = "   fly me   to   the moon  "
```

Output:
```
4
```

Explanation:
The last word is "moon" with length 4.

🔹 **Example 3:**

Input:
```python
s = "luffy is still joyboy"
```

Output:
```
6
```

Explanation:
The last word is "joyboy" with length 6.

### Constraints

🔸 The input string `s` consists only of printable ASCII characters.
🔸 The input string `s` may contain leading or trailing spaces, but it will not contain multiple consecutive spaces.