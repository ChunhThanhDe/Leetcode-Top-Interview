/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-12-31 08:50:08
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

class ListNode {
    int val;
    ListNode next;
    ListNode (int val){
        this.val = val;
    }
    ListNode(){}
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

// input: head of a sorted linked list
// output: head of new sorted linked list that delete all nodes duplicate
class Solution {
    public ListNode removeDuplicate (ListNode head){

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy; // points to the last node in the result list

        while (head != null){
            // if current node has duplicates
            if (head.next != null && head.val == head.next.val){
                // Skip all nodes with the same value
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }

                // Remove duplicates
                prev.next = head.next;
            } else {
                // Move prev forward if no duplicates
                prev = prev.next;
            }
            // Move head forward
            head = head.next;
        }

        return dummy.next;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode (2);
        head1.next.next = new ListNode (3);
        head1.next.next.next = new ListNode (3);
        head1.next.next.next.next = new ListNode (4);
        head1.next.next.next.next.next = new ListNode (4);
        head1.next.next.next.next.next.next = new ListNode (5);

        printList(solution.removeDuplicate(head1));
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
