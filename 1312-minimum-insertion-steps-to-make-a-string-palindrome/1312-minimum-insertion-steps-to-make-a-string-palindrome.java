class Solution {
    int func(int i, int j, String s, int[][] dp){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)) dp[i][j] = func(i+1, j-1, s, dp);
        else{
            int op1 = 1 + func(i+1, j, s, dp);
            int op2 = 1 + func(i, j-1, s, dp);

            dp[i][j] = Math.min(op1, op2);
        }
        return dp[i][j];
    }
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        return func(0, n-1, s, dp);
    }
}