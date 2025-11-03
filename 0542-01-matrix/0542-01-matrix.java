class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        boolean vis[][] = new boolean[rows][cols];
        int ans[][] = new int[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j,0});
                    vis[i][j] = true;
                }
            }
        }
        int dx[] = {-1,0,1,0};
        int dy[] = {0,1,0,-1};
        while(!q.isEmpty()){
            int point[] = q.poll();
            int r = point[0];
            int c = point[1];
            int dist = point[2];
            ans[r][c] = dist;
            for(int i = 0; i < 4; i++){
                int x = r + dx[i];
                int y = c + dy[i];
                if(x >= 0 && x < rows && y >= 0 && y < cols && vis[x][y] == false){
                    vis[x][y] = true;
                    q.add(new int[]{x,y,dist+1});
                }
            }
        }
        return ans;
    }
}