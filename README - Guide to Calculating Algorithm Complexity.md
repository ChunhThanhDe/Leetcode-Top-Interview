# Guide to Calculating Algorithm Complexity 🚀

## 1. Time Complexity ⏱️

### General Formula 📏
Time complexity measures the number of operations an algorithm performs relative to the size of its input. It is usually expressed using Big-O notation to determine how the number of operations grows as the input size increases.

- **O(1)**: The algorithm requires a **fixed number of operations**, regardless of the input size. For example: accessing an element in an array. 📦
- **O(log n)**: The algorithm reduces the input size **exponentially** at each step. For example: binary search. 🔍
- **O(n)**: The algorithm needs to **traverse through the entire input** once. For example: iterating through an array or list. 📋
- **O(n log n)**: The algorithm performs **divide and conquer** and sorting. For example: QuickSort or MergeSort. 🛠️
- **O(n²)**: The algorithm requires **nested iterations** through the entire input. For example: Bubble Sort. 🔄
- **O(2^n)**: The complexity increases **exponentially**, often seen in non-optimized recursive problems. For example: naive Fibonacci sequence calculation. 📈

### How to Determine Time Complexity 🧮
1. **Identify Loops**: Consider how many times the loops execute based on the input size. 🔁
2. **Consider Recursion**: Evaluate how each recursive call affects the problem size (divide or increase). 🔄
3. **Discard Less Important Factors**: Only keep the term with the **fastest growth rate** as the input size increases. 📉

### Example Calculations 📊:
- An algorithm that iterates through an array has a time complexity of **O(n)**, where n is the size of the array. 📜
- A binary search algorithm on a sorted array has a time complexity of **O(log n)**. 📚

## 2. Space Complexity 💾

### General Formula 🧩
Space complexity measures the **additional memory** an algorithm uses relative to the size of its input.

- **O(1)**: The algorithm uses **a fixed amount of memory**, regardless of the input size. 🗃️
- **O(n)**: Memory usage is **proportional** to the input size. For example: storing an array or list. 🗂️
- **O(n²)**: Memory usage grows **quadratically** with the input size. For example: storing a matrix or result table. 🗃️🗃️

### How to Determine Space Complexity 📏
1. **Check Additional Variables**: Consider the number of variables or data structures the algorithm creates. 🧮
2. **Consider Recursion**: Evaluate how the storage of state in each recursive call affects memory usage. 🗃️

### Example Calculations 🧾:
- An algorithm that uses a fixed number of variables has a space complexity of **O(1)**. 📦
- An algorithm that requires creating a new array of size proportional to the input size has a space complexity of **O(n)**. 🗃️

## 3. Conclusion 🏁
To accurately calculate the time and space complexity of an algorithm, consider the structure of loops, recursion, and additional data structures used. **Ignore less significant constants and factors**, and focus on the components with the **fastest growth rate** as the input size increases. 🚀
