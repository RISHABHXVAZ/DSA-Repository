class Solution {
    int func(int i, int amount, int[] coins, int[][] dp){
        if(amount == 0) return 1;
        if(i == coins.length) return 0;
        if(dp[i][amount] != -1) return dp[i][amount];
        int take = 0;
        if(coins[i] <= amount) take = func(i, amount-coins[i], coins, dp);
        int skip = func(i+1, amount, coins, dp);
        return dp[i][amount] = take + skip;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return func(0, amount, coins, dp);
    }
}