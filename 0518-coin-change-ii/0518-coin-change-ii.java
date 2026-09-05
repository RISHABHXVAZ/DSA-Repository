class Solution {
    int func(int i, int amt, int[] coins, int[][] dp){
        if(amt == 0) return 1;
        if(i == coins.length) return 0;
        if(dp[i][amt] != -1) return dp[i][amt];
        int take = 0;
        if(coins[i] <= amt) take = func(i, amt-coins[i], coins, dp);
        int skip = func(i+1, amt, coins, dp);
        
        return dp[i][amt] = take + skip;
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