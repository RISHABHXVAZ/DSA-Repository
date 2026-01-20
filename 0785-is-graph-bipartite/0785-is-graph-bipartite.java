class Solution {
    static boolean dfs(int node, int col, int[][] graph, int[] color){
        color[node] = col;
        for(int i = 0; i < graph[node].length; i++){
            int neigh = graph[node][i];
            if(color[neigh] == -1){
                if(!dfs(neigh, 1-col, graph, color)){
                    return false;
                }
            }
            else if(color[neigh] == col) return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for(int i = 0; i < graph.length; i++) color[i] = -1;
        
        for(int i = 0; i < graph.length; i++){
            if(color[i] == -1){
                if(!dfs(i,0,graph,color)){
                    return false;
                }
            }
        }
        return true;
    }
}