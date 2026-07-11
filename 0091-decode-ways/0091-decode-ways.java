class Solution {
    int func(int i, String s, int n, int[] dp){
        if(i == n) return 1;
        if(s.charAt(i) == '0') return 0;

        if(dp[i] != -1) return dp[i];

        int op1 = func(i+1, s, n, dp);
        int op2 = i+1 < n && Integer.parseInt(s.substring(i, i+2)) <= 26 ? func(i+2, s, n, dp) : 0;

        return dp[i] = op1 + op2;
    }
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return func(0, s, n, dp);
    }
}