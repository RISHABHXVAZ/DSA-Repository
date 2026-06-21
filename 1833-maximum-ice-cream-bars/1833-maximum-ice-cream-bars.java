class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) max = Math.max(max, costs[i]);

        int[] freq = new int[max+1];
        for(int i = 0; i < n; i++) freq[costs[i]]++;

        for(int i = 1; i < max+1; i++){
            freq[i] += freq[i-1];
        }

        int[] ans = new int[n];
        for(int i = n-1; i >= 0; i--){
            ans[freq[costs[i]]-1] = costs[i];
            freq[costs[i]]--;
        }

        int ice = 0;
        for(int i = 0; i < n; i++){
            if(ans[i] > coins) break;

            coins -= ans[i];
            ice++;
        }

        return ice;
    }
}