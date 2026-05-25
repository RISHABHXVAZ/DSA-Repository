class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int b = 0, s = 0;
        int ans = Integer.MIN_VALUE;
        while(s < n){
            if(prices[s] - prices[b] > ans){
                ans = prices[s] - prices[b];
            }else{
                if(prices[s] < prices[b]) b = s;
            }
            s++;
        }
        return ans;
    }
}