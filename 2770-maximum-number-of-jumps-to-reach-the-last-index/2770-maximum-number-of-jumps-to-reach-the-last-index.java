class Solution {
    int func(int i, int[] nums, int target, int[] dp){
        if(i == nums.length-1) return 0;
        if(dp[i] != -1) return dp[i];

        int ans = Integer.MIN_VALUE;
        for(int j = i+1; j < nums.length; j++){
            if(Math.abs(nums[j]-nums[i]) <= target){
                int step = func(j, nums, target, dp);
                if(step != Integer.MIN_VALUE) ans = Math.max(ans, 1 + step);
            }
        }

        return dp[i] = ans;
    }
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int ans = func(0, nums, target, dp);
        return ans != Integer.MIN_VALUE? ans : -1;
    }
}