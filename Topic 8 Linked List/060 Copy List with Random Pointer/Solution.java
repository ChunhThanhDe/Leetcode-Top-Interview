import java.util.HashMap;

class Node{
    int val;
    Node next;
    Node random;

    public Node(int val){
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

// input: A linked list Node of length n
// output: head of the copied linked list.

public class Solution {
    public Node copyRandomList(Node head){
        if (head == null) return null;

        // step 1: create a mapping of original nodes
        HashMap<Node, Node> map = new HashMap<>();
        Node current = head;

        while (current != null){
            map.put(current, new Node (current.val));
            current = current.next;
        }

        // step 2: Set the next and randow pointer fod the copied nodes
        current = head;
        while (current != null) {
            Node copy = map.get(current);
            copy.next = map.get(current.next);
            copy.random = map.get(current.random);
            current = current.next;

        }

        // Step 3: Return the copied head
        return map.get(head);
    }

}

// unit test
class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node head1 = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);

        head1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        head1.random = null;
        node1.random = head1;
        node2.random = node4;
        node3.random = node2;
        node4.random = head1;

        Node copiedList1 = solution.copyRandomList(head1);
        System.out.println("Test case 1:");
        printList(copiedList1); // Expected Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

        // Test case 2: head = []
        Node head2 = null;

        Node copiedList2 = solution.copyRandomList(head2);
        System.out.println("Test case 2:");
        printList(copiedList2); // Expected Output: (empty)
    }

    // Helper function to print the linked list with random pointers
    private static void printList(Node head) {
        if (head == null) {
            System.out.println("(empty)");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print("[" + current.val + ",");
            if (current.random != null) {
                System.out.print(current.random.val);
            } else {
                System.out.print("null");
            }
            System.out.print("] ");
            current = current.next;
        }
        System.out.println();
    }
}