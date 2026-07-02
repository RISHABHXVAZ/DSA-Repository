class Solution {
    int timer = 0;
    void dfs(int node, int parent, int[] low, int[] tin, boolean[] vis, List<List<Integer>> adj, List<List<Integer>> ans){
        vis[node] = true;
        low[node] = tin[node] = timer;
        timer++;

        for(int it: adj.get(node)){
            if(it == parent) continue;
            if(!vis[it]){
                dfs(it, node, low, tin, vis, adj, ans);
                low[node] = Math.min(low[node], low[it]);

                //node--------it      can we remove it? 
                if(low[it] > tin[node]){
                    ans.add(Arrays.asList(node, it));
                }
                }
                else{
                    low[node] = Math.min(low[node], low[it]);
                }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < connections.size(); i++){
            List<Integer> temp = connections.get(i);
            int u = temp.get(0);
            int v = temp.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        List<List<Integer>> ans = new ArrayList<>();
        int[] tin = new int[n];
        int[] low = new int[n];
        boolean[] vis = new boolean[n];

        dfs(0, -1, low, tin, vis, adj, ans);

        return ans;
    }
}