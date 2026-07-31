class Solution {
    int func(int i, int diff , int total, int[] rods, int[][] dp){
        if(i == rods.length){
            if(diff == 0) return 0;
            return (int)-1e9;
        }

        int diffidx = diff + total;
        if(dp[i][diffidx] != -1) return dp[i][diffidx];

        int op1 = rods[i] + func(i+1, diff + rods[i], total, rods, dp);
        int op2 = func(i+1, diff-rods[i], total, rods, dp);
        int op3 = func(i+1, diff, total, rods, dp);

        return dp[i][diffidx] = Math.max(op1, Math.max(op2, op3));
    }
    public int tallestBillboard(int[] rods) {
     int n = rods.length;
     int total = 0;
     for(int i = 0; i < n; i++) total += rods[i];
     int[][] dp = new int[n][2*total+1];
     for(int i = 0; i < n; i++){
        Arrays.fill(dp[i], -1);
     }
     return func(0, 0, total, rods, dp);  
    }
}