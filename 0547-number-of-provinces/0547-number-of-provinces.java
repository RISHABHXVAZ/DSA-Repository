class Solution {
    static void bfs(int node, boolean[] vis, int[][] isConnected){
        int n = isConnected.length;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;
        while(!q.isEmpty()){
            int v = q.poll();
            for(int i = 0; i < n; i++){
                if(isConnected[v][i] == 1 && vis[i] == false){
                    q.add(i);
                    vis[i] = true;
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean vis[] = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                count++;
                bfs(i,vis, isConnected);
            }
        }
        return count;
    }
}