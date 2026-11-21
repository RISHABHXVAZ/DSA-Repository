class Solution {
    int func(int i, int idx, int k, List<List<Integer>> piles, int[][][] dp){
        if(i == piles.size()) return 0;
        if(k == 0) return 0;
        if(dp[i][idx][k] != -1) return dp[i][idx][k];
        if(idx == piles.get(i).size()) return dp[i][idx][k] = func(i+1, 0, k, piles,dp);
        int take = piles.get(i).get(idx) + func(i, idx+1, k-1, piles,dp);
        int skip = func(i+1, 0, k, piles,dp);
        return dp[i][idx][k] = (int)Math.max(take, skip);
    }
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int max = 0;
        for(List<Integer> lst : piles){
            max = Math.max(max, lst.size());
        }
        int[][][] dp = new int[n][max+1][k+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= max; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return func(0, 0, k, piles, dp);
    }
}