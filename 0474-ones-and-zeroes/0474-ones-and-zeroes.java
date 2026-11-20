class Solution {
    int func(int i, int m, int n, int[][] arr, int[][][] dp){
        if(i == arr.length){
            return 0;
        }
        if(dp[i][m][n] != -1) return dp[i][m][n];
        int take = 0;
        if(arr[i][0] <= m && arr[i][1] <= n){
            take = 1 + func(i+1, m-arr[i][0], n-arr[i][1], arr, dp);
        }
        int skip = func(i+1, m, n, arr, dp);
        return dp[i][m][n] = (int)Math.max(take, skip);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        int[][] arr = new int[l][2];
        for(int i = 0; i < l; i++){
            int c0 = 0;
            for(int j = 0; j < strs[i].length(); j++){
                char ch = strs[i].charAt(j);
                if(ch == '0') c0++;
            }
            arr[i][0] = c0;
            arr[i][1] = strs[i].length()-c0;
        }

        int[][][] dp = new int[l][m+1][n+1];
        for(int i = 0; i < l; i++){
            for(int j = 0; j <= m; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return func(0, m, n, arr, dp);
    }
}