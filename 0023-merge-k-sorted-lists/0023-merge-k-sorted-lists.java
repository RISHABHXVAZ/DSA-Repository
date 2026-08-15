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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        for(int i = 0; i < n; i++){
            if(lists[i] == null) continue;
            pq.add(lists[i]);
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(!pq.isEmpty()){
            ListNode smallest = pq.poll();
            curr.next = smallest;
            curr = curr.next;

            if(smallest.next != null) pq.add(smallest.next);
        }

        return dummy.next;
    }
}