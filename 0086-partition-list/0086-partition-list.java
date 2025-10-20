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
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        ListNode temp = head;
        ListNode temp2 = dummy;
        ListNode smaller = dummy;
        while(temp != null){
            if(temp.val < x){
                ListNode node = temp;
                temp = temp.next;
                node.next = smaller.next;
                smaller.next = node;
                smaller = node;
                if(smaller.next == null) temp2 = temp2.next;
            }
            else{
                temp2.next = temp;
                temp = temp.next;
                temp2 = temp2.next;
            }
        }
        temp2.next = null;
        return dummy.next;
    }
}