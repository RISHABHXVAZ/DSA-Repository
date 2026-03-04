class Solution {
    boolean isValid(int newr, int newc, int n){
        return newr >= 0 && newr < n && newc >= 0 && newc < n;
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dist = new int[n][n];
        boolean[][] vis = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] { grid[0][0], 0, 0 });
        dist[0][0] = grid[0][0];
        while (!pq.isEmpty()) {
            int t = pq.peek()[0];
            int r = pq.peek()[1];
            int c = pq.peek()[2];
            pq.remove();
            int[] dx = { 1, -1, 0, 0 };
            int[] dy = { 0, 0, 1, -1 };
            for (int i = 0; i < 4; i++) {
                int newr = r + dx[i];
                int newc = c + dy[i];
                if (isValid(newr, newc, n)) {
                    if (!vis[newr][newc] && dist[newr][newc] > grid[newr][newc]) {
                        vis[newr][newc] = true;
                        if (grid[newr][newc] < t) {
                            pq.add(new int[] { t, newr, newc });
                            dist[newr][newc] = t;
                        } else {
                            pq.add(new int[] { grid[newr][newc], newr, newc });
                            dist[newr][newc] = grid[newr][newc];
                        }
                    }
                }
            }
        }
        return dist[n-1][n-1];
    }
}