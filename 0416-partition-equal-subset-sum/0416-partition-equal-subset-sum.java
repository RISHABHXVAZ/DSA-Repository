class Solution {
    boolean func(int i, int target, int[] nums, Boolean[][] dp){
        if(target < 0) return false;
        if(target == 0) return true;
        if(i == nums.length) return false;
        if(dp[i][target] != null) return dp[i][target];
        boolean take = func(i+1, target-nums[i], nums, dp);
        boolean skip = func(i+1, target, nums, dp);
        return dp[i][target] = take||skip;
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
        }
        if(sum % 2 == 1) return false; //if sum is odd -> not possible to divide
        Boolean[][] dp = new Boolean[n][sum/2+1];
       
        return func(0,sum/2, nums, dp);
    }
}