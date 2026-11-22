class Solution {
    int mod = 1000000007;
    int func(int i, int k, int[] nums, int[][] dp){
        if(i == nums.length) return  k > 0 ? 1 : 0;
        if(dp[i][k] != -1) return dp[i][k];
        int take = 0;
        if(nums[i] <= k) take = func(i+1, k-nums[i], nums, dp);
        int skip = func(i+1, k, nums, dp);
        return dp[i][k] = (take + skip) % mod;
    }
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long total = 0;
        for(int i = 0; i < n; i++){
            total += (long)nums[i];
        }
        if(total < 2L*k) return 0;
        int[][] dp = new int[n][k+1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        long s = func(0, k, nums, dp);
        long total_states = 1;
        for(int i = 0; i < n; i++){
            total_states = (total_states*2) % mod;
        }
        return (int)(((total_states - 2L*s) % mod + mod) % mod);
    }
}