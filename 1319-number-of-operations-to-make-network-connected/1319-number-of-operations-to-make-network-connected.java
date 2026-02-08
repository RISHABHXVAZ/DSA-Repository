class Solution {
    void bfs(int node, List<List<Integer>> adj, boolean[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;
        while(!q.isEmpty()){
            int n = q.poll();
            for(int it: adj.get(n)){
                if(!vis[it]){
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        return;
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < connections.length; i++){
            int u = connections[i][0];
            int v = connections[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        int components = 0;
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                bfs(i,adj,vis);
                components++;
            }
        }
        return components-1;

    }
}