class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       List<List<Integer>> adj = new ArrayList<>();
       for(int i = 0; i < numCourses; i++){
        adj.add(new ArrayList<>());
       } 
       for(int i = 0; i < prerequisites.length; i++){
        adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
       }

       int[] indegree = new int[numCourses];
       for(int i = 0; i < numCourses; i++){
        for(int j : adj.get(i)){
            indegree[j]++;
        }
       }
        Queue<Integer> q = new LinkedList<>();
       for(int i = 0; i < numCourses; i++){
        if(indegree[i] == 0) q.add(i);
       }
       int cnt = 0;
       while(!q.isEmpty()){
        int node = q.poll();
        cnt++;
        for(int it: adj.get(node)){
            indegree[it]--;
            if(indegree[it] == 0) q.add(it);
        }
       }
       if(cnt != numCourses) return false;
       return true;
    }
}