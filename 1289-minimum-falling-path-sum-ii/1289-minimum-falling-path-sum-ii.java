class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int prevmin1 = 0;
        int prevmin2 = 0;
        int prevmin1col = -1;
        
        for(int i = 0; i < n; i++){
            int currmin1 = Integer.MAX_VALUE;
            int currmin2 = Integer.MAX_VALUE;
            int currmin1col = -1;
            
            for(int j = 0; j < n; j++){
                int currval = grid[i][j] + (j == prevmin1col ? prevmin2 : prevmin1);
                if(currval < currmin1){
                    currmin2 = currmin1;
                    currmin1 = currval;
                    currmin1col = j;
                }
                else if(currval < currmin2){
                    currmin2 = currval;
                }
            }
            prevmin1 = currmin1;
            prevmin2 = currmin2;
            prevmin1col = currmin1col;
        }

        return prevmin1;
    }
}