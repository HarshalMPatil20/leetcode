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
    public ListNode rotateRight(ListNode head, int k) {

        if(head==null || head.next == null){
            return head;
        }

        ListNode tail = head;
        int count = 1;

        while(tail.next != null){
            tail = tail.next;
            count++;
        }

        System.out.println(tail.val);
        System.out.println(count);

        tail.next = head;

        for(int i = 0; i<count-(k%count);i++){
            tail = tail.next;
        }

        System.out.println(tail.next.val);

        head = tail.next;

        tail.next = null;

        return head;


        
    }
}