class Solution {
    int timer = 1;
    void dfs(int node, int parent, boolean[] vis, List<List<Integer>> adj, int[] tin, int[] low, List<List<Integer>> bridges){
        vis[node] = true;
        low[node] = tin[node] = timer;
        timer++;
        for(int it: adj.get(node)){
            if(it == parent) continue;
            if(!vis[it]){
                dfs(it, node, vis, adj, tin, low, bridges);
                low[node] = Math.min(low[it], low[node]);
                if(low[it] > tin[node]){
                    bridges.add(Arrays.asList(it, node));
                }
            }else{
                low[node] = Math.min(low[it], low[node]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(List<Integer> edges: connections){
            int u = edges.get(0);
            int v = edges.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0,-1,vis,adj,tin,low,bridges);
        return bridges;
    }
}