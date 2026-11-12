class Solution {
    //r1 + c1 = r2 + c2 at all times because it is simulataneous dfs starting from (0,0)
    int func(int r1, int c1, int r2, int[][] grid, int[][][] dp){
        int n = grid.length;
        int c2 = r1+c1-r2;
        if(r1 >= n || c1 >= n || r2 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1){
            return (int)-1e9;
        }
        if(r1 == r2 && c1 == c2 && r1 == n-1 && c1 == n-1) return grid[r1][c1];
        if(dp[r1][c1][r2] != -1) return dp[r1][c1][r2];
        int cherry = grid[r1][c1];
        if(r1 != r2){
            cherry += grid[r2][c2];
        }
        int op1 = func(r1,c1+1,r2,grid,dp); //right-right
        int op2 = func(r1+1,c1,r2+1,grid,dp); //down-down
        int op3 = func(r1, c1+1, r2+1, grid,dp); //right-down
        int op4 = func(r1+1,c1,r2, grid,dp); //down - right

        return dp[r1][c1][r2] = cherry + Math.max(Math.max(op1, op2), Math.max(op3, op4));
    }
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n][n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return (int)Math.max(0,func(0,0,0,grid,dp));
    }
}