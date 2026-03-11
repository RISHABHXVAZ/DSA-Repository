class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        if(n == 1) return nums[0];
        if(n == 2) return (int)Math.max(nums[0], nums[1]);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n-1; i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        int ans = dp[n-2];
        dp[1] = nums[1];
        dp[2] = Math.max(nums[1], nums[2]);
        for(int i = 3; i < n; i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        if(dp[n-1] > ans) ans = dp[n-1];
        return ans;
    }
}