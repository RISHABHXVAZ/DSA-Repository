class Solution {
    static void dfs(char[][] board, int r, int c, boolean[][] vis){
        int rows = board.length;
        int cols = board[0].length;
        vis[r][c] = true;
        int dx[] = {0,0,-1,1};
        int dy[] = {-1,1,0,0};
        for(int i = 0; i < 4; i++){
            int x = r + dx[i];
            int y = c + dy[i];
            if(x >= 0 && x < rows && y >= 0 && y < cols){
                if(board[x][y] == 'O' && vis[x][y] == false){
                    dfs(board, x, y, vis);
                }
            }
        }
    }
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] vis = new boolean[rows][cols];

    //checking 1st row
        for(int j = 0; j < cols; j++){
            if(board[0][j] == 'O' && vis[0][j] == false){
                dfs(board,0,j,vis);
            }
        }
    //checking 1st col
        for(int i = 0; i < rows; i++){
            if(board[i][0] == 'O' && vis[i][0] == false){
                dfs(board,i,0,vis);
            }
        }
    //checking last row
        for(int j = 0; j < cols; j++){
            if(board[rows-1][j] == 'O' && vis[rows-1][j] == false){
                dfs(board,rows-1,j,vis);
            }
        }
    //checking last column
        for(int i = 0; i < rows; i++){
            if(board[i][cols-1] == 'O' && vis[i][cols-1] == false){
                dfs(board,i,cols-1,vis);
            }
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'O' && vis[i][j] == false){
                    board[i][j] = 'X';
                }
            }
        }

        return;
    }
}