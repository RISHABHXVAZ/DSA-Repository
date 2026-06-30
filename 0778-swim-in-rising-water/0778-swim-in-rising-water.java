class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.add(new int[]{grid[0][0], 0, 0});
        boolean[][] vis = new boolean[n][n];

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        while(!pq.isEmpty()){
            int[] p = pq.poll();
            int t = p[0], r = p[1], c = p[2];
            vis[r][c] = true;
            if(r == n-1 && c == n-1) return t;

            for(int i = 0; i < 4; i++){
                int nx = r + dx[i];
                int ny = c + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !vis[nx][ny]){
                    if(grid[nx][ny] > t) pq.add(new int[]{grid[nx][ny], nx, ny});
                    else pq.add(new int[]{t, nx, ny});
                }
            }

        }

        return -1;
    }
}