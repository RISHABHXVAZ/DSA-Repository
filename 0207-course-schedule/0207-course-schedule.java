class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adj.get(v).add(u);
        }

        int[] indegree = new int[n];
        for(int i = 0; i < adj.size(); i++){
            for(int v : adj.get(i)){
                indegree[v]++;
            }
        }

        for(int i = 0; i < n; i++){
            if(indegree[i] == 0) q.add(i);
        }

        List<Integer> temp = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            temp.add(node);

            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }

        return temp.size() == n;

    }
}