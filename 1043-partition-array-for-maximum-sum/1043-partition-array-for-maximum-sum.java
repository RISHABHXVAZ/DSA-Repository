class Solution {
    int func(int i, int j, int x, int[] arr, int[] dp){
        if(i > j) return 0;
        if(dp[i] != -1) return dp[i];
        int maxval = arr[i];
        int steps = 0;
        dp[i] = Integer.MIN_VALUE;
        for(int k = i; k < i + x && k <= j; k++){
            maxval = Math.max(maxval, arr[k]);
            steps = (k-i+1)*maxval + func(k+1, j, x, arr, dp);
            dp[i] = Math.max(dp[i], steps);
        }
        return dp[i];
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) Arrays.fill(dp, -1);
        return func(0, n-1, k, arr, dp);
    }
}