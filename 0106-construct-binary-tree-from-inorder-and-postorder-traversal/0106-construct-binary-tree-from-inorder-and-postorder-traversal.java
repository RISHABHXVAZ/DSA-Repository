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
    static TreeNode buildTree(int[] inorder, int startin, int endin, int[] postorder, int startpost, int endpost, Map<Integer, Integer> mpp){
        if(startin > endin || startpost > endpost) return null;

        TreeNode root = new TreeNode(postorder[endpost]);
        int inroot = mpp.get(root.val);
        int numsLeft = inroot - startin;

        root.left = buildTree(inorder, startin, inroot-1, postorder, startpost, startpost + numsLeft - 1, mpp);
        root.right = buildTree(inorder, inroot+1, endin, postorder, startpost + numsLeft, endpost-1, mpp);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        if(n == 0) return null;
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int i = 0; i < n; i++){
            mpp.put(inorder[i], i);
        }

        return buildTree(inorder, 0, n-1, postorder, 0, n-1, mpp);
    }
}