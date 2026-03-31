class Solution {

    boolean isSafe(int r, int c, int num, boolean[][] row, boolean[][] col, boolean[][] grid){
        int b = (r/3)*3 + (c/3);
        return !row[r][num] && !col[c][num] && !grid[b][num];
    }

    boolean func(int i, int j, char[][] board,
                 boolean[][] row, boolean[][] col, boolean[][] grid){

        if(i == 9) return true;

        int nr = (j == 8) ? i + 1 : i;
        int nc = (j == 8) ? 0 : j + 1;

        if(board[i][j] != '.'){
            return func(nr, nc, board, row, col, grid);
        }

        for(int num = 1; num <= 9; num++){
            if(isSafe(i, j, num, row, col, grid)){

                int b = (i/3)*3 + (j/3);

                board[i][j] = (char)(num + '0');
                row[i][num] = col[j][num] = grid[b][num] = true;

                if(func(nr, nc, board, row, col, grid)) return true;

                // backtrack
                board[i][j] = '.';
                row[i][num] = col[j][num] = grid[b][num] = false;
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {

        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] grid = new boolean[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    int b = (i / 3) * 3 + (j / 3);
                    row[i][num] = col[j][num] = grid[b][num] = true;
                }
            }
        }

        func(0, 0, board, row, col, grid);
    }
}