class Solution {
    int func(int i, int j, String s, String t, int[][] dp) {
        if(i < 0 && j < 0) return 0;
        if(i < 0) return j+1;
        if(j < 0) return i+1;

        if(dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) != t.charAt(j)) {
            int op1 = 1 + func(i - 1, j, s, t, dp);
            int op2 = 1 + func(i, j - 1, s, t, dp);
            int op3 = 1 + func(i - 1, j - 1, s, t, dp);

            dp[i][j] = (int) Math.min(op1, Math.min(op2, op3));
        }else{
            dp[i][j] = func(i-1,j-1,s,t,dp);
        }
        return dp[i][j];
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // int[][] dp = new int[n][m];
        // for(int i = 0; i < n; i++) Arrays.fill(dp[i],-1);

        // return func(n-1, m-1, word1, word2, dp);
        int[][] dp = new int[n+1][m+1];
        dp[0][0] = 0;
        for(int j = 1; j <= m; j++){
            dp[0][j] = j;
        }
        for(int i = 1; i <= n; i++){
            dp[i][0] = i;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(word1.charAt(i-1) != word2.charAt(j-1)){
                    int op1 = 1 + dp[i-1][j];
                    int op2 = 1 + dp[i][j-1];
                    int op3 = 1 + dp[i-1][j-1];
                    dp[i][j] = Math.min(op1, Math.min(op2, op3));
                }else{
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }

        return dp[n][m];
        
    }
}