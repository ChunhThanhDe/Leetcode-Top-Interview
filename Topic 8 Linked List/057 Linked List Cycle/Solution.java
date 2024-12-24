// Definition for singly-linked list
class ListNode {
    int val; // value of the current node
    ListNode next; // pointer to the next node in the list
    ListNode(int x){
        val = x;
        next = null;
    }
}

// input: head of a singly-linked list
// output: true if the list has a cycle. false otherwise
class Solution {
    public boolean hasCycle(ListNode head){
        // Check if the list is empty of has only one node (no cycle possible)
        if (head == null || head.next == null){
            return false;
        }

        // Initialize two pointers: slow moves one step, fast moves two steps
        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list with slow and fase pointers
        while (fast != null && fast.next != null){
            slow = slow.next; // slow moves one step
            fast = fast.next.next; // fast moves two steps

            // if slow and fast pointers meet, there is a cycle
            if (slow == fast){
                return true;
            }
        }

        return false; // No cycle detected
    }

}

// Unit testtest
class Main {
    public static void main(String[] args) {
        // Test case 1: head = [3,2,0,-4], pos = 1
        ListNode head1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Creates a cycle at node2

        Solution solution = new Solution();
        System.out.println(solution.hasCycle(head1)); // Output: true

        // Test case 2: head = [1,2], pos = 0
        ListNode head2 = new ListNode(1);
        ListNode node5 = new ListNode(2);
        head2.next = node5;
        node5.next = head2; // Creates a cycle at head2

        System.out.println(solution.hasCycle(head2)); // Output: true

        // Test case 3: head = [1], pos = -1 (no cycle)
        ListNode head3 = new ListNode(1);

        System.out.println(solution.hasCycle(head3)); // Output: false

        // Test case 4: Empty list (head = null)
        ListNode head4 = null;

        System.out.println(solution.hasCycle(head4)); // Output: false
    }
}
