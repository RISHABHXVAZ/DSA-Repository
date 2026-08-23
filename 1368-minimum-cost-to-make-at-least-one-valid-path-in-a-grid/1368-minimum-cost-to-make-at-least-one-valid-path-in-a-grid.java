class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[0][0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0, 0 });

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int r = p[0], c = p[1], cost = p[2];

            int nr = -1, nc = -1;
            if (grid[r][c] == 1) {
                nr = r;
                nc = c + 1;
            } else if (grid[r][c] == 2) {
                nr = r;
                nc = c - 1;
            } else if (grid[r][c] == 3) {
                nr = r + 1;
                nc = c;
            } else {
                nr = r - 1;
                nc = c;
            }

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && dist[nr][nc] > cost) {

                dist[nr][nc] = cost;
                q.add(new int[] { nr, nc, dist[nr][nc] });
            }
            if (r + 1 >= 0 && r + 1 < m && c >= 0 && c < n && dist[r + 1][c] > 1 + cost) {
                dist[r + 1][c] = 1 + cost;
                q.add(new int[] { r + 1, c, dist[r + 1][c] });
            }

            if (r - 1 >= 0 && r - 1 < m && c >= 0 && c < n && dist[r - 1][c] > 1 + cost) {
                dist[r - 1][c] = 1 + cost;
                q.add(new int[] { r - 1, c, dist[r - 1][c] });
            }

            if (r >= 0 && r < m && c + 1 >= 0 && c + 1 < n && dist[r][c + 1] > 1 + cost) {
                dist[r][c + 1] = 1 + cost;
                q.add(new int[] { r, c + 1, dist[r][c + 1] });
            }

            if (r >= 0 && r < m && c - 1 >= 0 && c - 1 < n && dist[r][c - 1] > 1 + cost) {
                dist[r][c - 1] = 1 + cost;
                q.add(new int[] { r, c - 1, dist[r][c - 1] });
            }
        }

        return dist[m - 1][n - 1];

    }
}