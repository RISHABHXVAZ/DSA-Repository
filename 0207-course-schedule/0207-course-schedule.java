class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adj.get(v).add(u);
        }

        int[] indegree = new int[n];
        for(int i = 0; i < n; i++){
            for(int num : adj.get(i)){
                indegree[num]++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);

            for(int ngh : adj.get(node)){
                indegree[ngh]--;
                if(indegree[ngh] == 0) q.add(ngh);
            }
        }

        return ans.size() == n;
    }
}