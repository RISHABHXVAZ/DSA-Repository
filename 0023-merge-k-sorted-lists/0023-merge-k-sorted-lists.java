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
class pair{
    ListNode node;
    int idx;

    pair(ListNode node, int i){
        this.node = node;
        this.idx = i;
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        ListNode[] help = new ListNode[n];

        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> {
            if(a.node.val != b.node.val) return Integer.compare(a.node.val, b.node.val);
            else return Integer.compare(a.idx, b.idx);
        });

        for(int i = 0; i < n; i++){
            ListNode node = lists[i];
            if(node != null){
                pq.add(new pair(node, i));
            help[i] = node.next;
            }
        }

        ListNode head = null;
        ListNode temp = head;
        while(!pq.isEmpty()){
            pair p = pq.poll();

            if(head == null){ 
                head = p.node;
                temp = p.node;

                if(help[p.idx] != null) pq.add(new pair(help[p.idx], p.idx));
                if(help[p.idx] != null) help[p.idx] = help[p.idx].next;
                continue;
            }

            temp.next = p.node;
            temp = temp.next;
            if(help[p.idx] != null) pq.add(new pair(help[p.idx], p.idx));
            if(help[p.idx] != null) help[p.idx] = help[p.idx].next;
        } 


        return head; 
    }
}