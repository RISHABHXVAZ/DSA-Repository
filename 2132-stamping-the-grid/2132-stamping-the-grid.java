class Solution {
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int m = grid.length;
        int n = grid[0].length;

        // 1. Build 1-indexed 2D Prefix Sum array
        int[][] prefix = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefix[i + 1][j + 1] = grid[i][j] 
                                     + prefix[i][j + 1] 
                                     + prefix[i + 1][j] 
                                     - prefix[i][j];
            }
        }

        // 2. 2D Difference Array (size m+2 x n+2 for safe r2+1, c2+1 writes)
        int[][] diff = new int[m + 2][n + 2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r2 = i, c2 = j;
                int r1 = r2 - stampHeight + 1;
                int c1 = c2 - stampWidth + 1;

                if (r1 >= 0 && c1 >= 0) {
                    int sum = prefix[r2 + 1][c2 + 1] 
                            - prefix[r1][c2 + 1] 
                            - prefix[r2 + 1][c1] 
                            + prefix[r1][c1];

                    if (sum == 0) {
                        diff[r1][c1] += 1;
                        diff[r2 + 1][c1] -= 1;
                        diff[r1][c2 + 1] -= 1;
                        diff[r2 + 1][c2 + 1] += 1;
                    }
                }
            }
        }

        // 3. Reconstruct coverage matrix & verify empty cells
        int[][] ans = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {       // Fixed loop limit to m
            for (int j = 0; j < n; j++) {
                ans[i + 1][j + 1] = diff[i][j] 
                                  + ans[i][j + 1] 
                                  + ans[i + 1][j] 
                                  - ans[i][j];

                // If grid cell is 0 and reconstructed stamp coverage is 0
                if (grid[i][j] == 0 && ans[i + 1][j + 1] == 0) {
                    return false;
                }
            }
        }

        return true;
    }
}