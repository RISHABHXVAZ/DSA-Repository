class Solution {
    boolean dfs2(int node, List<List<Integer>> adj, boolean[] vis, boolean[] sus){
        vis[node] = true;
        if(sus[node]) return false;
        boolean ans = true;
        for(int ngh : adj.get(node)){
          if(!vis[ngh]) {ans = ans && dfs2(ngh, adj, vis, sus);}
        }

        return ans;
    }
    void dfs1(int node, List<List<Integer>> adj, boolean[] sus, boolean[] vis){
        vis[node] = true;
        sus[node] = true;

        for(int ngh: adj.get(node)){
            if(!vis[ngh]) dfs1(ngh, adj, sus, vis);
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < invocations.length; i++){
            int u = invocations[i][0];
            int v = invocations[i][1];

            adj.get(u).add(v);
        }
        boolean[] sus = new boolean[n];
        boolean[] vis = new boolean[n];
        dfs1(k, adj, sus, vis);
        vis = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!sus[i]){
                if(!dfs2(i, adj, vis, sus)){
                    List<Integer> ans = new ArrayList<>();
                    for(int j = 0; j < n; j++){
                        ans.add(j);
                    }

                    return ans;
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(!sus[i]) ans.add(i);
        }

        return ans;
    }
}