class Solution {
    int func(int i, int j, String s1, String s2, int[][] dp){
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j] = 1 + func(i-1, j-1, s1, s2, dp);
        }
        else{
            dp[i][j] = (int)Math.max(func(i, j-1, s1, s2, dp), func(i-1, j, s1, s2, dp));
        }
        return dp[i][j];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        int[][] dp = new int[l1][l2];
        
        for(int j = 0; j < l2; j++){
            if(text2.charAt(j) == text1.charAt(0)) dp[0][j] = 1;
            else if(j > 0) dp[0][j] = dp[0][j-1];
        }
        for(int i = 0; i < l1; i++){
            if(text1.charAt(i) == text2.charAt(0)) dp[i][0] = 1;
            else if(i > 0) dp[i][0] = dp[i-1][0];
        }
        for(int i = 1; i < l1; i++){
            for(int j = 1; j < l2; j++){
                if(text1.charAt(i) == text2.charAt(j)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = (int)Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[l1-1][l2-1];
    }
}