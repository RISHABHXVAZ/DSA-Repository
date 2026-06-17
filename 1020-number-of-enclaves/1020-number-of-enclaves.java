class Solution {
    void dfs(int i , int j, int[][] grid, boolean[][] vis){
        
        vis[i][j] = true;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for(int k = 0; k < 4; k++){
            int nx = i + dx[k];
            int ny = j + dy[k];

            if(nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 1 && !vis[nx][ny]){
                dfs(nx, ny, grid, vis);
            }
        }

        return;
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        for(int j = 0; j < n; j++){
            if(grid[0][j] == 1 && !vis[0][j]) dfs(0, j, grid, vis);
        }

        for(int j = 0; j < n; j++){
            if(grid[m-1][j] == 1 && !vis[m-1][j]) dfs(m-1, j, grid, vis);
        }

        for(int i = 0; i < m; i++){
            if(grid[i][0] == 1 && !vis[i][0]) dfs(i, 0, grid, vis);
        }

        for(int i = 0; i < m; i++){
            if(grid[i][n-1] == 1 && !vis[i][n-1]) dfs(i, n-1, grid, vis);
        }

        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && !vis[i][j]) ans++;
            }
        }
        
        return ans;
    }
}