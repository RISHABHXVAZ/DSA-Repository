class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] ans = new int[m][n];
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0) q.add(new int[]{i, j, 0});
                if(mat[i][j] != 0) ans[i][j] = Integer.MAX_VALUE;
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while(!q.isEmpty()){
            int[] p = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && p[2]+1 < ans[nx][ny]){
                    ans[nx][ny] = p[2]+1;
                    q.add(new int[]{nx, ny, p[2]+1});
                }
            }
        }

        return ans;
    }
}