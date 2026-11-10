class Solution {
    int func(int i, int j, int[][] grid, int[][] dp){
        int m = grid.length;
        int n = grid[0].length;
        if(i == m-1 && j == n-1) return grid[i][j];
        if(dp[i][j] != -1) return dp[i][j];

        int right = Integer.MAX_VALUE;
        if(j+1 < n){
            int r = func(i,j+1, grid,dp);
            if(r != Integer.MAX_VALUE) right = grid[i][j] + r;
        }

        int down = Integer.MAX_VALUE;
        if(i+1 < m){
            int d = func(i+1, j, grid,dp);
            if(d != Integer.MAX_VALUE) down = grid[i][j] + d;
        }

        return dp[i][j] = (int)Math.min(right, down);
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }
        return func(0,0,grid,dp);
    }
}