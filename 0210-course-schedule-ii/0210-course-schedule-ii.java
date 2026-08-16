class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int i = 0; i < prerequisites.length; i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj.get(v).add(u);
        }

        int[] indegree = new int[n];
        for(int i = 0; i < n; i++){
            for(int node : adj.get(i)){
                indegree[node]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0) q.add(i);
        }

        List<Integer> order = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            order.add(node);
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }

        if(order.size() != n) return new int[0];

        int[] res = new int[n];
        int k = 0;
        for(int num : order){
            res[k++] = num;
        }

        return res;
    }
}