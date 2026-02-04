class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] cost = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) cost[i][j] = 0;
                else cost[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int cst = edges[i][2];
            cost[u][v] = cst;
            cost[v][u] = cst;
        }

        for(int via = 0; via < n; via++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(cost[i][via] != Integer.MAX_VALUE && cost[via][j] != Integer.MAX_VALUE){
                        cost[i][j] = Math.min(cost[i][j], cost[i][via] + cost[via][j]);
                    }
                }
            }
        }
        int mincount = Integer.MAX_VALUE;
        int node = -1;
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(i != j && cost[i][j] <= distanceThreshold) count++;
            }
            if(count <= mincount){
                mincount = count;
                node = i;
            }
        }
        return node;
    }
}