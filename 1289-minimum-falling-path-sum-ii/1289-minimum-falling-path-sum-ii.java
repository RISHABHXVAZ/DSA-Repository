class Solution {
    int func(int curr_row, int prev_col, int[][] grid, int[][] dp){
        int n = grid.length;
        if(curr_row == n) return 0;
        if(dp[curr_row][prev_col+1] != Integer.MAX_VALUE) return dp[curr_row][prev_col+1];
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            if(j != prev_col){
                int step = grid[curr_row][j] + func(curr_row+1, j, grid,dp);
                ans = Math.min(ans, step);
            }
        }
        return dp[curr_row][prev_col+1] = ans;
    }
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n+1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        return func(0, -1, grid, dp); //current_row, prev_col, grid
    }
}