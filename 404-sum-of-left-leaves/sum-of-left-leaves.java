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

      int ans = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        traverse(root);
        return ans;
    }


    public void traverse(TreeNode root){
        if(root==null) return;

        if(isleafnode(root.left)) {ans+= root.left.val;}

        traverse(root.left);
        traverse(root.right);
    }

    public boolean isleafnode(TreeNode root){

        if(root==null) return false; 

        if(root.left==null && root.right == null){
            return true;
        }
        
        return false;
    }
}