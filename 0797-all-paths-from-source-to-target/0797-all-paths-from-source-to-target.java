class Solution {
    void dfs(int node, int goal,List<List<Integer>> adj, List<Integer> temp, List<List<Integer>> ans){

        temp.add(node);
        if(node == goal){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int it: adj.get(node)){
            dfs(it, goal, adj, temp, ans);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < graph.length; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[i].length; j++){
                adj.get(i).add(graph[i][j]);
            }
        }
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, graph.length-1, adj, temp, ans);
        return ans;
    }
}