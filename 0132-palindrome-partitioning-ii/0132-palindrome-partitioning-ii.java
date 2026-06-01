class Solution {
    boolean ispalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    int func(int i, int n, String s, int[] dp){
        if(i == n) return 0;
        if(dp[i] != -1) return dp[i];
        dp[i] = Integer.MAX_VALUE;
        int steps = 0;
        for(int k = i; k < n; k++){
            if(ispalindrome(s, i, k)){
                steps = 1 + func(k+1, n, s,dp);
            dp[i] = Math.min(dp[i], steps);
            } 
            
        }
        return dp[i];
    }
    public int minCut(String s) {
        int n = s.length();
        if(n <= 1) return 0;

        int[] dp = new int[n];
        for(int i = 0; i < n; i++) Arrays.fill(dp, -1);
        int ans = func(0, n, s, dp);
        if(ans == Integer.MAX_VALUE) return 0;
        return ans-1;
    }
}