class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n < k) return new int[0];
        int ans[] = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int ri = 0;
        for(int i = 0; i < n; i++){
            if(!dq.isEmpty() && dq.peek() <= i-k){
                dq.poll();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }
            dq.offer(i);

            if(i >= k-1) ans[ri++] = nums[dq.peek()];
        }
        return ans;
    }
}