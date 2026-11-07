class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int maxsum = Integer.MIN_VALUE;
        int minsum = Integer.MAX_VALUE;
        int total = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            total += nums[i];
            sum += nums[i];
            maxsum = Math.max(maxsum, sum);
            if(sum < 0) sum = 0;
        }

        sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            minsum = Math.min(minsum, sum);
            if(sum > 0) sum = 0;
        }

        if(maxsum < 0) return maxsum;
        return (int)Math.max(maxsum, total-minsum);
    }
}