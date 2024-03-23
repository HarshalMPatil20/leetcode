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

     public ListNode Mid(ListNode head){ 
        ListNode slow = head;
        ListNode fast = head;

        while( fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
       }


    public void reorderList(ListNode head) {
    ListNode middle = Mid(head);
    ListNode new_head = reverseList(middle);

    ListNode first = head;
    ListNode second = new_head;

    while(first != null){
       
       ListNode temp1 = first.next;
       ListNode temp2 = second.next;

        first.next = second;
        second.next = temp1;

        first = temp1;
        second = temp2;

    }

    }
}