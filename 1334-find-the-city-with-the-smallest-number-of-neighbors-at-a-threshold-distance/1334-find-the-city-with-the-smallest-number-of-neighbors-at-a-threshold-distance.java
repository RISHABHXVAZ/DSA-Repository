class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] matrix = new int[n][n];

        for(int i = 0; i < n; i++) Arrays.fill(matrix[i], Integer.MAX_VALUE);

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            matrix[u][v] = w;
            matrix[v][u] = w;
        }

        for(int k = 0; k < n; k++){

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(matrix[i][k] == Integer.MAX_VALUE || matrix[k][j] == Integer.MAX_VALUE) continue;
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int node = -1;
        for(int i = 0; i < n; i++){
            int cnt = 0;
            for(int j = 0; j < n; j++){
                if(i != j && matrix[i][j] != Integer.MAX_VALUE && matrix[i][j] <= distanceThreshold) cnt++;
            }
            if(cnt <= min){
                min = cnt;
                node = i;
            }
        }

        return node;

    }
}