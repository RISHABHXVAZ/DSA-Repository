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
    boolean issame = true;
    void preorder(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return;
        }
        if((p == null && q != null) || (p != null && q == null)){
            issame = false;
            return;
        }

        if(p.val != q.val) issame = false;
        preorder(p.left, q.left);
        preorder(p.right, q.right);
        return;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        preorder(p,q);
        return issame;
    }
}