class Solution {
    int func(int i , int[] nums, int target, int[][] dp){
        if(i == 0){
            if(target % (int)Math.pow(nums[0], 2) == 0) return (int)(target/Math.pow(nums[0], 2));
            else return 0;
        }
        if(dp[i][target] != -1) return dp[i][target];

        int nottake = func(i-1, nums, target, dp);
        int take = (int)1e9;
        if((int)Math.pow(nums[i], 2) <= target) take = 1 + func(i, nums, target - (int)Math.pow(nums[i],2), dp);
        
        dp[i][target] = (int)Math.min(nottake, take);
        return dp[i][target];
    }
    public int numSquares(int n) {
      int h = (int)Math.floor(Math.sqrt(n));  
      int[] nums = new int[h];
      for(int i = 0; i < h; i++) nums[i] = i+1;
    
      int[][] dp = new int[h][n+1];
      for(int i = 0; i < h; i++) Arrays.fill(dp[i], -1);
      return func(h-1, nums, n, dp);
    }
}