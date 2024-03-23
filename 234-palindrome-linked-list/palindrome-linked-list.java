/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // Function to Reverse Linked List given Head Pointer
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        // Step 1 - Find the middle of linked list
        ListNode slow = head;
        ListNode fast = head;

        while( fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // now middle of list = slow.next
        // Step 2 - Reverse the linked list from Middle
        ListNode new_head = reverseList(slow.next);

        // Step 3 - Take to temperory pointers for first head and second head and Compare the list
        ListNode first = head;
        ListNode second = new_head;

        while(second != null){

            if(first.val != second.val){
                reverseList(new_head);
                return false;
            }
            first= first.next;
            second = second.next;
        }
       // Step 4 - Reverse the second half of list again to make it as it was!
        reverseList(new_head);
         return true;

    }
}
