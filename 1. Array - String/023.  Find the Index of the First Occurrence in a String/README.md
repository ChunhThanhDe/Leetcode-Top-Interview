##  Find the Index of the First Occurrence in a String

📜 Given two strings `needle` and `haystack`, return the index of the first occurrence of `needle` in `haystack`, or -1 if `needle` is not part of `haystack`.

### Examples

🔹 **Example 1:**

Input:
```python
haystack = "sadbutsad"
needle = "sad"
```

Output:
```
0
```

Explanation:
"sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

🔹 **Example 2:**

Input:
```python
haystack = "leetcode"
needle = "leeto"
```

Output:
```
-1
```

Explanation:
"leeto" did not occur in "leetcode", so we return -1.

### Constraints

🔸 The strings `haystack` and `needle` consist of lowercase English letters.