class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(triangle.size()-1).size();

        int[][] dp = new int[m][n];

        dp[0][0] = triangle.get(0).get(0);

        for(int i = 1; i < m; i++){
            for(int j = 0; j < triangle.get(i).size(); j++){
                if(j == 0) dp[i][0] = triangle.get(i).get(0) + dp[i-1][0];
                else if(j == triangle.get(i).size()-1) dp[i][j] = triangle.get(i).get(j)+dp[i-1][j-1];
                else dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i-1][j], dp[i-1][j-1]);       
             }
        }
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            ans = Math.min(ans, dp[m-1][j]);
        }
        return ans;
    }
}