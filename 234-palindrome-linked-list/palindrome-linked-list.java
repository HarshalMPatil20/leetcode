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
    public boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println(slow.val);

        fast = head;

        Stack <Integer> s = new Stack<>();

        while(slow != null){
            s.add(slow.val);
            slow = slow.next;
        }

        System.out.println(s);

        while(!s.isEmpty()){
            if(fast.val != s.pop()) return false;
            fast = fast.next;
        }

        return true;
        
    }
}