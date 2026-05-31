class Solution {
    int func(int i, int j, int[] cuts, int[][] dp){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        dp[i][j] = Integer.MAX_VALUE;
        int steps = 0;
        for(int k = i; k <= j; k++){
            steps = cuts[j+1]-cuts[i-1] + func(i, k-1, cuts,dp) + func(k+1, j, cuts,dp);
            dp[i][j] = Math.min(dp[i][j], steps);
        }
        return dp[i][j];
    }
    public int minCost(int n, int[] cuts) {
        int l = cuts.length;
        
        Arrays.sort(cuts);
        int[] newarray = new int[l+2];
        newarray[0] = 0;
        newarray[l+1] = n;
        for(int i = 1; i <= l; i++){
            newarray[i] = cuts[i-1];
        }

        int[][] dp = new int[l+2][l+2];
    
        for(int i = l; i >= 1; i--){
            for(int j = 1; j <= l; j++){
                if(i > j) dp[i][j] = 0;
                else{
                    dp[i][j] = Integer.MAX_VALUE;
                    int steps = 0;
                    for(int k = i; k <= j; k++){
                        steps = newarray[j+1]-newarray[i-1] + dp[i][k-1] + dp[k+1][j];
                        dp[i][j] = Math.min(dp[i][j], steps);
                    }
                }
            }
        }

        return dp[1][l];
    }
}