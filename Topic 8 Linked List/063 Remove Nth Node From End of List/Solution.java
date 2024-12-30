/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-12-30 08:49:45
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode (int val){ this.val = val;}
    ListNode (int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

// input: head of ListNode input and int n, locate to remove from the end of ListNode
// output: head of ListNode after remove

class Solution {
    public ListNode removeNthNodeFromEnd(ListNode head, int n){
        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        // step 1; find nth node from the end
        // Move first pointer n+1 steps ahead to maintain a gap of n nodes
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Move both pointers until first reaches the end
        //
        // Both the first and second pointers are moved one step at a time until first points to the end of the list.
        // Since first has been moved forward n + 1 steps,
        // when first reaches the end of the list,
        // the second pointer will stop right
        // before the node to be deleted (i.e. the nth node from the end).
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dummy.next;
    }
}

// test case
class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        int n1 = 2;
        System.out.print("Test Case 1 - Before Removing: ");
        printList(head1);

        ListNode result1 = solution.removeNthNodeFromEnd(head1, n1);

        System.out.print("Test Case 1 - After Removing: ");
        printList(result1);

        // Test Case 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);

        int n2 = 1;
        System.out.print("Test Case 2 - Before Removing: ");
        printList(head2);

        ListNode result2 = solution.removeNthNodeFromEnd(head2, n2);

        System.out.print("Test Case 2 - After Removing: ");
        printList(result2);
    }

    // Helper function to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}

