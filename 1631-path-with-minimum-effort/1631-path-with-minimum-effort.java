class Solution {
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        int[][] efforts = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                efforts[i][j] = Integer.MAX_VALUE;
            }
        }
        efforts[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        pq.add(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int r = pq.peek()[0];
            int c = pq.peek()[1];
            int eff = pq.peek()[2];
            pq.remove();
            
            int dx[] = {-1,1,0,0};
            int dy[] = {0,0,1,-1};
            for(int i = 0; i < 4; i++){
                int nr = r + dx[i];
                int nc = c + dy[i];
                if(nr >= 0 && nr < row && nc >= 0 && nc < col){
                    int diff = Math.max(Math.abs(heights[nr][nc] - heights[r][c]), eff);
                    if(diff < efforts[nr][nc]){
                        efforts[nr][nc] = diff;
                        pq.add(new int[]{nr,nc,efforts[nr][nc]});
                    }
                }
            }
        }
        return efforts[row-1][col-1];
    }
}