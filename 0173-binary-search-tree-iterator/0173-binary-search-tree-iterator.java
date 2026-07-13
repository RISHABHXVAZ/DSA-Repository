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
    PriorityQueue<TreeNode> pq; 
    void traverse(TreeNode root, PriorityQueue<TreeNode> pq){
        if(root == null) return;
        pq.add(root);
        traverse(root.left, pq);
        traverse(root.right, pq);
    }
    public BSTIterator(TreeNode root) {
        pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        traverse(root, pq);
    }
    
    public int next() {
        return pq.poll().val;
    }
    
    public boolean hasNext() {
        if(!pq.isEmpty()) return true;
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */