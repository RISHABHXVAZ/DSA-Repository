class Solution {
    int func(int i, int n, boolean[] vis){
        if(i == n) return 1;    
        
        int sum = 0;
        for(int k = 1; k <= n; k++){
            if(!vis[k] && (k%(i+1) == 0 || (i+1) % k == 0)){
                vis[k] = true;
                sum += func(i+1, n, vis);
                vis[k] = false;
            }
        }

        return sum;
    }
    public int countArrangement(int n) {
        boolean[] vis = new boolean[n+1];
        return func(0, n, vis);
    }
}