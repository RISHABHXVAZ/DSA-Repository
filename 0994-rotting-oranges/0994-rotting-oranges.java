class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    vis[i][j] = true;
                    q.add(new int[]{i,j});
                }
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int time = -1;
        while(!q.isEmpty()){
            int size = q.size();
            time++;
            for(int i = 0; i < size; i++){
                int[] p = q.poll();
                int r = p[0], c = p[1];
                
                for(int j = 0; j < 4; j++){
                    int nr = r + dx[j];
                    int nc = c + dy[j];
                    if(nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc] && grid[nr][nc] == 1){
                        vis[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !vis[i][j]) return -1;
            }
        }

        return time == -1 ? 0 : time;
    }
}