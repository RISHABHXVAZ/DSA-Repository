class Solution {
    static void dfs(int[][] grid, int sr, int sc , boolean[][] vis){
        vis[sr][sc] = true;
        int dx[] = {1,-1,0,0};
        int dy[] = {0,0,1,-1};
        for(int i = 0; i < 4; i++){
            int x = sr + dx[i];
            int y = sc + dy[i];
            if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length){
                if(grid[x][y] == 1 && vis[x][y] == false){
                    dfs(grid, x , y, vis);
                }
            }
        }
        
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];

        for(int j = 0; j < n; j++){
            if(grid[0][j] == 1 && vis[0][j] == false) dfs(grid, 0, j , vis);
        }
        for(int i = 0; i < m; i++){
            if(grid[i][0] == 1 && vis[i][0] == false) dfs(grid, i, 0, vis);
        }
        for(int j = 0; j < n; j++){
            if(grid[m-1][j] == 1 && vis[m-1][j] == false) dfs(grid, m-1, j, vis);
        }
        for(int i = 0; i < m; i++){
            if(grid[i][n-1] == 1 && vis[i][n-1] == false) dfs(grid, i, n-1, vis);
        }

        int count = 0;
        for(int i = 0; i < m;i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && vis[i][j] == false) count++;
            }
        }
        return count;
    }
}