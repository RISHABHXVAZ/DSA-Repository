class Solution {
    int hours(int[] piles, int k){
        int h = 0;
        for(int i = 0; i < piles.length; i++){
            h += Math.ceil(piles[i]/(double)k);
        }

        return h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        
        int low = 0, high = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            high = Math.max(high, piles[i]);
        }

        int ans = 0;
        while(low <= high){
            int mid = low + (high-low)/2;
            int hrs = hours(piles, mid);
            if(hrs <= h){
                ans = mid;
                high = mid-1;
            }else low = mid+1;
        }

        return ans;
    }
}