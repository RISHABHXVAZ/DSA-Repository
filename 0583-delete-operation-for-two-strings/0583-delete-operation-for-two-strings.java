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

       int[] curr = new int[l2+1];
        int[] next = new int[l2+1];

        for(int j = 0; j <= l2; j++) next[j] = l2 - j;
        
        for(int i = l1-1; i >= 0; i--){
            curr[l2] = l1 - i;
            for(int j = l2-1; j >= 0; j--){
                if(word1.charAt(i) == word2.charAt(j)) curr[j] = next[j+1];
                else curr[j] = 1 + Math.min(curr[j+1], next[j]);
            }
            next = curr;
            curr = new int[l2+1];
        }

        return next[0];
    }
}