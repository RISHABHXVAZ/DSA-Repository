class Solution {
    int prerequiste(int node, int[] time, List<List<Integer>> pre, int[] dp){
        if(dp[node-1] != -1) return dp[node-1];
        int max = 0;
      for(int it : pre.get(node)){
            int step = prerequiste(it, time, pre, dp);
            max = Math.max(max, step);
        }

        return dp[node-1] = time[node-1] + max;
    }
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> pre = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            pre.add(new ArrayList<>());
        }

        for(int i = 0; i < relations.length; i++){
            int u = relations[i][0];
            int v = relations[i][1];

            pre.get(v).add(u);
        }

        int max = 0;
        int[] dp;
         dp = new int[n+1];
            Arrays.fill(dp, -1);
        for(int i = 1; i <= n; i++){
            max = Math.max(max, prerequiste(i, time, pre, dp));
        }

        return max;
    }
}