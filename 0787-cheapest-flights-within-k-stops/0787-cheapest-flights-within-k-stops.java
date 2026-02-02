class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < flights.length; i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int price = flights[i][2];
            adj.get(u).add(new int[]{v,price});
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,src,0});
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        while(!q.isEmpty()){
            int stops = q.peek()[0];
            int node = q.peek()[1];
            int distance = q.peek()[2];
            q.remove();
            if(stops > k) break;
            for(int[] it: adj.get(node)){
                if(distance + it[1] < dist[it[0]]){
                    dist[it[0]] = distance + it[1];
                    q.add(new int[]{stops+1,it[0],dist[it[0]]});
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE?-1:dist[dst]; 
    }
}