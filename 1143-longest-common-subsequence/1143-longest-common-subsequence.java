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
        for(int i = 0; i < l1; i++) Arrays.fill(dp[i], -1);
        return func(l1-1, l2-1, text1, text2, dp);
    }
}