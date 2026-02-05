class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        Map<Integer, int[]> mpp = new HashMap<>();
        mpp.put(1, new int[]{0,1});
        mpp.put(2, new int[]{0,-1});
        mpp.put(3, new int[]{1,0});
        mpp.put(4, new int[]{-1,0});
        int[][] cost = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        cost[0][0] = 0;
        pq.add(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int cst = pq.peek()[0];
            int r = pq.peek()[1];
            int c = pq.peek()[2];
            vis[r][c] = true;
            pq.remove();
            int val = grid[r][c];
     for(int i = 1; i <= 4; i++){

                int nr = r + mpp.get(i)[0];
                int nc = c + mpp.get(i)[1];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n){

                    int newCost = cst + (i == val ? 0 : 1);

                    if(newCost < cost[nr][nc]){
                        cost[nr][nc] = newCost;
                        pq.add(new int[]{newCost, nr, nc});
                    }
                }
            }
            }

        return cost[m-1][n-1];
}}