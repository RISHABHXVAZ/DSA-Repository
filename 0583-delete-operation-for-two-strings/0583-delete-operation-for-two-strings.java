class Solution {
    int func(int i, int j, String word1, String word2, int[][] dp){
        if(i == word1.length() && j == word2.length()) return 0;

        if(i == word1.length()) return word2.length() - j;
        if(j == word2.length()) return word1.length() - i;

        if(dp[i][j] != -1) return dp[i][j];

        if(word1.charAt(i) == word2.charAt(j)) dp[i][j] = func(i+1,j+1,word1,word2,dp);
        else dp[i][j] = 1 + Math.min(func(i,j+1,word1,word2,dp), func(i+1,j,word1,word2,dp));

        return dp[i][j];
    }
    public int minDistance(String word1, String word2){
        int l1 = word1.length();
        int l2 = word2.length();

        int[][] dp = new int[l1+1][l2+1];

        for(int j = 0; j <= l2; j++) dp[l1][j] = l2 - j;
        for(int i = 0; i <= l1; i++) dp[i][l2] = l1 - i;

        for(int i = l1-1; i >= 0; i--){
            for(int j = l2-1; j >= 0; j--){
                if(word1.charAt(i) == word2.charAt(j)) dp[i][j] = dp[i+1][j+1];
                else dp[i][j] = 1 + Math.min(dp[i][j+1], dp[i+1][j]);
            }
        }
        
        return dp[0][0];
    }
}