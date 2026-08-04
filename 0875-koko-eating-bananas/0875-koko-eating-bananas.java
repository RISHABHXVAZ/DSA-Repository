class Solution {
    int hours(int[] piles, int k){
        int h = 0;

        for(int i = 0; i < piles.length; i++){
           h += Math.ceil((double)piles[i]/k);
        }

        return h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        
        int max = -1;
        for(int i = 0; i < n; i++){
            max = Math.max(max, piles[i]);
        }

        int low = 1, high = max;
        int ans = 0;
        Arrays.sort(piles);
        while(low <= high){
            int mid = low + (high-low)/2;
            if(hours(piles, mid) <= h){
                ans = mid;
                high = mid-1;
            }else low = mid+1;
        }

        return ans;
    }
}