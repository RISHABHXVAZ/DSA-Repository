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
    static List<TreeNode> preorder(TreeNode node, List<TreeNode> nodes){
        if(node == null) return nodes;
        nodes.add(node);
        preorder(node.left, nodes);
        preorder(node.right, nodes);
        return nodes;
    }
    static int height(TreeNode node){
        if(node == null) return 0;
        int left = height(node.left);
        int right = height(node.right);

        if(Math.abs(right - left) <= 1) return 1 + Math.max(right,left);
        else return -1;
    }
    public boolean isBalanced(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        nodes = preorder(root, nodes);
        
        for(TreeNode node: nodes){
            if(height(node) == -1) return false; 
        }
        return true;
    }
}