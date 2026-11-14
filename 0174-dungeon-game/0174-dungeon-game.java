class Solution {
    int func(int i, int j, int[][] dungeon, int[][] dp){
        int m = dungeon.length;
        int n = dungeon[0].length;
        if(i == m-1 && j == n-1){
            if(dungeon[i][j] >= 0) return 1;
            else return 1 - dungeon[i][j];
        }
        if(i >= m || j >= n) return (int)1e9;
        if(dp[i][j] != -1) return dp[i][j];
        int right = func(i,j+1,dungeon,dp);
        int down = func(i+1, j, dungeon,dp);
        return dp[i][j] = (int)Math.max(1, Math.min(right, down) - dungeon[i][j]);
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }
        return func(0,0,dungeon,dp);
    }
}