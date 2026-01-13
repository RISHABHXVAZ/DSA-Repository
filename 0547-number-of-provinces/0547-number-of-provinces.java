class Solution {
    static void dfs(int i, boolean[] vis, int[][] isConnected){
        vis[i] = true;
        for(int j = 0; j < isConnected[i].length; j++){
            if(isConnected[i][j] == 1 && vis[j] == false){
                dfs(j, vis, isConnected);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                count++;
                dfs(i,vis,isConnected);
            }
        }
        return count;
    }
}