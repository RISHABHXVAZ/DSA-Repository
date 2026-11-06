class Solution {
    long func(int i, long[] dp, int[][] questions){
        if(i >= questions.length) return 0;
        if(dp[i] != -1) return dp[i];

        long take = (long)questions[i][0] + func(i + questions[i][1] + 1, dp, questions);
        long skip = func(i+1, dp, questions);

        return dp[i] = Math.max(take, skip);
    }
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        Arrays.fill(dp, -1);
        return func(0, dp, questions);
    }
}