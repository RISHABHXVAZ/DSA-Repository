class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    vis[i][j] = true;
                    q.add(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty()){
            int point[] = q.poll();
            int[] dx = {1,-1,0,0};
            int[] dy = {0,0,1,-1};
            for(int i = 0; i < 4; i++){
                int x = point[0] + dx[i];
                int y = point[1] + dy[i];
                if(x >= 0 && x < m && y >= 0 && y < n){
                    if(mat[x][y] == 1 && vis[x][y] == false){
                        mat[x][y] = mat[point[0]][point[1]] + 1;
                        vis[x][y] = true;
                        q.add(new int[]{x,y});
                    }
                }
            }
        }
        return mat;
    }
}