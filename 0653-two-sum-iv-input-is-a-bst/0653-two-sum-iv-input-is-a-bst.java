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
    static void inorder(TreeNode root, List<Integer> lst){
        if(root == null) return;
        inorder(root.left,lst);
        lst.add(root.val);
        inorder(root.right, lst);
    }
    static boolean bs(List<Integer> lst, int start, int end, int key){
        int low = start;
        int high = end;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(lst.get(mid) == key) return true;
            else if(lst.get(mid) > key) high = mid-1;
            else low = mid+1;
        }
        return false;
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> lst = new ArrayList<>();
        inorder(root, lst);

        for(int i = 0; i < lst.size()-1; i++){
            int more = k - lst.get(i);
            if(bs(lst, i+1, lst.size()-1, more)) return true;
        }
        return false;
    }
}