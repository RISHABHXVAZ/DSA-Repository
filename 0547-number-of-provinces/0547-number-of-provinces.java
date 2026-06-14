class Solution {
    void dfs(int node, List<List<Integer>> adj, boolean[] vis){
        vis[node] = true;
        for(int neigh : adj.get(node)){
            if(!vis[neigh]) dfs(neigh, adj, vis);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean[] vis = new boolean[n];
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                ans++;
                dfs(i, adj, vis);
            }
        }
        return ans;
    }
}