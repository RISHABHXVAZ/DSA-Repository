class Solution {
    boolean func(int i, int count, String s, Boolean[][] dp){
        if(count < 0) return false;
        if(i == s.length()){
            if(count == 0) return true;
            return false;
        }

        if(dp[i][count] != null) return dp[i][count];
        if(s.charAt(i) == '(') dp[i][count] = func(i+1, count+1, s, dp);
        else if(s.charAt(i) == ')') dp[i][count] = func(i+1, count-1, s, dp);
        else{
            boolean op1 = func(i+1, count+1, s, dp);
            boolean op2 = func(i+1, count-1, s, dp);
            boolean op3 = func(i+1, count, s, dp);

            dp[i][count] = op1 || op2 || op3;
        }

        return dp[i][count];
    }
    public boolean checkValidString(String s) {
        int n = s.length();
        Boolean[][] dp = new Boolean[n][n+5];
        return func(0,0,s,dp);
    }
}