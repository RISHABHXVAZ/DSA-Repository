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
    void inorder(TreeNode root, ArrayList<Integer> lst){
        if(root == null) return;
        inorder(root.left, lst);
        lst.add(root.val);
        inorder(root.right, lst);
    }

    boolean search(TreeNode root, int t, int except){
        TreeNode temp = root;
        
        while(temp != null){
            if(temp.val == t && temp.val != except) return true;
            else if(temp.val < t) temp = temp.right;
            else temp = temp.left;
        }

        return false;
    }
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> lst = new ArrayList<>();
        inorder(root, lst);

        for(int i = 0; i < lst.size(); i++){
            if(search(root, k-lst.get(i), lst.get(i))) return true;
        }

        return false;
    }
}