/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    void traverse(TreeNode node, Map<TreeNode, TreeNode> mpp){
        if(node == null) return;
        if(node.left != null) mpp.put(node.left, node);
        if(node.right != null) mpp.put(node.right, node);
        traverse(node.left, mpp);
        traverse(node.right, mpp);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> mpp = new HashMap<>();
        mpp.put(root,null);
        traverse(root, mpp);

        Map<TreeNode, Boolean> visited = new HashMap<>();

        for(TreeNode node: mpp.keySet()){
            visited.put(node, false);
        }
        List<Integer> lst = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        int level = -1;
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            if(level == k) break;
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                visited.put(node, true);
                if(node.left != null && !visited.get(node.left)) q.add(node.left);
                if(node.right != null && !visited.get(node.right)) q.add(node.right);
                if(mpp.containsKey(node) && mpp.get(node) != null && !visited.get(mpp.get(node))) q.add(mpp.get(node));
            }
        }
        while(!q.isEmpty()){
            lst.add(q.poll().val);
        }

        return lst;

    }
}