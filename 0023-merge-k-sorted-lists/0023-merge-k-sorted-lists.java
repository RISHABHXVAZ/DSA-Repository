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
    ListNode merge(ListNode h1, ListNode h2){
        ListNode t1 = h1, t2 = h2, t3 = new ListNode(-1);
        ListNode head = t3;
        while(t1 != null && t2 != null){
            if(t1.val < t2.val){
                t3.next = t1;
                t1 = t1.next;
            }else{
                t3.next = t2;
                t2 = t2.next;
            }
            t3 = t3.next;
        }

        while(t1 != null){
            t3.next = t1;
            t1 = t1.next;
            t3 = t3.next;
        }

        while(t2 != null){
            t3.next = t2;
            t2 = t2.next;
            t3 = t3.next;
        }

        return head.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;

        ListNode head = null;
        for(int i = 0; i < n; i++){
            ListNode head1 = lists[i];
            head = merge(head, head1);
        }

        return head;
    }
}