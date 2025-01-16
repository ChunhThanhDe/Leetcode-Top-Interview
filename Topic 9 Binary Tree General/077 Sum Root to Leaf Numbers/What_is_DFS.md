### What is DFS?

DFS (**Depth First Search**) is an algorithm for traversing or searching a tree or graph. DFS focuses on exploring one branch as deep as possible before backtracking and exploring another branch. It is one of the two most common graph traversal methods, alongside **BFS (Breadth First Search)**.

---

### Characteristics of DFS:

1. **Working Principle**: DFS works based on the **stack** data structure:
   - **Recursive approach**: The call stack is used implicitly during recursive function calls.
   - **Iterative approach**: A manual stack is used to keep track of nodes.

2. **How it works**:
   - Start from a root node.
   - Visit one unvisited adjacent node and continue visiting deeper nodes until there are no unvisited nodes left.
   - Backtrack to the previous node to explore remaining unvisited nodes.
   - Repeat this process until all nodes have been visited.

---

### DFS Implementation:

DFS can be implemented using:
1. **Recursive Approach**:
   - Uses recursive calls to handle the stack operations internally.
2. **Iterative Approach**:
   - Uses a stack explicitly to manage traversal.

---

### DFS Pseudocode:

#### 1. **Recursive Implementation**:
```java
void dfs(Node node) {
    if (node == null) return; // Base case: empty node
    visited[node] = true; // Mark the node as visited

    for (Node neighbor : node.neighbors) { // Explore all neighbors
        if (!visited[neighbor]) {
            dfs(neighbor); // Recursively visit unvisited neighbors
        }
    }
}
```

#### 2. **Iterative Implementation (Using Stack)**:
```java
void dfs(Node start) {
    Stack<Node> stack = new Stack<>();
    stack.push(start); // Add the starting node to the stack

    while (!stack.isEmpty()) {
        Node node = stack.pop(); // Get the top node from the stack

        if (!visited[node]) {
            visited[node] = true; // Mark the node as visited

            for (Node neighbor : node.neighbors) { // Add unvisited neighbors to the stack
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }
    }
}
```

---

### Applications of DFS:

1. **Connectivity Check**: Determine if two nodes in a graph are connected.
2. **Pathfinding**: Solve maze problems or similar pathfinding challenges.
3. **Cycle Detection**: Detect cycles in a graph.
4. **Topological Sorting**: Solve scheduling problems.
5. **Find Connected Components**: Divide a graph into independent subgraphs. 

DFS is powerful and widely used in problem-solving, especially in graph and tree-related problems.