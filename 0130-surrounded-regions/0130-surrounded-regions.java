class Solution {
    static void dfs(char[][] board, int sr, int sc, boolean[][] vis){
        vis[sr][sc] = true;
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        for(int i = 0; i < 4; i++){
            int x = sr + dx[i];
            int y = sc + dy[i];
            if(x >= 0 && x < board.length && y >= 0 && y < board[0].length){
                if(board[x][y] == 'O' && vis[x][y] == false){
                    dfs(board, x, y, vis);
                }
            }
        }
    }
    public void solve(char[][] board) {
        //i will traverse all the boundaries and if i get any zero then i will do dfs and mark all the connected zeros as visited
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        
        //upper boundary
        for(int j = 0; j < n; j++){
            if(board[0][j] == 'O' && !vis[0][j]) dfs(board, 0, j, vis);
        }

        //left boundary
        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O' && !vis[i][0]) dfs(board, i, 0, vis);
        }

        //right boundary
        for(int i = 0; i < m; i++){
            if(board[i][n-1] == 'O' && !vis[i][n-1]) dfs(board, i, n-1, vis);
        }

        //bottom boundary
        for(int j = 0; j < n; j++){
            if(board[m-1][j] == 'O' && !vis[m-1][j]) dfs(board, m-1, j, vis);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O' && vis[i][j] == false){
                    board[i][j] = 'X';
                }
            }
        }

    }

}