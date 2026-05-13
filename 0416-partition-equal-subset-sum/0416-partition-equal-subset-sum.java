class Solution {
    static boolean func(int idx, int[] nums, int[][] dp, int sum, int target){
        if(sum == target) return true;
        if(idx == 0) return false;
        if(dp[idx][sum] != -1) return dp[idx][sum] == 1;
        boolean nottake = func(idx-1, nums, dp,sum, target);
        boolean take = false;
        if(sum >= nums[idx]) take = func(idx-1, nums, dp,sum-nums[idx], target);

        dp[idx][sum] = take||nottake ? 1: 0;

        return take || nottake;
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % 2 != 0) return false;

        int[][] dp = new int[n][sum+1];

        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        return func(n-1, nums, dp, sum, sum/2);
    }
}