/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head_1 = l1;
        ListNode head_2 = l2;
        ListNode head = new ListNode();
        ListNode result = head;
        int sum = 0;
        int add1 = 0;
        int add2 = 0;

        while (head_1 != null || head_2 != null || sum !=0) {
            if (head_1 != null) {
                sum += head_1.val;
                head_1 = head_1.next;
            }
            if (head_2 != null) {
                sum += head_2.val;
                head_2 = head_2.next;
            }


            head.next = new ListNode(sum % 10);
            // NewNode = head;
            head = head.next;
            sum = sum / 10;

        }
        return result.next;
    }
}