class Solution {
    void dfs(int i, int j, char[][] grid, boolean[][] vis){
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        vis[i][j] = true;
        for(int k = 0; k < 4; k++){
            int nr = i + dx[k];
            int nc = j + dy[k];
            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == '1' && !vis[nr][nc]){
                dfs(nr, nc, grid, vis);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    ans = ans+1;
                    dfs(i,j, grid, vis);
                }
            }
        }

        return ans;
    }
}