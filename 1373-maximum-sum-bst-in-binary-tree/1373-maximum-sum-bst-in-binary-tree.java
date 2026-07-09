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
    int maxsum = 0;
    class info{
        boolean isbst;
        int min;
        int max;
        int sum;

        info(boolean isbst, int min, int max, int sum){
            this.isbst = isbst;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }
    
    info traverse(TreeNode root){
        if(root == null) return new info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        info left = traverse(root.left);
        info right = traverse(root.right);

        if(left.isbst && right.isbst && root.val > left.max && root.val < right.min){
            int sum = root.val + left.sum + right.sum;
            maxsum = Math.max(maxsum, sum);

            int currmin = Math.min(root.val, left.min);
            int currmax = Math.max(root.val, right.max);

            return new info(true, currmin, currmax, sum);
        }
        return new info(false, 0, 0, 0);
    }
    public int maxSumBST(TreeNode root) {
        traverse(root);
        return maxsum;
    }
}