## Reverse Words in a String

📜 Given an input string `s`, reverse the order of the words.

🔡 A word is defined as a sequence of non-space characters. The words in `s` will be separated by at least one space.

💫 Return a string of the words in reverse order concatenated by a single space.

⚠️ Note that `s` may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

### Examples

🔹 **Example 1:**

Input:
```python
s = "the sky is blue"
```

Output:
```
"blue is sky the"
```

🔹 **Example 2:**

Input:
```python
s = "  hello world  "
```

Output:
```
"world hello"
```

Explanation:
Your reversed string should not contain leading or trailing spaces.

🔹 **Example 3:**

Input:
```python
s = "a good   example"
```

Output:
```
"example good a"
```

Explanation:
You need to reduce multiple spaces between two words to a single space in the reversed string.

### Constraints

🔸 The input string `s` contains only printable ASCII characters.
🔸 `s` does not contain any leading or trailing spaces.
🔸 The words in `s` will be separated by a single space.