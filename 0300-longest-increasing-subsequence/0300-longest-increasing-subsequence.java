class Solution {
    int func(int i, int prev, int[] nums, int[][] dp){
        if(i == nums.length) return 0;

        if(dp[i][prev+1] != -1) return dp[i][prev+1];
        int take = Integer.MIN_VALUE;
        if(prev == -1 || nums[i] > nums[prev]){
            take = 1 + func(i+1, i, nums, dp);
        }
        int nottake = func(i+1, prev, nums, dp);
        return dp[i][prev+1] = (int)Math.max(take, nottake);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) max = Math.max(max, nums[i]);

        int maxlen = 0;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        for(int i = 0; i < n; i++){ 
            int len = func(i, -1, nums, dp);
            maxlen = Math.max(maxlen, len);
        }

        return maxlen;
    }
}