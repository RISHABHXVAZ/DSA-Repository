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
class BSTIterator {
    int ptr;
    List<TreeNode> inorder = new ArrayList<>();
     void in(TreeNode root){
        if(root == null) return;
        in(root.left);
        inorder.add(root);
        in(root.right);
    }
    public BSTIterator(TreeNode root) {
         ptr = -1;
        in(root);
    }
    
    public int next() {
        ptr++;
        return inorder.get(ptr).val;

    }
    
    public boolean hasNext() {
        if(ptr == inorder.size() - 1) return false;
        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */