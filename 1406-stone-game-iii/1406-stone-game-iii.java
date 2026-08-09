class Solution {
    int func(int i, int[] stoneValue, int[] suff, int[] dp){
        int n = stoneValue.length;
        if(dp[i] != -1) return dp[i];

        if(i == stoneValue.length) return 0;
        int max = Integer.MIN_VALUE;
        for(int x = 1; x <= 3 && i+x-1< n; x++){
            int opp = func(i+x, stoneValue, suff, dp);
            max = Math.max(max, suff[i]-opp);
        }

        return dp[i] = max;
        
    }
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] suff = new int[n];
        suff[n-1] = stoneValue[n-1];
        for(int i = n-2; i >= 0; i--) suff[i] = suff[i+1] + stoneValue[i];

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        int alice = func(0, stoneValue, suff, dp); // i, diff, turn
        int bob = suff[0] - alice;
        if(alice > bob) return "Alice";
        else if(bob > alice) return "Bob";

        return "Tie";
    }
}