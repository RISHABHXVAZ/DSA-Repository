class Solution {
    void dfs(int[][] ans,int[][] image, int r, int c,int init, int color){
        int rows = ans.length;
        int cols = ans[0].length;
        ans[r][c] = color;
        int dx[] = {0,0,-1,1};
        int dy[] = {-1,1,0,0};
        for(int i = 0; i < 4; i++){
            int nrow = r + dx[i];
            int ncol = c + dy[i];
            if(nrow >= 0 && ncol >= 0 && nrow < rows && ncol < cols && image[nrow][ncol] == init && ans[nrow][ncol] != color){
                dfs(ans,image, nrow, ncol, init, color);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans = image;
        int initColor = image[sr][sc];
        dfs(ans,image, sr, sc,initColor,color);
        return ans;
    }
}