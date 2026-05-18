class Solution {
    int func(int idx, int[] coins, int amount, int[][] dp){
        if(amount == 0) return 0;
        if(idx == 0){
            if(amount % coins[0] == 0) return amount/coins[0];
            else return (int)1e9; 
        }
        if(dp[idx][amount] != -1) return dp[idx][amount];
        int nottake = 0 + func(idx-1, coins, amount, dp);
        int take = Integer.MAX_VALUE;
        if(coins[idx] <= amount) take = 1 + func(idx, coins, amount - coins[idx], dp);
        dp[idx][amount] = (int)Math.min(take, nottake);
        return dp[idx][amount];
    }
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int n = coins.length;
        Arrays.sort(coins);
        int[][] dp = new int[n][amount+1];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        int ans = func(n-1 ,coins, amount, dp);
        return ans == 1e9 ? -1: ans;
    }
}