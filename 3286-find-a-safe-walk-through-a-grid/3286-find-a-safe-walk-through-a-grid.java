class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        if(m == 1 && n == 1 && health >= 2) return true;

        Queue<int[]> q = new LinkedList<>();

        if(grid.get(0).get(0) == 0) q.add(new int[]{0,0,health});
        else q.add(new int[]{0,0,health-1});
        int[][] maxh = new int[m][n];
        for(int i = 0; i < m; i++) Arrays.fill(maxh[i], Integer.MIN_VALUE);
        maxh[0][0] = health;
        
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};
        while(!q.isEmpty()){
            int[] p = q.poll();
            int r = p[0], c = p[1], h = p[2];

            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n){
                    int nexthealth = grid.get(nr).get(nc) == 1 ? h-1: h;
                    if(maxh[nr][nc] < nexthealth){
                        maxh[nr][nc] = nexthealth;
                        q.add(new int[]{nr, nc, maxh[nr][nc]});
                    }
                }
            }
        }

        if(maxh[m-1][n-1] >= 1) return true;
        return false;
    }
}