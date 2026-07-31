class Solution {
    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }

        int LOG = (int)Math.floor(Math.log(n)/Math.log(2)) + 1;
        int[][] up = new int[n][LOG];
        int[] depth = new int[n];
        int[][] count = new int[n][27];

for (int[] row : up) {
            Arrays.fill(row, -1);
        }
        dfs(0, -1, 0, adj, depth, count, up);

        for(int j = 1; j < LOG; j++){
            for(int i = 0; i < n; i++){
                int midnode = up[i][j-1];
                if(midnode != -1) up[i][j] = up[midnode][j-1];
            }
        }
        int[] ans = new int[queries.length];
        int k = 0;
        for(int i = 0; i < queries.length; i++){
            int u = queries[i][0];
            int v = queries[i][1];

            int lca = getlca(u, v, depth, up, LOG);

            int totaledges = depth[u] + depth[v] - 2*depth[lca];
            int maxfreq = 0;
            for(int w = 1; w <= 26; w++){
                int pathcount = count[u][w] + count[v][w] - 2*count[lca][w];
                maxfreq = Math.max(maxfreq, pathcount);
            }

            ans[k++] = totaledges-maxfreq;
        }

        return ans;

    }

    void dfs(int i, int parent , int d, List<List<int[]>> adj, int[] depth, int[][] count, int[][] up){
        depth[i] = d;
        up[i][0] = parent;
        for(int[] it : adj.get(i)){
            int neigh = it[0], we = it[1];
            
            if(neigh != parent){
                for(int w = 1; w <= 26; w++){
                    count[neigh][w] = count[i][w];
                }

                count[neigh][we]++;

                dfs(neigh, i, d+1, adj, depth, count, up);
            }
        }
    }

    int getlca(int u, int v, int[] depth, int[][] up, int LOG){
        if(depth[u] < depth[v]){
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u]-depth[v];
        for(int i = 0; i < LOG; i++){
            if(((diff >> i)&1) == 1){
                u = up[u][i];
            }
        }

        if(u == v) return u;

        for(int i = LOG-1; i >= 0; i--){
            if(up[u][i] != up[v][i]){
                u = up[u][i];
                v = up[v][i];
            }
        }

        return up[u][0];
    }
}