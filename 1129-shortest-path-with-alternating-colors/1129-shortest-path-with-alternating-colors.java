class Solution {
    void func(int node, int color, int cost, List<List<int[]>> adj, int[][] dist){
        for(int[] it : adj.get(node)){
            int ngh = it[0], c = it[1];
            if(c != color && dist[ngh][c] > 1 + cost){
                dist[ngh][c] = 1 + cost;
                func(ngh, c, dist[ngh][c], adj, dist);
            }
        }
    }
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < redEdges.length; i++){
            int u = redEdges[i][0];
            int v = redEdges[i][1];

            adj.get(u).add(new int[]{v, 1});
        }

        for(int i = 0; i < blueEdges.length; i++){
            int u = blueEdges[i][0];
            int v = blueEdges[i][1];

            adj.get(u).add(new int[]{v,2});
        }

        int[][] dist = new int[n][3];
        for(int i = 0; i < n; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = 0;
        dist[0][1] = 0;
        dist[0][2] = 0;

        func(0, 0, 0, adj, dist); //0 -> no color, 1 -> red, 2 -> blue

        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            int val = Math.min(dist[i][1], dist[i][2]);
            if(i == 0) ans[i] = 0;
            else if(val == Integer.MAX_VALUE) ans[i] = -1;
            else ans[i] = val;
        }

        return ans;
    }
}