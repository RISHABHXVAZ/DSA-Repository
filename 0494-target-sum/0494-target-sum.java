class Solution {
    //memorisation method
    int func(int idx, int[] nums, int tgt, int[][] dp){
        if(idx == 0){
            if(tgt == 0 && nums[0] == 0) return 2;
            if(tgt == 0 || nums[idx] == tgt) return 1;
            else return 0;
        }
        if(dp[idx][tgt] != -1) return dp[idx][tgt];
        int nottake = func(idx-1, nums, tgt, dp);
        int take = 0;
        if(nums[idx] <= tgt) take = func(idx-1, nums, tgt - nums[idx], dp);
        dp[idx][tgt] = nottake + take;
        return dp[idx][tgt];
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int tsum = 0;
        for(int num: nums) tsum += num;
        if(target > tsum || (tsum-target) % 2 != 0) return 0;
        int tgt = (tsum - target)/2;
        int[][] dp = new int[n][tgt+1];

        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        return func(n-1, nums, tgt, dp);
    }
}