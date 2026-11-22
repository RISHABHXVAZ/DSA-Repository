class Solution {
    int func(int i, int target, int[] nums, int[][] dp){
        if(target == 0) return 1;
        if(i == nums.length) return 0;
        if(dp[i][target] != -1) return dp[i][target];
        int take = 0;
        if(nums[i] <= target){
           take = func(0, target-nums[i], nums, dp);
        }
        int skip = func(i+1, target, nums, dp);
        return dp[i][target] = take + skip;
    }
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target+1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return func(0, target, nums, dp);
    }
}