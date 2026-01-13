class Solution {
    
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        int cntFresh = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) cntFresh++;
                if(grid[i][j] == 2) q.add(new int[]{i,j});
            }
        }
        
        while(!q.isEmpty() && cntFresh > 0){
            int size = q.size();
            time++;
            int[] dx = {1,-1,0,0};
            int[] dy = {0,0,1,-1};
            for(int i = 0; i < size; i++){
                int[] point = q.poll();
                for(int j = 0; j < 4; j++){
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];
                    if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length){
                        if(grid[x][y] == 1){
                            cntFresh--;
                            grid[x][y] = 2;
                            q.add(new int[]{x,y});
                        }
                    }
                }                
            }
        }

        if(cntFresh <= 0) return time;
        else return -1;        
    }
}