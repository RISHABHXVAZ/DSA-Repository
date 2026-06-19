class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1) return -1;

        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);

        Queue<int[]> pq = new LinkedList<>();
        pq.add(new int[]{1, 0, 0});
        dist[0][0] = 1;

        int[] dx = {1, 1, 1, -1, -1 , -1, 0, 0};
        int[] dy = {0, 1, -1, 0, 1, -1, 1, -1};
        while(!pq.isEmpty()){
            int[] p = pq.poll();
            int d = p[0], r = p[1], c = p[2];

            for(int i = 0; i < 8; i++){
                int nx = r + dx[i];
                int ny = c + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 0 && dist[nx][ny] > d + 1){
                    dist[nx][ny] = d + 1;
                    pq.add(new int[]{dist[nx][ny], nx, ny});
                }
            }
        }

        return dist[n-1][n-1] == Integer.MAX_VALUE ? -1 : dist[n-1][n-1];
    }
}