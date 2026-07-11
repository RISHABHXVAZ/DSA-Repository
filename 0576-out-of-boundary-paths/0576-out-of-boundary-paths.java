class Solution {
     int MOD = (int)1e9 + 7;
    int func(int i, int j, int move, int m, int n, int[][][] dp){
        if(!(i >= 0 && i < m && j >= 0 && j < n)) return 1;
        if(move == 0) return 0;

        if(dp[i][j][move] != -1) return dp[i][j][move];
        long ans = 0;
        ans = (ans + func(i-1, j, move-1, m, n, dp)) % MOD;
        ans = (ans + func(i+1, j, move-1, m, n, dp))% MOD;
        ans = (ans + func(i, j+1, move-1, m, n, dp))% MOD;
        ans = (ans + func(i, j-1, move-1, m, n, dp))% MOD;

        return dp[i][j][move] = (int)ans;
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
       
        int[][][] dp = new int[m][n][maxMove+1];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) Arrays.fill(dp[i][j], -1);
        }
        return func(startRow, startColumn, maxMove, m, n, dp);
    }
}