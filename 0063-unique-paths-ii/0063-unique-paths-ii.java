class Solution {
    int func(int i, int j, int[][] arr, int[][] dp){
        int m = arr.length;
        int n = arr[0].length;
        if(i >= m || j >= n) return 0;
        if(i == m-1 && j == n-1) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        int right = 0;
        if(j+1 < n && arr[i][j+1] == 0){
            right = func(i,j+1,arr,dp);
        }
        int down = 0;
        if(i+1 < m && arr[i+1][j] == 0){
            down = func(i+1,j,arr,dp);
        }

        return dp[i][j] = right+down;
    }
    public int uniquePathsWithObstacles(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        if(arr[0][0] == 1) return 0;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }
        return func(0,0,arr,dp);
    }
}