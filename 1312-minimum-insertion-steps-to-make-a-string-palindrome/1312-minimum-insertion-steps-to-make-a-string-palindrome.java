class Solution {
    int func(int i, int j, String s, int[][] dp){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)){
            dp[i][j] = func(i+1, j-1, s, dp);
        }else{
            dp[i][j] = 1 + (int)Math.min(func(i, j-1, s, dp), func(i+1, j, s, dp));
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