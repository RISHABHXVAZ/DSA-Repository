class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        int el = 0, cnt = 0;
        for(int i = 0; i < n; i++){
            if(i == 0){
                el = nums[i];
                cnt = 1;
                continue;
            }

            if(nums[i] == nums[i-1]) cnt++;
            else{
                pq.add(new int[]{cnt, el});
                el = nums[i];
                cnt = 1;
            }
        }
        pq.add(new int[]{cnt, el});

        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            int[] p = pq.poll();
            ans[i] = p[1];
        }

        return ans;
    }
}