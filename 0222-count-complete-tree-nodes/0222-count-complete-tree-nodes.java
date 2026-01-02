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
    static int traverse(TreeNode node){
        if(node == null) return 0;
        int left = getLeftHeight(node);
        int right = getRightHeight(node);
        if(left == right) return (1<<left) - 1;
        else return 1 + traverse(node.left) + traverse(node.right);
    }
    static int getLeftHeight(TreeNode node){
        if(node == null) return 0;
        return 1 + getLeftHeight(node.left);
    }
    static int getRightHeight(TreeNode node){
        if(node == null) return 0;
        return 1 + getRightHeight(node.right);
    }
    public int countNodes(TreeNode root) {
        return traverse(root);
    }
}