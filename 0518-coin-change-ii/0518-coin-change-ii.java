class Solution {
    int func(int i, int amt, int[] coins, int[][] dp){
        if(i == 0){
            if(amt == 0 && coins[i] == 0) return 2; 
            if(amt % coins[i] == 0) return 1;
            else return 0;
        }
        if(dp[i][amt] != -1)  return dp[i][amt];
        int nottake = func(i-1, amt, coins, dp);
        int take = 0;
        if(coins[i] <= amt) take = func(i, amt - coins[i], coins, dp);
        return dp[i][amt] = take + nottake;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        
        if(coins[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;

        for(int t = 1; t <= amount; t++){
            if(t % coins[0] == 0) dp[0][t] = 1;
        }
        
        for(int i = 1; i < n; i++){
            for(int t = 0; t <= amount; t++){
                int nottake = dp[i-1][t];
                int take = 0;
                if(coins[i] <= t) take = dp[i][t - coins[i]];
                dp[i][t] = take + nottake;
            }
        }
        return dp[n-1][amount];
    }
}