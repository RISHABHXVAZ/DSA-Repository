class Solution {
    int func(int b, int i, int[] prices, int fees,int[][] dp){
        if(i == prices.length) return 0;
        if(dp[b][i] != -1) return dp[b][i];
        int profit = 0;
        if(b == 0){
            int op1 = -prices[i] - fees + func(1,i+1,prices,fees,dp); //buy on present day
            int op2 = func(b, i+1, prices,fees,dp); //skip current day
            dp[b][i] = Math.max(op1, op2);
        }else{
            int op1 = func(b, i+1, prices,fees,dp); //skip present day
            int op2 = prices[i] + func(0, i+1, prices,fees,dp); //sell on present day

           dp[b][i] = Math.max(op1, op2);
        }

        return dp[b][i];
    }
    public int maxProfit(int[] prices, int fees) {
        int n = prices.length;
        int[][] dp = new int[2][n];
        for(int i = 0; i < 2; i++) Arrays.fill(dp[i], -1);
        return func(0,0,prices,fees,dp);
    }
}