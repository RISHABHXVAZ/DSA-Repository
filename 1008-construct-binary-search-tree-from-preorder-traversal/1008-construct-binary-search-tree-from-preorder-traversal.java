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
    TreeNode func(int[] preorder, int start, int end){
        if(start > end) return null;
        TreeNode root = new TreeNode(preorder[start]);
        int j = start+1;
        while(j <= end && preorder[j] < preorder[start]) j++;
        root.left = func(preorder, start+1, j-1);
        root.right = func(preorder, j, end);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        return func(preorder,0,n-1);
    }
}