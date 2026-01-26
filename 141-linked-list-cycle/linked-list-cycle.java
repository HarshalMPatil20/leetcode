/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
          // Initialize a pointer 'temp'
        // at the head of the linked list
        ListNode temp = head;

        // Create a map to keep track of
        // encountered nodes
        HashSet<ListNode> nodeMap = new HashSet<>();

        // Step 2: Traverse the linked list
        while (temp != null) {
            // If the node is already in the
            // map, there is a loop
            if (nodeMap.contains(temp)) {
                return true;
            }
            // Store the current node
            // in the map
            nodeMap.add(temp);

            // Move to the next node
            temp = temp.next;
        }

        // Step 3: If the list is successfully traversed 
        // without a loop, return false
        return false;
        
    }
}