class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        int dist[][] = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        pq.add(new int[]{0,0,1});
        dist[0][0] = 1;
        while(!pq.isEmpty()){
            int row = pq.peek()[0];
            int col = pq.peek()[1];
            int distance = pq.peek()[2];
            pq.remove();
            int dx[] = {-1,-1,-1,1,1,1,0,0};
            int dy[] = {-1,0,1,-1,0,1,-1,1};
            for(int i = 0; i < 8; i++){
                int nr = row + dx[i];
                int nc = col + dy[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < n){
                    if(grid[nr][nc] == 0 && (distance+1 < dist[nr][nc])){
                    dist[nr][nc] = distance+1;
                    pq.add(new int[]{nr,nc,dist[nr][nc]});
                    }
                }
            }
        }
        return dist[n-1][n-1] != Integer.MAX_VALUE ? dist[n-1][n-1] : -1;
    }
}