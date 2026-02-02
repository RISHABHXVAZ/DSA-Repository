class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n+1; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < times.length; i++){
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            adj.get(u).add(new int[]{v,w});
        }
        int time[] = new int[n+1];
        for(int i = 1; i <= n; i++){
            time[i] = Integer.MAX_VALUE;
        }
        time[k] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{k,0});
        while(!q.isEmpty()){
            int node = q.peek()[0];
            int t = q.peek()[1];
            q.remove();
            for(int[] it: adj.get(node)){
                if(it[1] + t < time[it[0]]){
                    time[it[0]] = it[1] + t;
                    q.add(new int[]{it[0],time[it[0]]});
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            if(time[i] == Integer.MAX_VALUE) return -1;
            if(time[i] > max) max = time[i];
        }
        return max;
    }
}