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
    static void pre(TreeNode root, List<TreeNode> preorder){
        if(root == null) return;

        preorder.add(root);
        pre(root.left, preorder);
        pre(root.right, preorder);
    }
    public void flatten(TreeNode root) {
        
        List<TreeNode> preorder = new ArrayList<>();
        pre(root, preorder);

        for(int i = 0; i < preorder.size()-1;i++){
            preorder.get(i).right = preorder.get(i+1);
            preorder.get(i).left = null;
        }
        return;
    }
}