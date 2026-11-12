class Solution {
    int func(int r1, int c1, int c2, int[][] grid, int[][][] dp){
        int m = grid.length;
        int n = grid[0].length;
        int r2 = r1;
        if(r1 < 0 || c1 < 0 || r2 < 0 || c2 < 0) return (int)-1e9;
        if(r1 >= m || c1 >= n || r2 >= m || c2 >= n) return (int)-1e9;
        if(r1 == r2 && r1 == m-1){
            if(c1 == c2) return grid[r1][c1];
            return grid[r1][c1] + grid[r2][c2];
        }
        if(dp[r1][c1][c2] != -1) return dp[r1][c1][c2];
        int cherry = grid[r1][c1];
        if(r1 != r2 || c1 != c2){
            cherry += grid[r2][c2];
        }
        //both robots can move differently -> explore all and take best of them
        //left-left
        int op1 = func(r1+1,c1-1,c2-1,grid,dp);
        //bottom-left
        int op2 = func(r1+1,c1,c2-1,grid,dp);
        //right-left
        int op3 = func(r1+1,c1+1,c2-1,grid,dp);
        //left-bottom
        int op4 = func(r1+1,c1-1,c2,grid,dp);
        //right-bottom
        int op5 = func(r1+1,c1+1,c2,grid,dp);
        //bottom-bottom
        int op6 = func(r1+1,c1,c2,grid,dp);
        //left-right
        int op7 = func(r1+1,c1-1,c2+1,grid,dp);
        //bottom-right
        int op8 = func(r1+1,c1,c2+1,grid,dp);
        //right-right
        int op9 = func(r1+1,c1+1,c2+1,grid,dp);

        return dp[r1][c1][c2] = cherry + Math.max(op1, Math.max(Math.max(op2,op3), Math.max(op4, Math.max(op5, Math.max(op6, Math.max(op7, Math.max(op8,op9)))))));
    }
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return func(0,0,n-1,grid,dp);
    }
}