import java.util.*;

class Solution {
    // You can keep isValid if you want, but it's not needed for the main logic.
    
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        if (n == 1) return 0;
        
        // 1. Build Adjacency List
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new int[]{v, w});
// Assuming undirected graph based on previous prompts
        }

        // 2. 2D Dist Array: dist[node][rep_count]
        // rep can range from 1 to k. Size k + 1 avoids index out of bounds.
        int[][] dist = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        // Base case: Node 0 starts with a distance of 0 and an initial character streak of 1
        dist[0][1] = 0;
        q.add(new int[]{0, 0, 1});

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int w = p[0];
            int node = p[1];
            int rep = p[2];

            // Optimization: If we found a strictly better path to this specific state, skip processing
            if (w > dist[node][rep]) continue;
            
            // Early exit optimization
            if (node == n - 1) return w;

            for (int[] it : adj.get(node)) {
                int ngh = it[0];
                int wght = it[1];

                // Determine what the next streak would be
                int nextRep = (labels.charAt(node) != labels.charAt(ngh)) ? 1 : rep + 1;

                // Validate state transition against constraint k
                if (nextRep <= k) {
                    // Check against the 2D state matrix instead of a 1D global value
                    if (w + wght < dist[ngh][nextRep]) {
                        dist[ngh][nextRep] = w + wght;
                        q.add(new int[]{dist[ngh][nextRep], ngh, nextRep});
                    }
                }
            }
        }

        // 3. Extract the absolute minimum path leading to the target node across all valid streaks
        int minFinalDist = Integer.MAX_VALUE;
        for (int r = 1; r <= k; r++) {
            minFinalDist = Math.min(minFinalDist, dist[n - 1][r]);
        }

        return minFinalDist == Integer.MAX_VALUE ? -1 : minFinalDist;
    }
}