/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2025-01-02 09:24:35
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

// Class to implement LRU Cache
import java.util.HashMap;

class LRUCache  {

    private class Node {
        int key, value; // Node stores key and value
        Node prev, next; // pointer to previous and next nodes

        Node (int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity; // Maximum capacity of the cache
    private final HashMap<Integer, Node> map;
    private final Node head, tail;

    // input: int capacity
    // ouput: none
    public LRUCache(int capacity){
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0); // dummy head node
        this.tail = new Node(0,0); // dummy tail node
        head.next = tail;
        tail.prev = head;
    }

    // input: int key
    // output: Value of the key of -1 if not found
    public int get(int key) {
        if (map.containsKey(key)){ // check if key exits
            Node node = map.get(key);
            remove(node); // remove Node from its current position
            insert(node); // insert node at the front
            return node.value;
        }

        return -1; // key not found
    }

    // input: int key, int value
    // outout: None
    public void put (int key, int value){
        if (map.containsKey(key)){
            remove(map.get(key)); // remove existing key if present
        }
        if (map.size() == capacity) {
            remove(tail.prev); // remove the least recemtly used node
        }
        insert(new Node(key, value)); // Insert the new Node
    }

    // Input: Node to remove
    private void remove (Node node){
        map.remove(node.key); // Remove node from the map
        node.prev.next = node.next; // Unlink node from previous node
        node.next.prev = node.prev; // Unlink node from next node
    }

    // Input: Node to insert
    private void insert(Node node) {
        map.put(node.key, node); // Add node to the map
        node.next = head.next; // Link node to the current first node
        head.next.prev = node; // Update previous pointer of the first node
        head.next = node; // Update next pointer of head
        node.prev = head; // Link node to head
    }
}

// unit test
class Main {
    public static void main(String[] args) {
        // Initialize LRUCache with capacity 2
        LRUCache lruCache = new LRUCache(2);

        // Test case simulation
        lruCache.put(1, 1); // Cache: {1=1}
        lruCache.put(2, 2); // Cache: {1=1, 2=2}
        System.out.println(lruCache.get(1)); // Returns 1
        lruCache.put(3, 3); // Evicts key 2, Cache: {1=1, 3=3}
        System.out.println(lruCache.get(2)); // Returns -1 (not found)
        lruCache.put(4, 4); // Evicts key 1, Cache: {4=4, 3=3}
        System.out.println(lruCache.get(1)); // Returns -1 (not found)
        System.out.println(lruCache.get(3)); // Returns 3
        System.out.println(lruCache.get(4)); // Returns 4
    }
}

