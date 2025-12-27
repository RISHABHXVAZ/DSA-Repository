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
    int diameter = Integer.MIN_VALUE;

     int longestSubtree(TreeNode node){
        if(node == null) return 0;

        int left = longestSubtree(node.left);
        int right = longestSubtree(node.right);

        if(left + right  > diameter){
            diameter = left + right ;
        }
        return 1 + Math.max(left, right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        longestSubtree(root);
        return diameter;
    }
}