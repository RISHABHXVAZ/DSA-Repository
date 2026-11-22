class Solution {
    int func(int i, int k, List<List<Integer>> piles, int[][] dp){
        if(i == piles.size()) return 0;
        if(k == 0) return 0;
        if(dp[i][k] != -1) return dp[i][k];
        int skip = func(i+1, k, piles,dp);
        int take = 0;
        int sum = 0;
        for(int coins = 1; coins <= Math.min(k,piles.get(i).size()); coins++){
            sum += piles.get(i).get(coins-1);
            take = Math.max(take, sum + func(i+1, Math.max(0, k-coins), piles,dp));
        }
        return dp[i][k] = (int)Math.max(take, skip);
    }
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] dp = new int[n][k+1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return func(0, k, piles, dp);
    }
}