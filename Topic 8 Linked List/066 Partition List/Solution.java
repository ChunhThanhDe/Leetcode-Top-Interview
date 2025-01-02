/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2025-01-02 08:22:29
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


// **Detailed Explanation:**
//
// **Input:**
// - `head`: The head of the linked list.
// - `x`: A comparison value.
//
// **Desired Outcome:**
// - Rearrange the linked list while preserving the original relative order of elements within each group.
// - Elements less than `x` should be grouped together and placed before the group of elements greater than or equal to `x`.
//
// **Example:**
//
// **Input:**
// - Linked list: `1 -> 4 -> 3 -> 2 -> 5 -> 2`
// - `x = 3`
//
// **Output:**
// - `1 -> 2 -> 2 -> 4 -> 3 -> 5`
// - (Group `< 3`: `1, 2, 2` appear first; group `>= 3`: `4, 3, 5` retain their original order.)
//
// Input: Head of Linked list input , int x
// output: Head of Linked list after elative order of the nodes
public class Solution {
    public ListNode partition (ListNode head, int x){
        // Dummy nodes for the two partitions
        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);

        // Pointers for building partitions
        ListNode less = lessHead;
        ListNode greater = greaterHead;

        // check the list to get less and greater head
        while (head != null){
            if (head.val < x){
                less.next = head; // add to the less partition
                less = less.next;
            } else {
                greater.next = head; //  add to the greater partition
                greater = greater.next;
            }
            head = head.next;
        }

        // End the greater partition to avoid cycles
        greater.next = null;

        // connect the two partitions
        less.next = greaterHead.next;

        return lessHead.next;

    }
}

// unit test
class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode (4);
        head1.next.next = new ListNode (3);
        head1.next.next.next = new ListNode (2);
        head1.next.next.next.next = new ListNode (5);
        head1.next.next.next.next.next = new ListNode (2);

        printList(solution.partition(head1, 3));
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
