/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    boolean search(TreeNode root, TreeNode p){
        if(root == null) return false;
        if(root.val == p.val) return true;
        
        if(root.val > p.val) return search(root.left, p);
        else return search(root.right, p);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        if(root.val == p.val || root.val == q.val) return root;
        boolean pleft = search(root.left, p);
        boolean pright = search(root.right, p);
        boolean qleft = search(root.left, q);
        boolean qright = search(root.right, q);

        if(pleft && qright || pright && qleft) return root;
        
        if(pleft && qleft) return lowestCommonAncestor(root.left, p, q);
        else return lowestCommonAncestor(root.right, p, q);
    }
}