class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = Integer.MAX_VALUE, sell = Integer.MIN_VALUE;
        int max = 0;
        for(int i = 0; i < n; i++){
            if(prices[i] < buy){ 
                buy = prices[i];
                sell = 0;
                continue;
            }

            if(prices[i] > sell) sell = prices[i];
            max = Math.max(max, sell-buy);
        }

        return max;
        
    }
}