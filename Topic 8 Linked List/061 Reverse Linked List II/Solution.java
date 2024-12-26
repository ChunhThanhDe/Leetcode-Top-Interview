// Definition fod singly linked list
class ListNode {
    int val;
    ListNode next;
    ListNode (){}
    ListNode(int val){
        this.val = val;
    }
    ListNode (int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

// input: Head a singly linked list, 2 int `left`, `right`
// output: Head of reversed Linked list after reverse the nodes of the list from position left to position right

public class Solution {
    public ListNode reverseLinkedList(ListNode head, int left, int right){
        if (head == null || left == right) return head;

        // create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Mode `prev to the node `left` before the reversal starts
        for (int i = 1; i < left; i++){
            prev = prev.next;
        }

        // `star` point to the first node to be reversed
        ListNode start = prev.next;

        // `then` is the node after `start`
        ListNode then = start.next;

        // Reverse the sublist
        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }

        return dummy.next;
    }
}


// test case unit testtest
class Main {
    public static void main(String[] args) {
        // Test Case 1: head = [1,2,3,4,5], left = 2, right = 4
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        Solution solution = new Solution();
        ListNode result1 = solution.reverseLinkedList(head1, 2, 4);

        System.out.print("Reversed List 1: ");
        printList(result1); // Expected output: [1,4,3,2,5]

        // Test Case 2: head = [5], left = 1, right = 1
        ListNode head2 = new ListNode(5);

        ListNode result2 = solution.reverseLinkedList(head2, 1, 1);

        System.out.print("Reversed List 2: ");
        printList(result2); // Expected output: [5]
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}


