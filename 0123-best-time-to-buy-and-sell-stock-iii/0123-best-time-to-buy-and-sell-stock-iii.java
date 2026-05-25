class Solution {
    int func(int holding, int i, int txn, int[] prices, int[][][] dp){
        if(i == prices.length || txn == 0) return 0;
        if(dp[holding][i][txn] != -1) return dp[holding][i][txn];
        int profit = 0;
        if(holding == 0){
            int op1 = func(holding, i+1, txn, prices, dp); // skip present day
            int op2 = -prices[i] + func(1, i+1, txn, prices, dp); //buy on present day

            dp[holding][i][txn] = Math.max(profit, Math.max(op1, op2));
        }else{
            int op1 = prices[i] + func(0, i+1, txn-1, prices, dp); //sell on present day
            int op2 = func(holding, i+1, txn, prices, dp); //skip present day

            dp[holding][i][txn] = Math.max(profit, Math.max(op1, op2));
        }
        return dp[holding][i][txn];
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[2][n][3];
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return func(0,0,2,prices,dp);
    }
}