class Solution {
    int func(int i, int j, List<List<Integer>> triangle, int[][] dp){
        int m = triangle.size();
        if(i == m-1) return triangle.get(i).get(j);
        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
        int op1 = triangle.get(i).get(j) + func(i+1,j, triangle,dp);
        int op2 = triangle.get(i).get(j) + func(i+1,j+1,triangle,dp);
        return dp[i][j] = (int)Math.min(op1, op2);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        return func(0,0,triangle,dp);
    }
}