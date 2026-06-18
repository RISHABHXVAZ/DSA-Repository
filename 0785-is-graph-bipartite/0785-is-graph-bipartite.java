class Solution {
    boolean dfs(int node, int col, int[][] graph, int[] color){
        color[node] = col;

        for(int i = 0; i < graph[node].length; i++){
            int ngh = graph[node][i];
            if(color[ngh] == col) return false;

            if(color[ngh] == -1 && !dfs(ngh, 1 - col, graph, color)) return false;
        }

        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] color = new int[n];
        Arrays.fill(color, -1);

        for(int i = 0; i < n; i++){
            if(color[i] == -1){
                if(!dfs(i, 0, graph, color)) return false;
            }
        }

        return true;
    }
}