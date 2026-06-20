class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int i = 0; i < flights.length; i++){
            int from = flights[i][0];
            int to = flights[i][1];
            int price = flights[i][2];
            adj.get(from).add(new int[]{to, price});
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, src, -1});

        while(!q.isEmpty()){
            int[] p = q.poll();
            int d = p[0], node = p[1], stops = p[2]; 
            for(int[] it: adj.get(node)){
                int ngh = it[0], w = it[1];
                if(dist[ngh] > w + d && stops+1 <= k){
                    dist[ngh] = w+d;
                    q.add(new int[]{dist[ngh], ngh, stops+1});
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}