class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(triangle.size()-1).size();

        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < triangle.size(); i++){
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
        }

        for(int i = 1; i < triangle.size(); i++){
            for(int j = 1; j < triangle.get(i).size(); j++){
                if(dp[i-1][j] != Integer.MAX_VALUE){
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                }
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + triangle.get(i).get(j));
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            ans = Math.min(ans, dp[m-1][i]);
        }
        return (int)ans;
    }
}