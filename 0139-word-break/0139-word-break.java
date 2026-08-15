class Solution {
    boolean func(int i, String s, List<String> wordDict, Boolean[] dp){
        int n = s.length();
        if(i == n) return true;
        if(dp[i] != null) return dp[i];

        boolean ans = false;
        for(int idx = i; idx < n; idx++){
            if(!wordDict.contains(s.substring(i, idx+1))) continue;
            boolean step = func(idx+1, s, wordDict, dp);
            ans = ans || step;
        }
        return dp[i] = ans;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Boolean[] dp = new Boolean[n];
        return func(0,s, wordDict, dp);
    }
}