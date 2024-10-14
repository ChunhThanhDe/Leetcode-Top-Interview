# 🤹‍♀️ Group Anagrams 🤹‍♂️

Given an array of strings `strs`, this function groups the anagrams together. The function can return the answer in any order.

An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

## 🔍 Example Usage

### 🟢 Example 1

```
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
```

### 🟢 Example 2

```
Input: strs = [""]
Output: [[""]]
```

### 🟢 Example 3

```
Input: strs = ["a"]
Output: [["a"]]
```

## 📝 Constraints

- `1 <= strs.length <= 10^4`
- `0 <= strs[i].length <= 100`
- `strs[i]` consists of lowercase English letters.