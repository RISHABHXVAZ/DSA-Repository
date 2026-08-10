class Solution {
    int func(int start, int end, int[] pref, int[][] dp){
        if(start > end) return 0;
        if(dp[start][end] != -1) return dp[start][end];
        int op1 = pref[end] - pref[start] - func(start+1, end, pref, dp);
        int left = start-1 >= 0 ? pref[start-1]: 0;
        int right = end-1 >= 0 ? pref[end-1] : 0;
        int op2 = right - left - func(start, end-1, pref,dp);

        return dp[start][end] = (int)Math.max(op1, op2); 
    }
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] pref = new int[n];
        pref[0] = stones[0];
        for(int i = 1; i < n; i++){
            pref[i] = pref[i-1] + stones[i];
        }

        int[][] dp = new int[n+1][n+1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return func(0, n-1, pref, dp);
    }
}