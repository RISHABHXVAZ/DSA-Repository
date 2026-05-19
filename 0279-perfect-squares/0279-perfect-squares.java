class Solution {
    
    public int numSquares(int n) {
      int h = (int)Math.floor(Math.sqrt(n));  
      int[] nums = new int[h];
      for(int i = 0; i < h; i++) nums[i] = i+1;
    
      int[][] dp = new int[h][n+1];
      int val = (int)Math.pow(nums[0], 2);
      for(int t = 0; t <= n; t++){
        if(t % val == 0) dp[0][t] = t/val;
      }

      for(int i = 1; i < h; i++){
        for(int t = 0; t <= n; t++){
            int nottake = dp[i-1][t];
            int take = (int)1e9;
            if((int)Math.pow(nums[i], 2) <= t) take = 1 + dp[i][t-(int)Math.pow(nums[i], 2)];
            dp[i][t] = Math.min(nottake, take);
        }
      }
      return dp[h-1][n];
    }
}