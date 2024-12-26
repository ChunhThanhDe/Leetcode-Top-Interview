/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-12-25 08:30:48
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next){this.val = val; this.next = next;}
}


// input: 2 sorted linked lists `list1` and `list2`
// output head of the sorted merged linked list

class Solution{
    public ListNode mergeTwoList(ListNode list1, ListNode list2){
        // create a dummy node as the head of the merged list
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Compare nodes from both lists and merge them
        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // attach the remaining nodes form list1 and list2 after one on two null
        if (list1 != null){
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next;
    }
}


class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: list1 = [1,2,4], list2 = [1,3,4]
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode mergedList1 = solution.mergeTwoList(list1, list2);
        System.out.println("Test case 1:");
        printList(mergedList1); // Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4

        // Test case 2: list1 = [], list2 = []
        ListNode list3 = null;
        ListNode list4 = null;

        ListNode mergedList2 = solution.mergeTwoList(list3, list4);
        System.out.println("Test case 2:");
        printList(mergedList2); // Output: (empty)

        // Test case 3: list1 = [], list2 = [0]
        ListNode list5 = null;
        ListNode list6 = new ListNode(0);

        ListNode mergedList3 = solution.mergeTwoList(list5, list6);
        System.out.println("Test case 3:");
        printList(mergedList3); // Output: 0
    }

    // Print linked list inline
    private static void printList(ListNode head) {
        if (head == null) {
            System.out.println("(empty)");
            return;
        }

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