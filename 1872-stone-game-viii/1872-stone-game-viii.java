class Solution {
    int func(int i, int[] pref){
        int n = pref.length;
        if(i == n-1) return pref[n-1];

        int op1 = pref[i] - func(i+1, pref);
        int op2 = func(i+1, pref);

        return (int)Math.max(op1, op2);
    }
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        
        int[] pref = new int[n];
        pref[0] = stones[0];
        for(int i = 1; i < n; i++){
            pref[i] = pref[i-1] + stones[i];
        }

        int dp = pref[n-1];

        for(int i = n-2; i >= 1; i--){
            dp = Math.max(dp, pref[i] - dp);
        }

        return dp;
        
    }
}