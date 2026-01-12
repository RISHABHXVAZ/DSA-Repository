/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    static TreeNode buildTree(ListNode startNode, ListNode endNode){
        if(startNode == endNode) return null;
        ListNode fast = startNode, slow = startNode;
        while(fast != endNode && fast.next != endNode){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = buildTree(startNode, slow);
        root.right = buildTree(slow.next, endNode);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return buildTree(head, null);
    }
}