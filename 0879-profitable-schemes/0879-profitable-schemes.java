class Solution {
    int mod = 1000000007;
    int func(int i, int n, int minp, int[] group, int[] profit, int[][][] dp){
        if(i == group.length){
            return minp <= 0 ? 1 : 0;
        }
        if(dp[i][n][minp] != -1) return dp[i][n][minp];
        int take = 0;
        if(group[i] <= n) take = func(i+1, n-group[i], Math.max(0, minp-profit[i]), group, profit, dp);
        int skip = func(i+1, n, minp, group, profit, dp);

        return dp[i][n][minp] = (take + skip) % mod;
    }
    public int profitableSchemes(int N, int minProfit, int[] group, int[] profit) {
        int[][][] dp = new int[group.length+1][N+1][minProfit+1];
        // for(int i = 0; i < group.length; i++){
        //     for(int j = 0; j <= n; j++){
        //         Arrays.fill(dp[i][j], -1);
        //     }
        // }
        // return func(0, n, minProfit, group, profit, dp) % mod;

        for(int n = 0; n <= N; n++){
         dp[group.length][n][0] = 1;   
        }
        for(int i = group.length-1; i >= 0; i--){
            for(int n = 0; n <= N; n++){
                for(int minp = 0; minp <= minProfit; minp++){
                    int take = 0;
                    if(group[i] <= n) take = dp[i+1][n-group[i]][Math.max(0, minp-profit[i])];
                    int skip = dp[i+1][n][minp];
                    dp[i][n][minp] = (take+skip)%mod;
                }
            }
        }
        return dp[0][N][minProfit] % mod;
    }
}