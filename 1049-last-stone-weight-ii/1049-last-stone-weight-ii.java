class Solution {
    int func(int i, int target, int[] stones, int[][] dp){
        if(i == stones.length) return 0;
        if(dp[i][target] != -1) return dp[i][target];
        int take = 0;
        if(stones[i] <= target) take = stones[i] + func(i+1, target-stones[i], stones, dp);
        int skip = func(i+1, target, stones, dp);
        return dp[i][target] = Math.max(take, skip);
    }
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += stones[i];
        }
        int target = sum/2;
        int[][] dp = new int[n][target+1];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        int s1 = func(0, target, stones, dp);
        return sum - 2*s1;
    }
}