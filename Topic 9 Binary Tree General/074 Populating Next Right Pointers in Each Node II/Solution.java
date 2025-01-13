/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2025-01-13 08:17:27
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */


 // Definition for a Node
class Node {
    int val;
    Node left;
    Node right;
    Node next;

    Node(){}

    Node (int val){
        this.val = val;
    }

    Node (int val, Node left, Node right, Node next){
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}

// input: Head root of the binary tree
// output: Head root of the binary tree after connecting
class Solution {
    public Node connect (Node root){
        if (root == null) return null;

        // Initialize the current level
        Node current = root;
        // Dummy head to help link nodes in the next level
        Node dummyHead = new Node(0);
        // Pointer to track the last connected node in the next level
        Node prev = dummyHead;

        // Loop through levels of the tree
        while (current != null){
            // through all nodes in the current level
            while (current != null){
                // connext node in the next level
                //
                // if the current node has a left child, connect it
                if (current.left != null){
                    prev.next = current.left;
                    prev = prev.next; // Move the pointer forward 
                }
                // if the current node has a right child, connect it
                if (current.right != null){
                    prev.next = current.right;
                    prev = prev.next;
                }

                // Move to the next Node in the current level
                current = current.next;
            }

            // Move to the next level using dummyHead's next pointer
            current = dummyHead.next;
            // reset the dummyHead and for the next level
            dummyHead.next = null;

            // reset the pointer to the dummy head for the next level
            prev = dummyHead;
        }

        // return the root with all connections made
        return root;
    }
}

// unit test
class Main{
    public static void main(String[] args) {
        // Create the input tree: [1, 2, 3, 4, 5, null, 7]
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);

        // Solution instance
        Solution solution = new Solution();

        // Run the connect method
        Node result = solution.connect(root);

        // Print the result
        System.out.println("Output: " + printTreeWithNext(result));
    }

    private static String printTreeWithNext(Node root) {
        if (root == null) return "[]";
    
        StringBuilder result = new StringBuilder();
        Node current = root;
    
        result.append("[");

        while (current != null) {
            Node temp = current;
            while (temp != null) {
                result.append(temp.val).append(", ");
                temp = temp.next;
            }
            result.append("#, "); // End of level
            current = current.left != null ? current.left : current.right; // Move to next level
        }

        result.replace(result.length() - 2, result.length(), "]");
    
        return result.toString().trim();
    }
}