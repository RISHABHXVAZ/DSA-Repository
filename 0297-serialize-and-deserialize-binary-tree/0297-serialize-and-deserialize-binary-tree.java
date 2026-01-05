/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null) return "[]";

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();

                if(node == null) sb.append("null,");
                else{
                    sb.append(node.val).append(",");
                    q.add(node.left);
                    q.add(node.right);
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "[]") return null;
        String[] s = data.split(",");
        if(s.length == 0) return null;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(new TreeNode(Integer.parseInt(s[0])));
        TreeNode root = q.peek();
        int k = 0;
        while(!q.isEmpty() && k < s.length){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                k++;
                node.left = (s[k].equals("null")) ? null : new TreeNode(Integer.parseInt(s[k]));
                k++;
                node.right = (s[k].equals("null")) ? null : new TreeNode(Integer.parseInt(s[k]));

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));