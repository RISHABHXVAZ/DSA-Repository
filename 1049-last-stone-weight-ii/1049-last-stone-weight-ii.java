class Solution {
    int func(int i, int target, int[] stones, int[][] dp){
        if(i == stones.length) return 0;
        if(dp[i][target] != -1) return dp[i][target];
        int take = 0;
        if(stones[i] <= target) take = stones[i] + func(i+1, target-stones[i], stones, dp);
        int skip = func(i+1, target, stones, dp);
        return dp[i][target] = Math.max(take, skip);
    }
    public int lastStoneWeightII(int[] stones) {

        //lets say you have stones a, b, c, d
        //smash b with c , you get b-c
        //then smash with a, you get b-c-a or a-b+c
        //if we repeat this for all the stones then each stones get an alternating + or - sign in options available
        //(a+b+c+.....) - (m+n+o+.....)
        //so ultimately there will be two sets of elements S1 and S2 whose total sum = T
        //S1 + S2 = T
        //we need to minimize S2-S1 to get the answer
        //putting S2 = T-S1 -> T-2*S1
        //to minimize this, we need S1 as large as possible 
        //ideally we want to make S1 = T/2 but we want to reach as closely as possible
        //so set the target as T/2 and search for a subset
        //once you get S1 then answer will be T-2*S1
        
        int n = stones.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += stones[i];
        }
        int target = sum/2;
        int[][] dp = new int[n][target+1];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        int s1 = func(0, target, stones, dp);
        return sum - 2*s1;
    }
}