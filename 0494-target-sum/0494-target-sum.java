class Solution {
    int func(int i, int target, int[] nums, int[][] dp){
        int n = nums.length;
        if(target < 0) return 0;
        if(i == n) return target == 0 ? 1 : 0;
        if(dp[i][target] != -1) return dp[i][target];
        int take = func(i+1, target-nums[i], nums, dp);
        int skip = func(i+1, target, nums, dp);
        return dp[i][target] = take + skip;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
        }
        if(target > sum || (sum-target) % 2 == 1) return 0;
        int[][] dp = new int[n][(sum-target)/2 + 1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return func(0, (sum-target)/2, nums, dp);
    }
}