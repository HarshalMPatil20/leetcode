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
     public TreeNode Traverse (TreeNode root, int depth,int num){
        if(root==null) return root;
        if(depth==1){
            TreeNode newroot = new TreeNode(num);
            newroot.left = root;
            return newroot;
        }
        if(depth == 2){
            TreeNode leftnode = new TreeNode(num);
            TreeNode rightnode = new TreeNode(num);
            leftnode.left = root.left;
            rightnode.right = root.right;
            root.left = leftnode;
            root.right = rightnode;
            return root;
        }

        
        depth--;
        Traverse(root.left,depth,num);
        Traverse(root.right,depth,num);

        return root;
     } 
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        return Traverse(root,depth,val);
    }
}