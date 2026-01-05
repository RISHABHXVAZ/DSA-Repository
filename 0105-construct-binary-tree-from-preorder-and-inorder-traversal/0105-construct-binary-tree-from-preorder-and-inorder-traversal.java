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
    static TreeNode build(int[] preorder, int startpre, int endpre, int[] inorder, int startin, int endin, Map<Integer, Integer> mpp){
        if(startpre > endpre || startin > endin) return null;
        
        TreeNode root = new TreeNode(preorder[startpre]);
        
        int inroot = mpp.get(root.val);
        int numsLeft = inroot - startin;

        root.left = build(preorder, startpre+1, startpre + numsLeft, inorder, startin, inroot-1, mpp);
        root.right = build(preorder, startpre + numsLeft + 1, endpre, inorder, inroot + 1, endin, mpp);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if(n == 0) return null;
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int i = 0; i < n; i++){
            mpp.put(inorder[i], i);
        }
        TreeNode root = null;
        return build(preorder , 0, n-1, inorder, 0, n-1, mpp);
    }
}