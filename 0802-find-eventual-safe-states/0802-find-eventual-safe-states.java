class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> out = new ArrayList<>();
        int n = graph.length;
        for(int i = 0;i < n;i++){
            out.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < graph[i].length; j++){
                out.get(graph[i][j]).add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        int[] outdegree = new int[n];
        for(int i = 0; i < n; i++){
            for(int it: out.get(i)){
                outdegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(outdegree[i] == 0) q.add(i);
        }
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            for(int it: out.get(node)){
                outdegree[it]--;
                if(outdegree[it] == 0) q.add(it);
            }
        }
        Collections.sort(topo);
        return topo;
    }
}