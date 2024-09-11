# Guide to Calculating Algorithm Complexity 🚀

## 1. Time Complexity ⏱️

**General Formula 📏**

Time complexity measures how the number of operations an algorithm performs grows relative to the size of its input. It is often expressed using Big-O notation to indicate growth rates.

### Complexity Classes

- **O(1)**: Fixed number of operations regardless of input size.
  - *Example*: Accessing an element in an array. 📦
  ```java
  int element = array[5]; // Constant time operation
  ```
  - **Input Size (n)**: Any size of array
  - **Result**: Time complexity = **O(1)**

- **O(log n)**: Operations reduce the input size exponentially at each step.
  - *Example*: Binary search in a sorted array. 🔍
  ```java
  while (low <= high) {
      int mid = (low + high) / 2;
      if (array[mid] == target) return mid;
      if (array[mid] < target) low = mid + 1;
      else high = mid - 1;
  }
  ```
  - **Input Size (n)**: Size of the sorted array
  - **Example Calculation**:
    - For an array of size \( n = 16 \):
      - Steps: 16, 8, 4, 2, 1
      - Number of operations = \( \log_2(16) = 4 \)
  - **Result**: Time complexity = **O(log n)**

- **O(n)**: Operations scale linearly with the input size.
  - *Example*: Iterating through an array or list. 📋
  ```java
  for (int i = 0; i < n; i++) {
      // Process each element
  }
  ```
  - **Input Size (n)**: Size of the array
  - **Example Calculation**:
    - For an array of size \( n = 10 \):
      - Number of operations = 10
  - **Result**: Time complexity = **O(n)**

- **O(n log n)**: Typically seen in divide and conquer algorithms.
  - *Example*: MergeSort or QuickSort. 🛠️
  ```java
  mergeSort(array, left, right);
  ```
  - **Input Size (n)**: Size of the array
  - **Example Calculation**:
    - For an array of size \( n = 8 \):
      - Number of operations = \( 8 \times \log_2(8) = 24 \)
  - **Result**: Time complexity = **O(n log n)**

- **O(n²)**: Operations involve nested iterations over the input.
  - *Example*: Bubble Sort. 🔄
  ```java
  for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - i - 1; j++) {
          // Swap if needed
      }
  }
  ```
  - **Input Size (n)**: Size of the array
  - **Example Calculation**:
    - For an array of size \( n = 5 \):
      - Number of operations = \( 5 \times 5 = 25 \)
  - **Result**: Time complexity = **O(n²)**

- **O(2^n)**: Complexity grows exponentially, often seen in naive recursive solutions.
  - *Example*: Naive Fibonacci calculation. 📈
  ```java
  if (n <= 1) return n;
  return fibonacci(n - 1) + fibonacci(n - 2);
  ```
  - **Input Size (n)**: Position in the Fibonacci sequence
  - **Example Calculation**:
    - For \( n = 4 \):
      - Number of operations = \( 2^4 = 16 \)
  - **Result**: Time complexity = **O(2^n)**

### How to Determine Time Complexity 🧮

1. **Identify Loops**: Count the number of iterations and how they depend on input size. 🔁
2. **Consider Recursion**: Evaluate how recursive calls affect problem size. 🔄
3. **Discard Less Important Factors**: Focus on the term with the fastest growth rate as input size increases. 📉

### Example Calculations 📊

- **Iterating through an array**: Time complexity is **O(n)** where \( n \) is the array size. 📜
- **Binary Search**: Time complexity is **O(log n)** for a sorted array. 📚

## 2. Space Complexity 💾

**General Formula 🧩**

Space complexity measures the additional memory an algorithm uses relative to the input size.

### Complexity Classes

- **O(1)**: Fixed amount of memory used regardless of input size.
  - *Example*: Using a few variables. 🗃️
  ```java
  int count = 0; // Constant space
  ```
  - **Input Size (n)**: Any size of input
  - **Result**: Space complexity = **O(1)**

- **O(n)**: Memory usage is proportional to the input size.
  - *Example*: Storing an array. 🗂️
  ```java
  int[] array = new int[n]; // Linear space
  ```
  - **Input Size (n)**: Size of the array
  - **Example Calculation**:
    - For an array of size \( n = 10 \):
      - Memory usage = 10 units
  - **Result**: Space complexity = **O(n)**

- **O(n²)**: Memory usage grows quadratically with input size.
  - *Example*: Storing a matrix. 🗃️🗃️
  ```java
  int[][] matrix = new int[n][n]; // Quadratic space
  ```
  - **Input Size (n)**: Size of the matrix
  - **Example Calculation**:
    - For a matrix of size \( n = 4 \):
      - Memory usage = \( 4 \times 4 = 16 \) units
  - **Result**: Space complexity = **O(n²)**

### How to Determine Space Complexity 📏

1. **Check Additional Variables**: Consider the number of variables or data structures used. 🧮
2. **Consider Recursion**: Evaluate how each recursive call affects memory usage. 🗃️

### Example Calculations 🧾

- **Fixed number of variables**: Space complexity is **O(1)**. 📦
- **Creating an array of size \( n \)**: Space complexity is **O(n)**. 🗃️

## 3. Conclusion 🏁

To calculate the time and space complexity of an algorithm:

- Examine loops, recursion, and additional data structures.
- Focus on terms with the fastest growth rates as the input size increases. 🚀

---
