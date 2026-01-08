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
    static TreeNode buildBST(int[] preorder, int startpre, int endpre){
        if(startpre > endpre) return null;
        TreeNode root = new TreeNode(preorder[startpre]);
        int j = startpre+1;
        while(j <= endpre && preorder[j] < root.val) j++;
        root.left = buildBST(preorder, startpre+1, j-1);
        root.right = buildBST(preorder, j, endpre);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        if(n == 0) return null;

        return buildBST(preorder, 0, n-1);
    }
}