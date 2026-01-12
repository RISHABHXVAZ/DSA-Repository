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
    static void traverse(TreeNode root, List<TreeNode> lst){
        if(root == null) return;
        traverse(root.left,lst);
        lst.add(root);
        traverse(root.right,lst);
        }
    public void recoverTree(TreeNode root) {
        List<TreeNode> lst = new ArrayList<>();
        traverse(root,lst);

        TreeNode firstNode = null;
        TreeNode secondNode = null;
        for(int i = 0; i < lst.size()-1; i++){
            if(lst.get(i).val > lst.get(i+1).val){
                if(firstNode == null){
                    firstNode = lst.get(i);
                    secondNode = lst.get(i+1);
                }
                else secondNode = lst.get(i+1);
            }
        }
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
        return;
    }
}