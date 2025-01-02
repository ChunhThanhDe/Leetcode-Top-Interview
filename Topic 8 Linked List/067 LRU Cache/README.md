## 146. LRU Cache 🔗

**Difficulty**: `Medium` - **Tags**: `Design`, `Linked List`, `Hash Table`

[LeetCode Problem Link](https://leetcode.com/problems/lru-cache/)

---

### Problem Statement 📜

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the `LRUCache` class:

1. `LRUCache(int capacity)`: Initialize the LRU cache with positive size capacity.
2. `int get(int key)`: Return the value of the key if the key exists, otherwise return `-1`.
3. `void put(int key, int value)`:
   - Update the value of the key if it exists.
   - Add the key-value pair if the key does not exist.
   - If the number of keys exceeds the capacity, evict the least recently used key.

**Constraints**:
- The functions `get` and `put` must run in **O(1)** average time complexity.

---

### Examples 🌟

🔹 **Example 1**:

**Input**:

```plaintext
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
```

**Output**:

```plaintext
[null, null, null, 1, null, -1, null, -1, 3, 4]
```

**Explanation**:

```plaintext
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // return -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
```

---

### Constraints ⚙️

- `1 <= capacity <= 3000`
- `0 <= key <= 10⁴`
- `0 <= value <= 10⁵`
- At most `2 * 10⁵` calls will be made to `get` and `put`.

---

### Solution 💡

Use a combination of:
1. **HashMap**: For O(1) access to key-value pairs.
2. **Doubly Linked List**: For maintaining the order of usage (most recently used to least recently used).

---

#### Java Solution

```java
import java.util.HashMap;

class LRUCache {
    private class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final HashMap<Integer, Node> map;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}
```

---

### Explanation of the Solution

1. **Node Definition**:
   - Each node stores a key-value pair.
   - Nodes are linked in both directions to allow quick removal.

2. **HashMap**:
   - Maps keys to nodes for O(1) access.

3. **Doubly Linked List**:
   - The head points to the most recently used node.
   - The tail points to the least recently used node.

4. **Operations**:
   - `get`: Move the node to the head of the list.
   - `put`: Add the node to the head. If the cache exceeds capacity, remove the node at the tail.

---

### Time Complexity ⏳

- **O(1)** for both `get` and `put` operations.

### Space Complexity 💾

- **O(n)** for storing `n` key-value pairs in the HashMap and Doubly Linked List.

---

### Follow-up 🧐

The solution is optimized for LRU Cache implementation with constant time complexity and minimal space usage. Further optimizations could involve concurrent data structures for multi-threaded environments.

You can find the full solution [here](Solution.java).