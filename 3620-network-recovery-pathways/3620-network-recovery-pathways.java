import java.util.*;

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        if (!online[0] || !online[n - 1]) return -1;

        // 1. Build the adjacency list and collect all unique edge weights
        List<List<int[]>> adj = new ArrayList<>();
        TreeSet<Integer> uniqueWeights = new TreeSet<>();
        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            adj.get(u).add(new int[]{v, weight});
            uniqueWeights.add(weight);
        }

        // Convert unique weights to an array for binary searching
        List<Integer> weightsList = new ArrayList<>(uniqueWeights);
        
        int low = 0;
        int high = weightsList.size() - 1;
        int ans = -1;

        // 2. Binary Search for the maximum allowed bottleneck weight
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int targetWeight = weightsList.get(mid);

            if (isPossible(adj, online, n, k, targetWeight)) {
                ans = targetWeight; // This weight is possible, try to find a larger one
                low = mid + 1;
            } else {
                high = mid - 1; // Too restrictive, try a smaller weight
            }
        }

        return ans;
    }

    // 3. Dijkstra's algorithm to check if a path exists with total cost <= k
    // using only edges >= minWeightThreshold
    private boolean isPossible(List<List<int[]>> adj, boolean[] online, int n, long k, int minWeightThreshold) {
        // PriorityQueue stores [currentNode, currentDistance] sorted by distance ascending
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;
        pq.add(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int u = (int) curr[0];
            long d = curr[1];

            if (d > dist[u]) continue;
            if (u == n - 1) return d <= k;

            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];

                // Skip if the node is offline or the edge weight is below our binary search threshold
                if (!online[v] || weight < minWeightThreshold) continue;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    if (dist[v] <= k) {
                        pq.add(new long[]{v, dist[v]});
                    }
                }
            }
        }

        return dist[n - 1] <= k;
    }
}