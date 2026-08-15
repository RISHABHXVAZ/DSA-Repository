class Solution {
    int func(int i, int j, String word1, String word2, int[][] dp){
        if(j == word2.length()) return word1.length()-i;
        if(i == word1.length()) return word2.length()-j;
        if(dp[i][j] != -1) return dp[i][j];

        if(word1.charAt(i) == word2.charAt(j)){
            dp[i][j] = func(i+1, j+1, word1, word2, dp);
        }else{
            int op1 = 1 + func(i+1, j+1, word1, word2, dp);
            int op2 = 1 + func(i, j+1, word1, word2, dp);
            int op3 = 1 + func(i+1, j, word1, word2, dp);

            dp[i][j] = Math.min(op1, Math.min(op2, op3));
        }

        return dp[i][j];
    }
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        int[][] dp = new int[n1+1][n2+1];
       
       for(int i = 0; i < n1; i++){
        dp[i][n2] = word1.length()-i;
       }

       for(int i = 0; i < n2; i++){
        dp[n1][i] = word2.length()-i;
       }

       for(int i = n1-1; i >= 0; i--){
        for(int j = n2-1; j >= 0; j--){
            if(word1.charAt(i) == word2.charAt(j)){
                dp[i][j] = dp[i+1][j+1];
            }else{
                int op1 = 1 + dp[i][j+1];
                int op2 = 1 + dp[i+1][j];
                int op3 = 1 + dp[i+1][j+1];

                dp[i][j] = Math.min(op1, Math.min(op2, op3));
            }
        }
       }
     return dp[0][0];
    }
}