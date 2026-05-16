class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for(int num: nums) sum += num;

        if((sum & 1) == 1) return false;

        boolean[] dp = new boolean[sum/2+1];
        dp[0] = true;
        if(nums[0] <= sum/2) dp[nums[0]] = true;

        for(int idx = 1; idx < n; idx++){
            dp[0] = true;
            for(int target = sum/2; target >= 0; target--){
                boolean nottake = dp[target];
                boolean taken = false;
                if(nums[idx] <= target) taken = dp[target-nums[idx]];

                dp[target] = taken||nottake;
            }
        }
        return dp[sum/2];
    }
}