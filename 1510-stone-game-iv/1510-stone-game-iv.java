class Solution {
    boolean func(int n, Boolean[] dp){
        if(n == 0) return false;
        if(dp[n] != null) return dp[n];
        for(int i = 1; i*i <= n; i++){
            boolean opp = func(n-i*i, dp);
            if(!opp) return dp[n] = true;
        }

        return dp[n] = false;
    }

    public boolean winnerSquareGame(int n) {
        long root = (long) Math.sqrt(n);
        if (root * root == n)
            return true;

        Boolean[] dp = new Boolean[n+1];
        return func(n, dp);
    }
}