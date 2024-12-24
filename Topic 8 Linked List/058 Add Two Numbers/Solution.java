
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


 class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // A dummy node to simplify code
        ListNode p = l1, q = l2, current = dummyHead;
        int carry = 0;

        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0; // Get value from l1 if p is not null, else 0
            int y = (q != null) ? q.val : 0; // Get value from l2 if q is not null, else 0
            int sum = carry + x + y; // Calculate sum
            carry = sum / 10; // Update carry
            current.next = new ListNode(sum % 10); // Add the sum modulo 10 to the result list
            current = current.next; // Move to the next node

            if (p != null) p = p.next; // Move to the next node in l1
            if (q != null) q = q.next; // Move to the next node in l2
        }

        if (carry > 0) { // If there is a remaining carry, add it
            current.next = new ListNode(carry);
        }

        return dummyHead.next; // Return the result, skipping the dummy node
    }
 }