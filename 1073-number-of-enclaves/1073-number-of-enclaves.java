class Solution {
    static void dfs(int[][] grid, int r, int c, boolean[][] vis){
        int rows = grid.length;
        int cols = grid[0].length;
        vis[r][c] = true;
        
        int dx[] = {0,0,-1,1};
        int dy[] = {-1,1,0,0};
        for(int i = 0; i < 4; i++){
            int x = r + dx[i];
            int y = c + dy[i];
            if(x >= 0 && x < rows && y >= 0 && y < cols){
                if(grid[x][y] == 1 && vis[x][y] == false){
                    dfs(grid, x, y, vis);
                }
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] vis = new boolean[rows][cols];
        //checking 1st row
        for(int j = 0; j < cols; j++){
            if(grid[0][j] == 1  && vis[0][j] == false){
                dfs(grid, 0, j, vis);
            }
        }
        for(int i = 0; i < rows; i++){
            if(grid[i][0] == 1 && vis[i][0] == false){
                dfs(grid, i, 0, vis);
            }
        }
        for(int j = 0; j < cols; j++){
            if(grid[rows-1][j] == 1 && vis[rows-1][j] == false){
                dfs(grid, rows-1, j, vis);
            }
        }
        for(int i = 0; i < rows; i++){
            if(grid[i][cols-1] == 1 && vis[i][cols-1] == false){
                dfs(grid, i, cols-1, vis);
            }
        }

        int cnt = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1 && vis[i][j] == false) cnt++;
            }
        }
        return cnt;
    }
}