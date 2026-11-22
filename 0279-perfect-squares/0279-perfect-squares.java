class Solution {
    int func(int curr, int n, int[][] dp){
        if(n == 0) return 0;
        if(curr*curr > n) return Integer.MAX_VALUE;
        if(dp[curr][n] != -1) return dp[curr][n];
        int take = Integer.MAX_VALUE;
        if(curr*curr <= n){
            int step = func(curr, n-curr*curr,dp);
            if(step != Integer.MAX_VALUE){
                take = 1 + step;
            }
        }
        int skip = func(curr+1, n, dp);
        return dp[curr][n] = (int)Math.min(take, skip);
    }
    public int numSquares(int n) {
        int h = (int)Math.sqrt(n);
        int[][] dp = new int[h+1][n+1];
        for(int i = 0; i <= h; i++){
            Arrays.fill(dp[i], -1);
        }
        return func(1, n, dp);
    }
}