class Solution {
    int func(int i, int j, int[] arr, int[][] dp){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int ans = Integer.MIN_VALUE;
        for(int k = i; k <= j; k++){
            int steps = arr[i-1]*arr[k]*arr[j+1] + func(i, k-1, arr, dp) + func(k+1, j, arr, dp);
            ans = Math.max(ans, steps);
        }

        return dp[i][j] = ans;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;
        for(int i = 1; i <= n; i++){
            arr[i] = nums[i-1];
        }

        int[][] dp = new int[n+2][n+2];
        for(int i = 0; i < n+2; i++) Arrays.fill(dp[i], -1);

        return func(1, n, arr, dp);
    }
}