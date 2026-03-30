class Solution {
    void func(int i, int[][] grid, int n, boolean[] col, boolean[] diag1, boolean[] diag2, List<List<String>> ans) {
        if (i == grid.length) {
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                String s = "";
                for (int k = 0; k < n; k++) {
                    if (grid[j][k] == 1)
                        s += "Q";
                    else
                        s += ".";
                }
                temp.add(s);
            }
            ans.add(temp);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (!col[j] && !diag1[i - j + n - 1] && !diag2[i + j]) {
                grid[i][j] = 1;
                col[j] = true;
                diag1[i - j + n - 1] = true;
                diag2[i + j] = true;
                func(i + 1, grid, n, col, diag1, diag2, ans);
                grid[i][j] = 0;
                col[j] = false;
                diag1[i - j + n - 1] = false;
                diag2[i + j] = false;
            }
        }

    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[][] grid = new int[n][n];

        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n];
        boolean[] diag2 = new boolean[2 * n];

        func(0, grid, n, col, diag1, diag2, ans);

        return ans;
    }
}