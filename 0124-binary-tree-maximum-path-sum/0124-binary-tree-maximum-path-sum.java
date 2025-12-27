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
    int maxSum = Integer.MIN_VALUE;
    int longestSum(TreeNode node){
        if(node == null) return 0;

        int left = longestSum(node.left);
        if(left < 0) left = 0;
        int right = longestSum(node.right);
        if(right < 0) right = 0;
        if(left + right + node.val > maxSum){
            maxSum = left + right + node.val;
        }

        return node.val + Math.max(left, right);
    }
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        longestSum(root);
        return maxSum;
    }
}