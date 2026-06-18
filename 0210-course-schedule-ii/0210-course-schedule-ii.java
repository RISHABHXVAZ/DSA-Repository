class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int i = 0; i < prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adj.get(v).add(u);
        }

        List<Integer> temp = new ArrayList<>();
        int[] indegree = new int[n];

        for(int i = 0; i < n; i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()){
            int node = q.poll();
            temp.add(node);
            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }

        if(temp.size() != n) return new int[0];

        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = temp.get(i);
        }
        return ans;
    }
}