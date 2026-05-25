class Solution {
    int func(int i, int j, String s, String p, int[][] dp){
        if(i < 0 && j < 0) return 1;
        if(i < 0){
            while(j >= 0){
                if(p.charAt(j) != '*') return 0;
                j--;
            }
            return 1;
        }
        if(j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            dp[i][j] = func(i-1,j-1,s,p,dp);
        }else if(p.charAt(j) == '*'){
            dp[i][j] = func(i,j-1,s,p,dp) | func(i-1,j,s,p,dp);
        }else dp[i][j] = 0;

        return dp[i][j];
    }
    public boolean isMatch(String s, String p) {
       int n = s.length();
       int m = p.length();
    
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return func(n-1,m-1,s,p,dp) == 1 ? true: false;
    }
}