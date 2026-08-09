class Solution {
    int func(int i, int M, int[] piles, int[] suff, int[][] dp){
        int n = piles.length;
        if(dp[i][M] != -1) return dp[i][M];

        if(i + 2*M >= n) return suff[i];
        int max = 0;
       for(int x = 1; x <= 2*M; x++){
            int opp = func(i+x, Math.max(x, M), piles, suff, dp);
            max = Math.max(max, suff[i]-opp);
       }

       return dp[i][M] = max;
    }
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suff = new int[n];
        suff[n-1] = piles[n-1];
        for(int i = n-2;i>=0;i--){
            suff[i] = suff[i+1] + piles[i];
        }
        int[][] dp = new int[n][2*n+1];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        return func(0, 1, piles, suff, dp);
    }
}