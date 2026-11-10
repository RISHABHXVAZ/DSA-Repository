class Solution {
    boolean func(int i, int prev, int[] stones, Boolean[][] dp){
        int n = stones.length;
        int prev_jump = stones[i] - stones[prev];
        if(i == n-1) return true;
        if(dp[i][prev] != null) return dp[i][prev];
        boolean ans = false;
        for(int j = i+1; j < n; j++){
            int jump = stones[j] - stones[i];
            if(jump < prev_jump-1) continue;
            if(jump > prev_jump+1) break;
            if(func(j,i,stones,dp)){
                ans = true;
                break;
            }
        }
        return dp[i][prev] = ans;
    }
    public boolean canCross(int[] stones) {
        int n = stones.length;
        if(stones[1] - stones[0] > 1) return false;
        Boolean[][] dp = new Boolean[n][n];
        
        return func(1, 0, stones, dp);
    }
}