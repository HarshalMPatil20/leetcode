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

        Stack<Integer> st = new Stack<>();

        ListNode p1=head;
        ListNode p2=head;

        while(p2!=null && p2.next!=null){
            st.push(p1.val);
            p1=p1.next;
            p2=p2.next.next;
        }

        if(p2!=null){   //for odd number of nodes in linked list
            p1=p1.next;
        }

        while(p1!=null){
            if(st.pop()!=p1.val) return false;
            p1=p1.next;
        }

        return true;
    }
}