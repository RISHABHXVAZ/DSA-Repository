class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int[n][n];

        for(int i = 0; i < queries.length; i++){
            int r1 = queries[i][0];
            int c1 = queries[i][1];
            int r2 = queries[i][2];
            int c2 = queries[i][3];

            diff[r1][c1] += 1;
            if(r2 < n-1) diff[r2+1][c1] -= 1;
            if(c2 < n-1) diff[r1][c2+1] -= 1;
            if(r2 < n-1 && c2 < n-1) diff[r2+1][c2+1] += 1;
        }

        int[][] ans = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int left = j > 0 ? ans[i][j-1]: 0;
                int up = i > 0 ? ans[i-1][j]: 0;
                int topleft = i > 0 && j > 0 ? ans[i-1][j-1] : 0;

                ans[i][j] = diff[i][j] + left + up - topleft;
            }
        }
        
        return ans;
    }
}