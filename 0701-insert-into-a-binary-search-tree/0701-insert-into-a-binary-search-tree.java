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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);

        TreeNode curr = root;

       while(curr.left != null || curr.right != null){
            if(curr.val < val){
                if(curr.right != null) curr = curr.right;
                else break;
            }
            else{
                if(curr.left != null) curr = curr.left;
                else break;
            }
       }
       if(curr.val < val) curr.right = new TreeNode(val);
       else curr.left = new TreeNode(val);

       return root; 
    }
}