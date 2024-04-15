/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int traversal(TreeNode root,int num){
        if(root==null) return 0;
         num *= 10;
        num+=root.val;
        
        if(root.left == null && root.right == null) return num;

    
        return traversal(root.left,num) + traversal(root.right,num);

    } 

    public int sumNumbers(TreeNode root) {
        
        return traversal(root,0);
        
    }
}