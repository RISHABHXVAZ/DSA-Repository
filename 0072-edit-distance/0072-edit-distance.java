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
        int[][] dp = new int[word1.length()][word2.length()];
        for(int i = 0; i < word1.length(); i++){
            Arrays.fill(dp[i], -1);
        }
        return func(0, 0, word1, word2, dp);
    }
}