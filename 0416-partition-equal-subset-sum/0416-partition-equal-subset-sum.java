class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        
        int sum = 0;
        for(int num: nums) sum += num;
        if((sum & 1) == 1) return false;
        boolean[][] dp = new boolean[n][sum/2 + 1];

        for(int i = 0; i < n; i++) Arrays.fill(dp[i], false);

        if(nums[0] <= sum/2) dp[0][nums[0]] = true;

        for(int i = 0; i < n; i++) dp[i][0] = true;

        for(int idx = 1; idx < n; idx++){
            for(int target = 0; target <= sum/2; target++){
                boolean nottaken = dp[idx-1][target];
                boolean taken = false;
                if(nums[idx] <= target) taken = dp[idx-1][target-nums[idx]];
                dp[idx][target] = taken||nottaken;
            }
        }

        return dp[n-1][sum/2];
    }
}