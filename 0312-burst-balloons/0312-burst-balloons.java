class Solution {
    int func(int i, int j, int[] nums, int[][] dp){
        if(i > j) return 0;
        if(dp[i][j] != Integer.MIN_VALUE) return dp[i][j];
        int steps = 0;
        for(int k = i; k <= j; k++){

            steps = nums[i-1]*nums[k]*nums[j+1] + func(i, k-1, nums,dp) + func(k+1, j, nums,dp);
            dp[i][j] = Math.max(dp[i][j], steps);
        }
        return dp[i][j];
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newarr = new int[n+2];
        newarr[0] = 1;
        newarr[n+1] = 1;
        for(int i = 1; i <= n; i++){
            newarr[i] = nums[i-1];
        }

        int[][] dp = new int[n+2][n+2];
      
        for(int i = n; i >= 1; i--){
            for(int j = 1; j <= n; j++){
                if(i > j) dp[i][j] = 0;
                else{
                    int steps = 0;
                    dp[i][j] = Integer.MIN_VALUE;
                    for(int k = i; k <= j; k++){
                        steps = newarr[i-1]*newarr[k]*newarr[j+1] + dp[i][k-1] + dp[k+1][j];
                        dp[i][j] = Math.max(dp[i][j], steps);
                    }
                }
            }
        }
        return dp[1][n];
    }
}