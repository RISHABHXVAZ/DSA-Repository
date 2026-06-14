class Solution {
    int bfs(Queue<int[]> q, int[][] grid){
        int time = 0;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        while(!q.isEmpty()){
            int size = q.size();
            time++;
            for(int i = 0; i < size; i++){
                int[] p = q.poll();
                for(int j = 0; j < 4; j++){
                    int nx = p[0] + dx[j];
                    int ny = p[1] + dy[j];
                    if(nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 1){
                        grid[nx][ny] = 2;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return time > 0? time-1: 0;
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
            }
        }

        int time = bfs(q, grid);

        for(int i = 0; i < m; i++){
            for(int num : grid[i]){
                if(num == 1) return -1;
            }
        }
        return time;
    }
}