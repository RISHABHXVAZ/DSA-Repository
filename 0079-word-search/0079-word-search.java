class Solution {
    boolean isValid(int nr, int nc, char[][] board){
        return nr>=0 && nr < board.length && nc >= 0 && nc < board[0].length;
    }
    boolean func(StringBuilder sb, int i, int j, int idx, String word, char[][] board, boolean[][] vis){
        if(word.charAt(idx) != board[i][j]) return false;

        if(idx == word.length() - 1 && word.charAt(idx) == board[i][j]) return true;

        vis[i][j] = true;
        int dx[] = {1,-1,0,0};
        int dy[] = {0,0,1,-1};
        for(int k = 0; k < 4; k++){
            int nr = i + dx[k];
            int nc = j + dy[k];
            if(isValid(nr, nc, board) && !vis[nr][nc]){
                sb.append(board[nr][nc]);
                if(func(sb, nr, nc, idx+1, word, board, vis)) return true;
                sb.deleteCharAt(sb.length()-1);
            }
        }
        vis[i][j] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                boolean[][] vis = new boolean[n][m];
                if(board[i][j] == word.charAt(0)){
                    if(func(new StringBuilder(board[i][j]),i,j,0,word,board,vis)) return true;
                }
            }
        }
        return false;
    }
}