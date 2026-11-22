class Solution {
    int func(int i, int amount, int[] coins, int[][] dp){
        int n = coins.length;
        if(amount == 0) return 0;
        if(i == n) return Integer.MAX_VALUE;
        if(dp[i][amount] != -1) return dp[i][amount];
        int take = Integer.MAX_VALUE;
        if(coins[i] <= amount){ 
            int step = func(i, amount-coins[i], coins, dp);
            if(step != Integer.MAX_VALUE) take = 1 + step;
        }
        int skip = func(i+1, amount, coins, dp);
        return dp[i][amount] = (int)Math.min(take, skip);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        int ans = func(0, amount, coins, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}