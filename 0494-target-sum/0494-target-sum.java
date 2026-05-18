class Solution {
   
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int tsum = 0;
        for(int num: nums) tsum += num;
        if(target > tsum || (tsum-target) % 2 != 0) return 0;
        int tgt = (tsum - target)/2;
        int[][] dp = new int[n][tgt+1];

        if(nums[0] == 0) dp[0][0] = 2;
        if(nums[0] != 0) {
            dp[0][0] = 1;
            if(nums[0] <= tgt) dp[0][nums[0]] = 1;
        }

        for(int i = 1; i < n; i++){
            for(int t = 0; t <= tgt; t++){
                int nottake = dp[i-1][t];
                int take = 0;
                if(nums[i] <= t) take = dp[i-1][t-nums[i]];
                dp[i][t] = take + nottake;
            }
        }
        return dp[n-1][tgt];
    }
}