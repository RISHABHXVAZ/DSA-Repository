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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }

        ListNode[] nums = new ListNode[count];
        int k = 0;
        temp = head;
        while(temp != null){
            nums[k++] = temp;
            temp = temp.next;
        }

        int points = 0;
        List<Integer> lst = new ArrayList<>();
    
        for(int i = 1; i < count-1; i++){
            if(nums[i].val > nums[i-1].val && nums[i].val > nums[i+1].val){
                lst.add(i);
                points++;
            }else if(nums[i].val < nums[i-1].val && nums[i].val < nums[i+1].val){
                lst.add(i);
                points++;
            }
        }
        if(points < 2) return new int[]{-1, -1};

        int maxdist = Integer.MIN_VALUE;
        int mindist = Integer.MAX_VALUE;

        maxdist = lst.get(lst.size()-1) - lst.get(0);
        
        for(int i = 1; i < lst.size(); i++){
            mindist = Math.min(mindist, lst.get(i) - lst.get(i-1));
        }

        return new int[]{mindist, maxdist};
        
    }
}