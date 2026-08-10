class Solution {
    int func(int start, int end, int[] pref, int[][] dp){
        if(start == end) return 0;
        if(dp[start][end] != -1) return dp[start][end];

        int ans = Integer.MIN_VALUE;
        for(int j = start; j <= end; j++){
            int leftscore = start-1 >= 0 ? pref[j]-pref[start-1] : pref[j];
            int rightscore = pref[end] - pref[j];
            if(leftscore > rightscore){
                ans = Math.max(ans, rightscore + func(j+1, end, pref,dp));
            }else if(rightscore > leftscore){
                ans = Math.max(ans, leftscore + func(start, j, pref,dp));
            }else{
                int op1 = rightscore + func(j+1, end, pref,dp);
                int op2 = leftscore + func(start, j, pref,dp);
                ans = Math.max(ans, Math.max(op1, op2));
            }
        }

        return dp[start][end] = ans;
    }
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] pref = new int[n];
        pref[0] = stoneValue[0];

        for(int i = 1; i < n; i++){
            pref[i] = pref[i-1] + stoneValue[i];
        }
        int[][] dp = new int[n+1][n+1];
        for(int i = 0; i <= n; i++) Arrays.fill(dp[i], -1);

        return func(0, n-1, pref, dp);
    }
}