/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-12-26 10:14:02
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

// Definition for singly ListNode
class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode (int val){this.val = val;}
    ListNode (int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

// input: head of a linked list, int k for reverse the nodes of the list with k node
// output: head of output modified list

class Solution {
    public ListNode reverseGroup(ListNode head, int k){
        if (head == null || k == 1) return head;

        // Create a dummy node and point it to the head of the list
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy, prev = dummy, next = dummy;

        //Count the total number of nodes in the list
        int count = 0;
        while (head != null){
            count ++;
            head = head.next;
        }

        // Reverse every k nodes in the list
        // Example: Initially, the linked list is 1 -> 2 -> 3 -> 4
        // `prev` points to a node before the List to be reversed (assume before node 1).
        // `curr` points to the first node in the List to be reversed (node 1).
        // `next` points to the next node (node 2).

        while ( count >= k){
            curr = prev.next;
            next = curr.next;
            // Reverse k nodes
            for (int i = 1; i < k; i ++){

                curr.next = next.next;  // Step 1: Skip the `next` node (node 2).
                                        // `curr` (node 1) now connects directly to node 3.
                                        // The list after this step: 1 -> 3 -> 4 (node 2 is temporarily detached).

                next.next = prev.next;  // Step 2: Insert the `next` node (node 2) at the beginning of the reversed segment.
                                        // `prev.next` initially points to node 1, so node 2 will now point to node 1.
                                        // The reversed segment after this step: 2 -> 1.

                prev.next = next;       // Step 3: Update `prev.next` to point to node 2 (the newly added node).
                                        // The full list after this step: prev -> 2 -> 1 -> 3 -> 4.

                next = curr.next;       // Step 4: Move `next` to the next node to process.
                                        // `curr.next` now points to node 3, so `next` also points to node 3.
                                        // Prepare for the next iteratio
            }

            prev = curr;
            count -= k;
        }

        return dummy.next;
    }
}

class Main {
    public static void main(String[] args) {
        // Test case 1
        ListNode head1 = createLinkedList(new int[]{1, 2, 3, 4, 5});
        int k1 = 3;
        Solution solution = new Solution();
        ListNode result1 = solution.reverseGroup(head1, k1);
        System.out.print("Result for head = [1,2,3,4,5], k = 3: ");
        printLinkedList(result1);

        // Test case 2
        ListNode head2 = createLinkedList(new int[]{1, 2, 3, 4, 5});
        int k2 = 2;
        ListNode result2 = solution.reverseGroup(head2, k2);
        System.out.print("Result for head = [1,2,3,4,5], k = 2: ");
        printLinkedList(result2);
    }

    // Utility method to create a linked list from an array
    private static ListNode createLinkedList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummy.next;
    }

    // Utility method to print a linked list
    private static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }
}

