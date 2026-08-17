class Solution {
    int func(int i, int[] coins, int amount, int[][] dp){
        if(amount == 0) return 0;
        if(i == coins.length) return (int)1e9;

        if(dp[i][amount] != -1) return dp[i][amount];

        int take = (int)1e9;
        if(amount-coins[i] >= 0){
        take = 1 + func(i, coins, amount-coins[i], dp);
        }
        int nottake = func(i+1, coins, amount, dp);

        return dp[i][amount] = (int)Math.min(take, nottake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        int ans = func(0, coins, amount, dp);
        return ans == 1e9 ? -1 : ans;
    }
}