class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] r : roads) {
            adj.get(r[0]).add(new int[]{r[1], r[2]});
            adj.get(r[1]).add(new int[]{r[0], r[2]});
        }

        PriorityQueue<long[]> pq =
                new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        int[] ways = new int[n];

        dist[0] = 0;
        ways[0] = 1;
        pq.add(new long[]{0, 0});

        int mod = (int) 1e9 + 7;

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long dis = cur[0];
            int node = (int) cur[1];

            if (dis > dist[node]) continue;

            for (int[] nei : adj.get(node)) {
                int next = nei[0];
                long wt = nei[1];
                long newDist = dis + wt;

                if (newDist < dist[next]) {
                    dist[next] = newDist;
                    ways[next] = ways[node];
                    pq.add(new long[]{newDist, next});
                } else if (newDist == dist[next]) {
                    ways[next] = (ways[next] + ways[node]) % mod;
                }
            }
        }
        return ways[n - 1];
    }
}
