/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-12-31 09:26:30
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

class ListNode {
    int val;
    ListNode next;
    ListNode (){}
    ListNode (int val){
        this.val = val;
    }
    ListNode (int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

// input: head of linked list, and int k
// output: head of rotate linked list that rotate to the right by k places
class Solution {
    public ListNode rotateList (ListNode head, int k){
        if (head == null || k == 0) return head;

        // step 1: Calculate the length of linked list
        ListNode current = head;
        int length = 1;
        while (current.next != null){
            current = current.next;
            length ++;
        }

        // Step 2: connext tail with head to cteate a circle
        current.next = head;

        //step 3: find new tail position
        int newTailPosition = length - (k % length);

        // step 4: Traverse to the newtail and break the circle
        ListNode newTail = head;
        for (int i = 1; i < newTailPosition; i++){
            newTail = newTail.next;
        }

        // step 5: define new head and break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

}

// unit test
class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode (2);
        head1.next.next = new ListNode (3);
        head1.next.next.next = new ListNode (4);
        head1.next.next.next.next = new ListNode (5);

        printList(solution.rotateList(head1, 2));
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

