class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < n+1; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < times.length; i++){
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];

            adj.get(u).add(new int[]{v,w});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]); 
        pq.add(new int[]{0, k});

        while(!pq.isEmpty()){
            int[] p = pq.poll();
            int t = p[0], node = p[1];

            for(int[] it : adj.get(node)){
                int ngh = it[0], time = it[1];
                if(dist[ngh] > time+t){
                    dist[ngh] = time+t;
                    pq.add(new int[]{dist[ngh], ngh});
                }
            }
        }

        int ans = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}